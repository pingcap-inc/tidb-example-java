package com.pingcap.txn;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.*;

public class PessimisticTxnExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(PessimisticTxnExample.class);

    public static void main(String[] args) throws SQLException, InterruptedException {
        int aliceQuantity = Integer.parseInt(System.getenv().getOrDefault("ALICE_NUM", "4"));
        int bobQuantity = Integer.parseInt(System.getenv().getOrDefault("BOB_NUM", "6"));

        HikariDataSource ds = createHikariDataSourceByEnv();

        // prepare data
        Connection connection = ds.getConnection();
        recreateUsersTable(connection);
        recreateBooksTable(connection);
        recreateOrdersTable(connection);
        createBook(connection, 1L, "Designing Data-Intensive Application", "Science & Technology",
                Timestamp.valueOf("2018-09-01 00:00:00"), new BigDecimal(100), 10);
        createUser(connection, 1L, "Bob", new BigDecimal(10000));
        createUser(connection, 2L, "Alice", new BigDecimal(10000));

        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        final int finalBobQuantity = bobQuantity;
        threadPool.execute(() -> {
            buy(ds, 1, 1000L, 1L, 1L, finalBobQuantity);
            countDownLatch.countDown();
        });
        final int finalAliceQuantity = aliceQuantity;
        threadPool.execute(() -> {
            buy(ds, 2, 1001L, 1L, 2L, finalAliceQuantity);
            countDownLatch.countDown();
        });

        countDownLatch.await(5, TimeUnit.SECONDS);
        System.exit(0);
    }

    public static void buy (HikariDataSource ds, Integer threadID,
                            Long orderID, Long bookID, Long userID, Integer quantity) {
        String txnComment = "/* txn {} */ ";
        if (threadID != 1) {
            txnComment = "    " + txnComment;
        }
        LOGGER.info("user {} try to buy {} books, book id: {}", userID, quantity, bookID);

        try (Connection connection = ds.getConnection()) {
            try {
                connection.setAutoCommit(false);
                connection.createStatement().executeUpdate("begin pessimistic");
                LOGGER.info(txnComment + "begin pessimistic", threadID);

                // waiting for other thread ran the 'begin pessimistic' statement
                TimeUnit.SECONDS.sleep(1);

                BigDecimal price = null;

                // read price of book
                PreparedStatement selectBook = connection.prepareStatement("select price from books where id = ? for update");
                selectBook.setLong(1, bookID);
                ResultSet res = selectBook.executeQuery();
                LOGGER.info(txnComment + "select price from books where id = {} for update", threadID, bookID);
                if (!res.next()) {
                    throw new RuntimeException("book not exist");
                } else {
                    price = res.getBigDecimal("price");
                }

                // update book
                String updateBookSQL = "update `books` set stock = stock - ? where id = ? and stock - ? >= 0";
                PreparedStatement updateBook = connection.prepareStatement(updateBookSQL);
                updateBook.setInt(1, quantity);
                updateBook.setLong(2, bookID);
                updateBook.setInt(3, quantity);
                int affectedRows = updateBook.executeUpdate();
                LOGGER.info(txnComment + "update `books` set stock = stock - {} where id = {} and stock - {} >= 0",
                        threadID, quantity, bookID, quantity);

                if (affectedRows == 0) {
                    // stock not enough, rollback
                    connection.createStatement().executeUpdate(txnComment + "rollback");
                    LOGGER.info(txnComment + "rollback", threadID);
                    return;
                }

                // insert order
                String insertOrderSQL = "insert into `orders` (`id`, `book_id`, `user_id`, `quality`) values (?, ?, ?, ?)";
                PreparedStatement insertOrder = connection.prepareStatement(insertOrderSQL);
                insertOrder.setLong(1, orderID);
                insertOrder.setLong(2, bookID);
                insertOrder.setLong(3, userID);
                insertOrder.setInt(4, quantity);
                insertOrder.executeUpdate();
                LOGGER.info(txnComment + "insert into `orders` (`id`, `book_id`, `user_id`, `quality`) values ({}, {}, {}, {})",
                        threadID, orderID, bookID, userID, quantity);

                // update user
                String updateUserSQL = "update `users` set `balance` = `balance` - ? where id = ?";
                PreparedStatement updateUser = connection.prepareStatement(updateUserSQL);
                updateUser.setBigDecimal(1, price.multiply(new BigDecimal(quantity)));
                updateUser.setLong(2, userID);
                updateUser.executeUpdate();
                LOGGER.info(txnComment + "update `users` set `balance` = `balance` - {} where id = {}",
                        threadID, price.multiply(new BigDecimal(quantity)), userID);

                connection.createStatement().executeUpdate("commit");
                LOGGER.info(txnComment + "commit", threadID);
                LOGGER.info("user {} buy {} books(id: {}) successfully", userID, quantity, bookID);
            } catch (Exception e) {
                connection.createStatement().executeUpdate("rollback");
                LOGGER.info(txnComment + "rollback", threadID);
                LOGGER.info("user {} fail to buy {} books(id: {}) because {} error", userID, quantity, bookID, e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static HikariDataSource createHikariDataSourceByEnv() {
        // 1. Get TiDB connection properties from environment variables.
        // 1. Get TiDB connection properties from environment variables.
        String tidbJDBCURL = System.getenv().getOrDefault("TIDB_JDBC_URL", "jdbc:mysql://localhost:4000/test");
        String tidbUser = System.getenv().getOrDefault("TIDB_USER", "root");
        String tidbPassword = System.getenv().getOrDefault("TIDB_PASSWORD", "");

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(tidbJDBCURL);
        ds.setUsername(tidbUser);
        ds.setPassword(tidbPassword);

        return ds;
    }

    public static void recreateOrdersTable(Connection connection) throws SQLException {
        connection.prepareStatement("DROP TABLE IF EXISTS `orders`").execute();
        connection.prepareStatement("""
        CREATE TABLE `orders` (
          `id` bigint(20) NOT NULL,
          `book_id` bigint(20) NOT NULL,
          `user_id` bigint(20) NOT NULL,
          `quality` tinyint(4) NOT NULL,
          `ordered_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          PRIMARY KEY (`id`) /*T![clustered_index] CLUSTERED */,
          KEY `orders_book_id_idx` (`book_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
        """).execute();
    }

    public static void recreateUsersTable(Connection connection) throws SQLException {
        connection.prepareStatement("DROP TABLE IF EXISTS `users`").execute();
        connection.prepareStatement("""
        CREATE TABLE `users` (
          `id` bigint(20) NOT NULL,
          `balance` decimal(15,2) DEFAULT '0.0',
          `nickname` varchar(100) NOT NULL,
          PRIMARY KEY (`id`) /*T![clustered_index] CLUSTERED */,
          UNIQUE KEY `nickname` (`nickname`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
        """).execute();
    }

    public static void recreateBooksTable(Connection connection) throws SQLException {
        connection.prepareStatement("DROP TABLE IF EXISTS `books`").execute();
        connection.prepareStatement("""
        CREATE TABLE `books` (
          `id` bigint(20) NOT NULL,
          `title` varchar(100) NOT NULL,
          `type` enum('Magazine','Novel','Life','Arts','Comics','Education & Reference','Humanities & Social Sciences','Science & Technology','Kids','Sports') NOT NULL,
          `published_at` datetime NOT NULL,
          `stock` int(11) DEFAULT '0',
          `price` decimal(15,2) DEFAULT '0.0',
          PRIMARY KEY (`id`) /*T![clustered_index] CLUSTERED */
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
        """).execute();
    }

    public static void createUser(Connection connection, Long id, String nickname, BigDecimal balance) throws SQLException  {
        PreparedStatement insert = connection.prepareStatement(
                "INSERT INTO `users` (`id`, `nickname`, `balance`) VALUES (?, ?, ?)");
        insert.setLong(1, id);
        insert.setString(2, nickname);
        insert.setBigDecimal(3, balance);
        insert.executeUpdate();
    }

    public static void createBook(Connection connection, Long id, String title, String type, Timestamp publishedAt, BigDecimal price, Integer stock) throws SQLException {
        PreparedStatement insert = connection.prepareStatement(
                "INSERT INTO `books` (`id`, `title`, `type`, `published_at`, `price`, `stock`) values (?, ?, ?, ?, ?, ?)");
        insert.setLong(1, id);
        insert.setString(2, title);
        insert.setString(3, type);
        insert.setTimestamp(4, publishedAt);
        insert.setBigDecimal(5, price);
        insert.setInt(6, stock);

        insert.executeUpdate();
    }
}
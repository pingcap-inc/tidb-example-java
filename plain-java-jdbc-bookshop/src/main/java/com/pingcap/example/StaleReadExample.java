package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaleReadExample {
  public static class StaleReadHelper{

    public static void startTxnWithStaleRead(Connection conn, Integer seconds) throws SQLException {
      conn.setAutoCommit(false);
      PreparedStatement stmt = conn.prepareStatement(
          "START TRANSACTION READ ONLY AS OF TIMESTAMP NOW() - INTERVAL ? SECOND;"
      );
      stmt.setInt(1, seconds);
      stmt.execute();
    }

    public static void setTxnWithStaleRead(Connection conn, Integer seconds) throws SQLException {
      PreparedStatement stmt = conn.prepareStatement(
          "SET TRANSACTION READ ONLY AS OF TIMESTAMP NOW() - INTERVAL ? SECOND;"
      );
      stmt.setInt(1, seconds);
      stmt.execute();
    }

    public static void enableStaleReadOnSession(Connection conn, Integer seconds) throws SQLException {
      PreparedStatement stmt = conn.prepareStatement(
          "SET @@tidb_read_staleness= ?;"
      );
      stmt.setString(1, String.format("-%d", seconds));
      stmt.execute();
    }

    public static void disableStaleReadOnSession(Connection conn) throws SQLException {
      PreparedStatement stmt = conn.prepareStatement(
          "SET @@tidb_read_staleness=\"\";"
      );
      stmt.execute();
    }

  }

  public static class BookDAO {
    private final MysqlDataSource ds;

    BookDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Book> getTop5LatestBooks() throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
                SELECT id, title, type, price FROM books ORDER BY published_at DESC LIMIT 5;
                """);
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setType(rs.getString("type"));
          book.setPrice(rs.getDouble("price"));
          books.add(book);
        }
      }
      return books;
    }

    public void updateBookPriceByID(Long id, Double price) throws SQLException {
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("""
                UPDATE books SET price = ? WHERE id = ?;
                """);
        stmt.setDouble(1, price);
        stmt.setLong(2, id);
        int affects = stmt.executeUpdate();
        if (affects == 0) {
          throw new SQLException("Failed to update the book with id: " + id);
        }
      }
    }

    public List<Book> getTop5LatestBooksWithStaleRead(Integer seconds) throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("""
        SELECT id, title, type, price FROM books AS OF TIMESTAMP NOW() - INTERVAL ? SECOND ORDER BY published_at DESC LIMIT 5;
        """);
        stmt.setInt(1, seconds);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setType(rs.getString("type"));
          book.setPrice(rs.getDouble("price"));
          books.add(book);
        }
      } catch (SQLException e) {
        if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 1105) {
          System.out.println("WARN: cannot set read timestamp to a future time.");
        } else if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 9006) {
          System.out.println("WARN: GC life time is shorter than transaction duration.");
        } else {
          throw e;
        }
      }
      return books;
    }

    public List<Book> getTop5LatestBooksWithTxnStaleRead(Integer seconds) throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        // Start a read only transaction.
        StaleReadHelper.startTxnWithStaleRead(conn, seconds);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
        SELECT id, title, type, price FROM books ORDER BY published_at DESC LIMIT 5;
        """);
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setType(rs.getString("type"));
          book.setPrice(rs.getDouble("price"));
          books.add(book);
        }

        // Commit transaction.
        conn.commit();
      } catch (SQLException e) {
        if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 1105) {
          System.out.println("WARN: cannot set read timestamp to a future time.");
        } else if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 9006) {
          System.out.println("WARN: GC life time is shorter than transaction duration.");
        } else {
          throw e;
        }
      }
      return books;
    }

    public List<Book> getTop5LatestBooksWithTxnStaleRead2(Integer seconds) throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        // Start a transaction.
        conn.setAutoCommit(false);

        // Set next transaction as a read only transaction with stale read.
        StaleReadHelper.setTxnWithStaleRead(conn, seconds);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
        SELECT id, title, type, price FROM books ORDER BY published_at DESC LIMIT 5;
        """);
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setType(rs.getString("type"));
          book.setPrice(rs.getDouble("price"));
          books.add(book);
        }

        // Commit transaction.
        conn.commit();
      } catch (SQLException e) {
        if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 1105) {
          System.out.println("WARN: cannot set read timestamp to a future time.");
        } else if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 9006) {
          System.out.println("WARN: GC life time is shorter than transaction duration.");
        } else {
          throw e;
        }
      }
      return books;
    }

    public List<Book> getTop5LatestBooksWithSessionStaleRead(Integer seconds) throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        // Enable.
        StaleReadHelper.enableStaleReadOnSession(conn, seconds);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
        SELECT id, title, type, price FROM books ORDER BY published_at DESC LIMIT 5;
        """);
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setType(rs.getString("type"));
          book.setPrice(rs.getDouble("price"));
          books.add(book);
        }

        // Disable.
        StaleReadHelper.disableStaleReadOnSession(conn);
      } catch (SQLException e) {
        if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 1105) {
          System.out.println("WARN: cannot set read timestamp to a future time.");
        } else if ("HY000".equals(e.getSQLState()) && e.getErrorCode() == 9006) {
          System.out.println("WARN: GC life time is shorter than transaction duration.");
        } else {
          throw e;
        }
      }
      return books;
    }

  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data
    BookDAO bookDAO = new BookDAO(datasource);

    // 3. Run examples.
    runStaleReadOnStatementExample(bookDAO);
    runStaleReadOnTxnExample1(bookDAO);
    runStaleReadOnTxnExample2(bookDAO);
    runStaleReadOnSessionExample(bookDAO);
  }

  public static void runStaleReadOnStatementExample(BookDAO bookDAO) throws SQLException {
    System.out.println("[Running stale read on statement example]");
    List<Book> top5LatestBooks = bookDAO.getTop5LatestBooks();

    if (top5LatestBooks.size() > 0) {
      System.out.println("The latest book price (before update): " + top5LatestBooks.get(0).getPrice());

      Book book = top5LatestBooks.get(0);
      bookDAO.updateBookPriceByID(book.getId(), book.getPrice() + 10);

      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after update): " + top5LatestBooks.get(0).getPrice());

      // Use the stale read.
      top5LatestBooks = bookDAO.getTop5LatestBooksWithStaleRead(5);
      System.out.println("The latest book price (maybe stale): " + top5LatestBooks.get(0).getPrice());

      // Try to stale read the data at the future time.
      bookDAO.getTop5LatestBooksWithStaleRead(-5);

      // Try to stale read the data before 20 minutes.
      bookDAO.getTop5LatestBooksWithStaleRead(20 * 60);
    }
  }

  public static void runStaleReadOnTxnExample1(BookDAO bookDAO) throws SQLException {
    System.out.println("[Running stale read on transaction example 1]");
    List<Book> top5LatestBooks = bookDAO.getTop5LatestBooks();

    if (top5LatestBooks.size() > 0) {
      System.out.println("The latest book price (before update): " + top5LatestBooks.get(0).getPrice());

      Book book = top5LatestBooks.get(0);
      bookDAO.updateBookPriceByID(book.getId(), book.getPrice() + 10);

      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after update): " + top5LatestBooks.get(0).getPrice());

      // Use the stale read.
      top5LatestBooks = bookDAO.getTop5LatestBooksWithTxnStaleRead(5);
      System.out.println("The latest book price (maybe stale): " + top5LatestBooks.get(0).getPrice());

      // After the stale read transaction is committed.
      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after the transaction commit): " + top5LatestBooks.get(0).getPrice());
    }
  }

  public static void runStaleReadOnTxnExample2(BookDAO bookDAO) throws SQLException {
    System.out.println("[Running stale read on transaction example 2]");
    List<Book> top5LatestBooks = bookDAO.getTop5LatestBooks();

    if (top5LatestBooks.size() > 0) {
      System.out.println("The latest book price (before update): " + top5LatestBooks.get(0).getPrice());

      Book book = top5LatestBooks.get(0);
      bookDAO.updateBookPriceByID(book.getId(), book.getPrice() + 10);

      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after update): " + top5LatestBooks.get(0).getPrice());

      // Use the stale read.
      top5LatestBooks = bookDAO.getTop5LatestBooksWithTxnStaleRead2(5);
      System.out.println("The latest book price (maybe stale): " + top5LatestBooks.get(0).getPrice());

      // After the stale read transaction is committed.
      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after the transaction commit): " + top5LatestBooks.get(0).getPrice());
    }
  }

  public static void runStaleReadOnSessionExample(BookDAO bookDAO) throws SQLException {
    System.out.println("[Running stale read on session example]");
    List<Book> top5LatestBooks = bookDAO.getTop5LatestBooks();

    if (top5LatestBooks.size() > 0) {
      System.out.println("The latest book price (before update): " + top5LatestBooks.get(0).getPrice());

      Book book = top5LatestBooks.get(0);
      bookDAO.updateBookPriceByID(book.getId(), book.getPrice() + 10);

      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after update): " + top5LatestBooks.get(0).getPrice());

      // Use the stale read.
      top5LatestBooks = bookDAO.getTop5LatestBooksWithSessionStaleRead(5);
      System.out.println("The latest book price (maybe stale): " + top5LatestBooks.get(0).getPrice());

      // After the stale read transaction is committed.
      top5LatestBooks = bookDAO.getTop5LatestBooks();
      System.out.println("The latest book price (after the transaction commit): " + top5LatestBooks.get(0).getPrice());
    }
  }
}

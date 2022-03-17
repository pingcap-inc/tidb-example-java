package com.pingcap;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Main class for the basic JDBC example.
 * this code based on https://github.com/cockroachlabs/example-app-java-jdbc/
 **/
public class App 
{
    public static void main(String[] args) {
        // 1. Configure the example database connection.

        // 1.1 Create a mysql data source instance
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        // 1.2 Set server name, port, database name , username and password
        mysqlDataSource.setServerName("tidb.e049234d.d40d1f8b.us-east-1.prod.aws.tidbcloud.com");
        mysqlDataSource.setPortNumber(4000);
        mysqlDataSource.setDatabaseName("bank");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("wqz1994625");

        // Or you can use jdbc string instead
        // mysqlDataSource.setURL("jdbc:mysql://{host}:{port}/bank?user={user}&password={password}");

        // 2. And then, create DAO to manager your data
        ExampleDataDAO dao = new ExampleDataDAO(mysqlDataSource);

        // Insert a few accounts "by hand", using INSERTs on the backend.
        Map<String, Integer> balances = new HashMap<>();
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        balances.put(id1, 1000);
        balances.put(id2, 250);
        int updatedAccounts = dao.updateAccounts(balances);
        System.out.printf("ExampleDataDAO.updateAccounts:\n    => %s total updated accounts\n", updatedAccounts);

        // How much money is in these accounts?
        BigDecimal balance1 = dao.getAccountBalance(id1);
        BigDecimal balance2 = dao.getAccountBalance(id2);
        System.out.printf("main:\n    => Account balances at time '%s':\n    ID %s => $%s\n    ID %s => $%s\n", LocalTime.now(), 1, balance1, 2, balance2);

        // Transfer $100 from account 1 to account 2, and print balances of them
        Integer transferAmount = 100;
        int transferredAccounts = dao.transferFunds(id1, id2, transferAmount);
        if (transferredAccounts != -1) {
            System.out.printf("ExampleDataDAO.transferFunds:\n    => $%s transferred between accounts %s and %s, %s rows updated\n",
                    transferAmount, id1, id2, transferredAccounts);
        }
        balance1 = dao.getAccountBalance(id1);
        balance2 = dao.getAccountBalance(id2);
        System.out.printf("main:\n    => Account balances at time '%s':\n    ID %s => $%s\n    ID %s => $%s\n", LocalTime.now(), 1, balance1, 2, balance2);

        // Bulk insertion example using JDBC's batching support.
        int totalRowsInserted = dao.bulkInsertRandomAccountData(false, 100);
        System.out.printf("\nExampleDataDAO.bulkInsertRandomAccountData:\n    => finished, %s total rows inserted\n", totalRowsInserted);

        // Print out 10 account values.
        dao.readAccounts(10);
    }

}

/**
 * Data access object used by 'ExampleDataSource'.
 * Example for CURD and bulk insert
 */
class ExampleDataDAO {
    private final MysqlDataSource ds;
    private final Random rand = new Random();

    ExampleDataDAO(MysqlDataSource ds) {
        this.ds = ds;
    }


    /**
     * There is a shortcut to run a SQL by commit automatically
     */
    public Integer runSQL(String caller, String sql, Object... args) {
        return runSQL(caller, true, sql, args);
    }

    /**
     * Run SQL and commit using automatic and manual way
     * @param caller caller name, to print log
     * @param autoCommit if setting is true, will commit automatically,
     *                   but whatever the setting is, it will be committed
     * @param sql a String containing the SQL code you want to
     *            execute.  Can have placeholders, e.g., "INSERT INTO accounts
     *            (id, balance) VALUES (?, ?)".
     * @param args String Varargs to fill in the SQL
     * @return update count
     */
    public Integer runSQL(String caller, Boolean autoCommit, String sql, Object... args) {
        int updateCount = 0;
        try {
            Connection connection = ds.getConnection();
            connection.setAutoCommit(autoCommit);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                int place = i + 1;

                // According to `java.sql.PreparedStatement.setObject` function description:
                // parameterIndex – the first parameter is 1, the second is 2
                preparedStatement.setObject(place, args[i]);
            }

            // According to `java.sql.PreparedStatement.execute` function description:
            // Returns:
            //     true if the first result is a ResultSet object;
            //     false if the first result is an update count or there is no result
            if (preparedStatement.execute()) {
                // Should be a select SQL
                ResultSet resultSet = preparedStatement.getResultSet();

                // This printed output is for debugging and/or demonstration purposes only.
                // You need replace this `System.out.printf` to log framework at production code.
                System.out.printf("\n%s:\n    '%s'\n", caller, preparedStatement);

                // Read all data from dataset
                while (resultSet.next()) {
                    System.out.printf("    %-8s => %10s\n", "id", resultSet.getString("id"));
                    System.out.printf("    %-8s => %10s\n", "balance", resultSet.getInt("balance"));
                }
            } else {
                // Get update count
                updateCount = preparedStatement.getUpdateCount();

                // This printed output is for debugging and/or demonstration purposes only.
                // You need replace this `System.out.printf` to log framework at production code.
                System.out.printf("\n%s:\n    '%s'\n", caller, preparedStatement);
            }

            if (!autoCommit) {
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.printf("runSQL ERROR: { state => %s, cause => %s, message => %s }\n",
                    e.getSQLState(), e.getCause(), e.getMessage());

            e.printStackTrace();
            updateCount = -1;
        }

        return updateCount;
    }

    /**
     * Update accounts by passing in a Map of (ID, Balance) pairs.
     *
     * @param accounts (Map<String, Integer>)
     * @return The number of updated accounts (int)
     */
    public int updateAccounts(Map<String, Integer> accounts) {
        int rows = 0;
        for (Map.Entry<String, Integer> account : accounts.entrySet()) {
            String k = account.getKey();
            Integer v = account.getValue();

            rows += runSQL("[updateAccounts]", false,
                    "INSERT INTO accounts (id, balance) VALUES (?, ?)", k, v);
        }
        return rows;
    }


    /**
     * Transfer funds between one account and another.  Handles
     * transaction retries in case of conflict automatically on the
     * backend.
     * @param fromId (String)
     * @param toId (String)
     * @param amount (Integer)
     * @return The number of updated accounts (int)
     */
    public int transferFunds(String fromId, String toId, Integer amount) {
        String sqlCode = "INSERT INTO accounts (id, balance) VALUES " +
                "(?, (( SELECT balance FROM accounts WHERE id = ? ) - ? )), " +
                "(?, (( SELECT balance FROM accounts WHERE id = ? ) + ? )) " +
                "ON DUPLICATE KEY UPDATE balance = VALUES(balance)";

        return runSQL("[transferFunds]", sqlCode, fromId, fromId, amount, toId, toId, amount);
    }

    /**
     * Get the account balance for one account.
     *
     * We skip using the retry logic in 'runSQL()' here for the
     * following reasons:
     *
     * 1. Since this is a single read ("SELECT"), we don't expect any
     *    transaction conflicts to handle
     *
     * 2. We need to return the balance as an integer
     *
     * @param id (String)
     * @return balance (int)
     */
    public BigDecimal getAccountBalance(String id) {
        BigDecimal balance = BigDecimal.valueOf(0);

        try (Connection connection = ds.getConnection()) {

            // Check the current balance.
            ResultSet res = connection.createStatement()
                    .executeQuery(String.format("SELECT balance FROM accounts WHERE id = '%s'", id));
            if(!res.next()) {
                System.out.printf("No users in the table with id %s", id);
            } else {
                balance = res.getBigDecimal("balance");
            }
        } catch (SQLException e) {
            System.out.printf("ExampleDataDAO.getAccountBalance ERROR: { state => %s, cause => %s, message => %s }\n",
                    e.getSQLState(), e.getCause(), e.getMessage());
        }

        return balance;
    }

    /**
     * Insert randomized account data (ID, balance) using the JDBC
     * fast path for bulk inserts.  The fastest way to get data into
     * TiDB is the IMPORT statement.  However, if you must bulk
     * ingest from the application using INSERT statements, the best
     * option is the method shown here. It will require the following:
     *
     *    Add `rewriteBatchedStatements=true` to your JDBC connection settings.
     *    Setting rewriteBatchedStatements to true now causes CallableStatements
     *    with batched arguments to be re-written in the form "CALL (...); CALL (...); ..."
     *    to send the batch in as few client/server round trips as possible.
     *    https://dev.mysql.com/doc/relnotes/connector-j/5.1/en/news-5-1-3.html
     *
     *    You can see the `rewriteBatchedStatements` param effect logic at
     *    implement function: `com.mysql.cj.jdbc.StatementImpl.executeBatchUsingMultiQueries`
     * @return The number of new accounts inserted (int)
     */
    public int bulkInsertRandomAccountData(Boolean autoCommit, Integer batchSize) {
        int totalNewAccounts = 0;

        try {
            ds.setRewriteBatchedStatements(true);
            Connection connection = ds.getConnection();
            connection.setAutoCommit(autoCommit);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounts (id, balance) VALUES (?, ?)");
            for (int i = 0; i < (500/batchSize); i++) {
                for (int j = 0; j < batchSize; j++) {
                    String id = UUID.randomUUID().toString();
                    BigDecimal balance = BigDecimal.valueOf(rand.nextInt(1000000000));
                    preparedStatement.setString(1, id);
                    preparedStatement.setBigDecimal(2, balance);
                    preparedStatement.addBatch();
                }

                int[] count = preparedStatement.executeBatch();
                totalNewAccounts += count.length;
                System.out.printf("\nExampleDataDAO.bulkInsertRandomAccountData:\n    '%s'\n", preparedStatement);
                System.out.printf("    => %s row(s) updated in this batch\n", count.length);
            }

            if (!autoCommit) {
                connection.commit();
            }

        } catch (SQLException e) {
            System.out.printf("ExampleDataDAO.bulkInsertRandomAccountData ERROR: { state => %s, cause => %s, message => %s }\n",
                    e.getSQLState(), e.getCause(), e.getMessage());
            e.printStackTrace();
        }

        return totalNewAccounts;
    }

    /**
     * Read out a subset of accounts from the data store.
     *
     * @param limit (int)
     * @return Number of accounts read (int)
     */
    public int readAccounts(Integer limit) {
        return runSQL("[readAccounts]", "SELECT id, balance FROM accounts LIMIT ?", limit);
    }
}

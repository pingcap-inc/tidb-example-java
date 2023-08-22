// Copyright 2022 PingCAP, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.pingcap.bulkDelete;

import com.mysql.cj.conf.PropertyDefinitions;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BatchDeleteExample
{
    public static void main(String[] args) throws SQLException {
        // Create a mysql data source instance.
        MysqlDataSource mysqlDataSource = getMysqlDataSourceByEnv();

        Integer updateCount;
        do {
            updateCount = batchDelete(mysqlDataSource);
        } while (updateCount > 0);
    }

    public static Integer batchDelete (MysqlDataSource ds) {
        try (Connection connection = ds.getConnection()) {
            String sql = "DELETE FROM `ratings` WHERE `rated_at` >= ? AND  `rated_at` <= ? LIMIT 1000";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MILLISECOND, 0);

            calendar.set(2022, Calendar.APRIL, 15, 0, 0, 0);
            preparedStatement.setTimestamp(1, new Timestamp(calendar.getTimeInMillis()));

            calendar.set(2022, Calendar.APRIL, 15, 0, 15, 0);
            preparedStatement.setTimestamp(2, new Timestamp(calendar.getTimeInMillis()));

            int count = preparedStatement.executeUpdate();
            System.out.println("delete " + count + " data");

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private static MysqlDataSource getMysqlDataSourceByEnv() throws SQLException {
        // 1.1 Create a mysql data source instance.
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        // 1.2 Get parameters from environment variables.
        String tidbHost = System.getenv().getOrDefault("TIDB_HOST", "localhost");
        int tidbPort = Integer.parseInt(System.getenv().getOrDefault("TIDB_PORT", "4000"));
        String tidbUser = System.getenv().getOrDefault("TIDB_USER", "root");
        String tidbPassword = System.getenv().getOrDefault("TIDB_PASSWORD", "");
        String tidbDatabase = System.getenv().getOrDefault("TIDB_DATABASE", "test");
        boolean useSSL = Boolean.parseBoolean(System.getenv().getOrDefault("USE_SSL", "false"));

        // 1.3 Set server name, port, database name, username and password.
        mysqlDataSource.setServerName(tidbHost);
        mysqlDataSource.setPortNumber(tidbPort);
        mysqlDataSource.setUser(tidbUser);
        mysqlDataSource.setPassword(tidbPassword);
        mysqlDataSource.setDatabaseName(tidbDatabase);
        if (useSSL) {
            mysqlDataSource.setSslMode(PropertyDefinitions.SslMode.VERIFY_IDENTITY.name());
            mysqlDataSource.setEnabledTLSProtocols("TLSv1.2,TLSv1.3");
        }

        // Or you can use jdbc string instead.
        // mysqlDataSource.setURL("jdbc:mysql://{host}:{port}/test?user={user}&password={password}");

        return mysqlDataSource;
    }
}

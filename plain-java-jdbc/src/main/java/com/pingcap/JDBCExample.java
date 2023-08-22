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

package com.pingcap;

import com.mysql.cj.conf.PropertyDefinitions;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Main class for the basic JDBC example.
 **/
public class JDBCExample
{
    public static void main(String[] args) throws SQLException {
        // 1. Configure the example database connection.
        MysqlDataSource mysqlDataSource = getMysqlDataSourceByEnv();

        // 2. And then, create DAO to manager your data. We recreate this table for test.
        PlayerDAO dao = new PlayerDAO(mysqlDataSource);
        dao.recreateTable();

        // 3. Run some simple examples.

        // Create a player, who has a coin and a goods.
        dao.createPlayers(Collections.singletonList(new PlayerBean("test", 1, 1)));

        // Get a player.
        PlayerBean testPlayer = dao.getPlayer("test");
        System.out.printf("PlayerDAO.getPlayer:\n    => id: %s\n    => coins: %s\n    => goods: %s\n",
                testPlayer.getId(), testPlayer.getCoins(), testPlayer.getGoods());

        // Create players with bulk inserts. Insert 1919 players totally, with 114 players per batch.
        int addedCount = dao.bulkInsertRandomPlayers(1919, 114);
        System.out.printf("PlayerDAO.bulkInsertRandomPlayers:\n    => %d total inserted players\n", addedCount);

        // Count players amount.
        int count = dao.countPlayers();
        System.out.printf("PlayerDAO.countPlayers:\n    => %d total players\n", count);

        // Print 3 players.
        dao.printPlayers(3);

        // 4. Getting further.

        // Player 1: id is "1", has only 100 coins.
        // Player 2: id is "2", has 114514 coins, and 20 goods.
        PlayerBean player1 = new PlayerBean("1", 100, 0);
        PlayerBean player2 = new PlayerBean("2", 114514, 20);

        // Create two players "by hand", using the INSERT statement on the backend.
        addedCount = dao.createPlayers(Arrays.asList(player1, player2));
        System.out.printf("PlayerDAO.createPlayers:\n    => %d total inserted players\n", addedCount);

        // Player 1 wants to buy 10 goods from player 2.
        // It will cost 500 coins, but player 1 cannot afford it.
        System.out.println("\nPlayerDAO.buyGoods:\n    => this trade will fail");
        int updatedCount = dao.buyGoods(player2.getId(), player1.getId(), 10, 500);
        System.out.printf("PlayerDAO.buyGoods:\n    => %d total update players\n", updatedCount);

        // So player 1 has to reduce the incoming quantity to two.
        System.out.println("\nPlayerDAO.buyGoods:\n    => this trade will success");
        updatedCount = dao.buyGoods(player2.getId(), player1.getId(), 2, 100);
        System.out.printf("PlayerDAO.buyGoods:\n    => %d total update players\n", updatedCount);
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

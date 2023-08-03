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

import com.pingcap.dao.PlayerDAO;
import com.pingcap.model.Player;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class MybatisExample {
    public static void main( String[] args ) throws IOException {
        // 1. Create a SqlSessionFactory based on our mybatis-config.xml configuration
        // file, which defines how to connect to the database.
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream, getTiDBProperties());

        // 2. And then, create DAO to manager your data
        PlayerDAO playerDAO = new PlayerDAO(sessionFactory);
        playerDAO.recreateTable();

        // 3. Run some simple examples.

        // Create a player who has 1 coin and 1 goods.
        playerDAO.createPlayers(Collections.singletonList(new Player("test", 1, 1)));

        // Get a player.
        Player testPlayer = playerDAO.getPlayerByID("test");
        System.out.printf("PlayerDAO.getPlayer:\n    => id: %s\n    => coins: %s\n    => goods: %s\n",
                testPlayer.getId(), testPlayer.getCoins(), testPlayer.getGoods());

        // Count players amount.
        Integer count = playerDAO.countPlayers();
        System.out.printf("PlayerDAO.countPlayers:\n    => %d total players\n", count);

        // Print 3 players.
        playerDAO.printPlayers(3);

        // 4. Getting further.

        // Player 1: id is "1", has only 100 coins.
        // Player 2: id is "2", has 114514 coins, and 20 goods.
        Player player1 = new Player("1", 100, 0);
        Player player2 = new Player("2", 114514, 20);

        // Create two players "by hand", using the INSERT statement on the backend.
        int addedCount = playerDAO.createPlayers(Arrays.asList(player1, player2));
        System.out.printf("PlayerDAO.createPlayers:\n    => %d total inserted players\n", addedCount);

        // Player 1 wants to buy 10 goods from player 2.
        // It will cost 500 coins, but player 1 cannot afford it.
        System.out.println("\nPlayerDAO.buyGoods:\n    => this trade will fail");
        Integer updatedCount = playerDAO.buyGoods(player2.getId(), player1.getId(), 10, 500);
        System.out.printf("PlayerDAO.buyGoods:\n    => %d total update players\n", updatedCount);

        // So player 1 has to reduce the incoming quantity to two.
        System.out.println("\nPlayerDAO.buyGoods:\n    => this trade will success");
        updatedCount = playerDAO.buyGoods(player2.getId(), player1.getId(), 2, 100);
        System.out.printf("PlayerDAO.buyGoods:\n    => %d total update players\n", updatedCount);
    }

    /**
     * Get TiDB connection properties from environment variables.
     * @return Properties
     */
    public static Properties getTiDBProperties() {
        // 1. Get TiDB connection properties from environment variables.
        String tidbJDBCURL = System.getenv().getOrDefault("TIDB_JDBC_URL", "jdbc:mysql://localhost:4000/test");
        String tidbUser = System.getenv().getOrDefault("TIDB_USER", "root");
        String tidbPassword = System.getenv().getOrDefault("TIDB_PASSWORD", "");

        Properties properties = new Properties();
        properties.setProperty("TIDB_URL", tidbJDBCURL);
        properties.setProperty("TIDB_USER", tidbUser);
        properties.setProperty("TIDB_PASSWORD", tidbPassword);

        return properties;
    }
}

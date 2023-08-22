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

package com.pingcap.dao;

import com.pingcap.model.Player;
import com.pingcap.model.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.function.Function;

/**
 * PlayerDAO
 *
 * @author Icemap
 * @date 2022/5/23
 */
public class PlayerDAO {
    SqlSessionFactory sessionFactory;

    public PlayerDAO(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static class NotEnoughException extends RuntimeException {
        public NotEnoughException(String message) {
            super(message);
        }
    }

    // Run SQL code in a way that automatically handles the
    // transaction retry logic, so we don't have to duplicate it in
    // various places.
    private Object runTransaction(SqlSessionFactory sessionFactory, Function<PlayerMapper, Object> fn) {
        Object resultObject = null;
        SqlSession session = null;

        try {
            // open a session with autoCommit is false
            session = sessionFactory.openSession(false);

            // get player mapper
            PlayerMapper PlayerMapper = session.getMapper(PlayerMapper.class);

            resultObject = fn.apply(PlayerMapper);
            session.commit();
            System.out.println("APP: COMMIT;");
        } catch (Exception e) {
            if (e instanceof NotEnoughException) {
                System.out.printf("APP: ROLLBACK BY LOGIC; \n%s\n", e.getMessage());
            } else {
                System.out.printf("APP: ROLLBACK BY ERROR; \n%s\n", e.getMessage());
            }

            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return resultObject;
    }

    /**
     * Recreate Table Schema
     */
    public void recreateTable() {
        runTransaction(sessionFactory, recreateTableFunction());
    }

    private Function<PlayerMapper, Object> recreateTableFunction() {
        return PlayerMapper -> {
            PlayerMapper.dropTableIfExist();
            PlayerMapper.createTable();
            System.out.println("APP: recreateTable()");
            return null;
        };
    }

    /**
     * Create players
     * @param players player list
     * @return affect rows
     */
    public Integer createPlayers(List<Player> players) {
        return (Integer)runTransaction(sessionFactory, createPlayersFunction(players));
    }

    private Function<PlayerMapper, Object> createPlayersFunction(List<Player> players) {
        return PlayerMapper -> {
            Integer addedPlayerAmount = 0;
            for (Player player: players) {
                PlayerMapper.insert(player);
                addedPlayerAmount ++;
            }
            System.out.printf("APP: createPlayers() --> %d\n", addedPlayerAmount);
            return addedPlayerAmount;
        };
    }

    /**
     * Get player amount
     * @param sellId sell player id
     * @param buyId buy player id
     * @param amount goods amount
     * @param price goods price
     * @return affect rows
     */
    public Integer buyGoods(String sellId, String buyId, Integer amount, Integer price) {
        return (Integer)runTransaction(sessionFactory, buyGoodsFunction(sellId, buyId, amount, price));
    }

    private Function<PlayerMapper, Object> buyGoodsFunction(String sellId, String buyId, Integer amount, Integer price) {
        return PlayerMapper -> {
            Player sellPlayer = PlayerMapper.selectByPrimaryKeyWithLock(sellId);
            Player buyPlayer = PlayerMapper.selectByPrimaryKeyWithLock(buyId);

            if (buyPlayer == null || sellPlayer == null) {
                throw new NotEnoughException("sell or buy player not exist");
            }

            if (buyPlayer.getCoins() < price || sellPlayer.getGoods() < amount) {
                throw new NotEnoughException("coins or goods not enough, rollback");
            }

            int affectRows = 0;
            buyPlayer.setGoods(buyPlayer.getGoods() + amount);
            buyPlayer.setCoins(buyPlayer.getCoins() - price);
            affectRows += PlayerMapper.updateByPrimaryKey(buyPlayer);

            sellPlayer.setGoods(sellPlayer.getGoods() - amount);
            sellPlayer.setCoins(sellPlayer.getCoins() + price);
            affectRows += PlayerMapper.updateByPrimaryKey(sellPlayer);

            System.out.printf("APP: buyGoods --> sell: %s, buy: %s, amount: %d, price: %d\n", sellId, buyId, amount, price);
            return affectRows;
        };
    }

    /**
     * Get player by id
     * @param id player id
     * @return player
     */
    public Player getPlayerByID(String id) {
        return (Player)runTransaction(sessionFactory, getPlayerByIDFunction(id));
    }

    private Function<PlayerMapper, Object> getPlayerByIDFunction(String id) {
        return PlayerMapper -> PlayerMapper.selectByPrimaryKey(id);
    }

    /**
     * Print players
     * @param limit number of players limit
     */
    public void printPlayers(Integer limit) {
        runTransaction(sessionFactory, printPlayersFunction(limit));
    }

    private Function<PlayerMapper, Object> printPlayersFunction(Integer limit) {
        return PlayerMapper -> {
            List<Player> players = PlayerMapper.selectByLimit(limit);

            for (Player player: players) {
                System.out.println("\n[printPlayers]:\n" + player);
            }
            return null;
        };
    }

    /**
     * Count players
     * @return number of players
     */
    public Integer countPlayers() {
        return (Integer)runTransaction(sessionFactory, countPlayersFunction());
    }

    private Function<PlayerMapper, Object> countPlayersFunction() {
        return PlayerMapper::count;
    }
}

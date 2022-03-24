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

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class PlayerDAO {
    final Random RAND = new Random();

    public static class NotEnoughException extends RuntimeException {
        public NotEnoughException(String message) {
            super(message);
        }
    }

    // Run SQL code in a way that automatically handles the
    // transaction retry logic so we don't have to duplicate it in
    // various places.
    public Object runTransaction(Session session, Function<Session, Object> fn) {
        Object resultObject = null;

        Transaction txn = session.beginTransaction();
        try {
            resultObject = fn.apply(session);
            txn.commit();
            System.out.println("APP: COMMIT;");
        } catch (JDBCException e) {
            System.out.println("APP: ROLLBACK BY JDBC ERROR;");
            txn.rollback();
        } catch (NotEnoughException e) {
            System.out.printf("APP: ROLLBACK BY LOGIC; %s", e.getMessage());
            txn.rollback();
        }
        return resultObject;
    }

    public Function<Session, Object> createPlayers(List<PlayerBean> players) throws JDBCException {
        return session -> {
            Integer addedPlayerAmount = 0;
            for (PlayerBean player: players) {
                session.persist(player);
                addedPlayerAmount ++;
            }
            System.out.printf("APP: createPlayers() --> %d\n", addedPlayerAmount);
            return addedPlayerAmount;
        };
    }

    public Function<Session, Object> buyGoods(String sellId, String buyId, Integer amount, Integer price) throws JDBCException {
        return session -> {
            PlayerBean sellPlayer = session.get(PlayerBean.class, sellId);
            PlayerBean buyPlayer = session.get(PlayerBean.class, buyId);

            if (buyPlayer == null || sellPlayer == null) {
                throw new NotEnoughException("sell or buy player not exist");
            }

            if (buyPlayer.getCoins() < price || sellPlayer.getGoods() < amount) {
                throw new NotEnoughException("coins or goods not enough, rollback");
            }

            buyPlayer.setGoods(buyPlayer.getGoods() + amount);
            buyPlayer.setCoins(buyPlayer.getCoins() - price);
            session.persist(buyPlayer);

            sellPlayer.setGoods(sellPlayer.getGoods() - amount);
            sellPlayer.setCoins(sellPlayer.getCoins() + price);
            session.persist(sellPlayer);

            System.out.printf("APP: buyGoods --> sell: %s, buy: %s, amount: %d, price: %d\n", sellId, buyId, amount, price);
            return 0;
        };
    }

    public Function<Session, Object> getPlayerByID(String id) throws JDBCException {
        return session -> session.get(PlayerBean.class, id);
    }

    public Function<Session, Object> printPlayers(Integer limit) throws JDBCException {
        return session -> {
            NativeQuery<PlayerBean> limitQuery = session.createNativeQuery("SELECT * FROM player_hibernate LIMIT :limit", PlayerBean.class);
            limitQuery.setParameter("limit", limit);
            List<PlayerBean> players = limitQuery.getResultList();

            for (PlayerBean player: players) {
                System.out.println("\n[printPlayers]:");
                System.out.printf("    %-8s => %10s\n", "id", player.getId());
                System.out.printf("    %-8s => %d\n", "coins", player.getCoins());
                System.out.printf("    %-8s => %d\n", "goods", player.getGoods());
            }
            return 0;
        };
    }

    public Function<Session, Object> countPlayers() throws JDBCException {
        return session -> {
            Query<Long> countQuery = session.createQuery("SELECT count(player_hibernate) FROM PlayerBean player_hibernate", Long.class);
            return countQuery.getSingleResult();
        };
    }
}

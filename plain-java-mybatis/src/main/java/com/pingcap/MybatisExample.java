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

import com.pingcap.model.AutoPlayer;
import com.pingcap.model.AutoPlayerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisExample {
    public static void main( String[] args ) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sessionFactory.openSession(false);
        AutoPlayerMapper autoPlayerMapperEx = session.getMapper(AutoPlayerMapper.class);

        AutoPlayer player = new AutoPlayer();
        player.setCoins(1);
        player.setGoods(1);

        System.out.println("single:");
        System.out.println("\taffect rows: " + autoPlayerMapperEx.insert(player));
        System.out.println("\tgenerated id: " + player.getId());

        List<AutoPlayer> playerList = new ArrayList<>();
        for (int i = 2 ; i < 10; i++) {
            AutoPlayer playerItem = new AutoPlayer();
            playerItem.setCoins(i);
            playerItem.setGoods(i);

            playerList.add(playerItem);
        }

        System.out.println("batch:");
        System.out.println("\taffect rows: " + autoPlayerMapperEx.insertBatch(playerList));
        for (AutoPlayer autoPlayer: playerList) {
            System.out.println("\tgenerated id: " + autoPlayer.getId());
        }

        session.commit();
    }
}

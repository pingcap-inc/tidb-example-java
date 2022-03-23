# Expected-Output

## plain-java-jdbc

```
cheese@CheesedeMacBook-Pro tidb-example-java % make plain-java-jdbc
/Library/Developer/CommandLineTools/usr/bin/make -C plain-java-jdbc
make mysql build run
mysql --host 127.0.0.1 --port 4000 -u root<src/main/resources/dbinit.sql
mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.pingcap:plain-java-jdbc >---------------------
[INFO] Building plain-java-jdbc 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ plain-java-jdbc ---
[INFO] Deleting /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ plain-java-jdbc ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ plain-java-jdbc ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ plain-java-jdbc ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ plain-java-jdbc ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ plain-java-jdbc ---
[INFO] Surefire report directory: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.pingcap.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.024 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ plain-java-jdbc ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target/plain-java-jdbc-0.0.1.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.3.0:single (make-assembly) @ plain-java-jdbc ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-jdbc/target/plain-java-jdbc-0.0.1-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.654 s
[INFO] Finished at: 2022-03-23T15:21:50+08:00
[INFO] ------------------------------------------------------------------------
java -jar target/plain-java-jdbc-0.0.1-jar-with-dependencies.jar

[createPlayers]:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES (** NOT SPECIFIED **, ** NOT SPECIFIED **, ** NOT SPECIFIED **)'
PlayerDAO.getPlayer:
    => id: test
    => coins: 1
    => goods: 1

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('a3e0204c-6ae8-40b9-b5f0-82b27c322733', 7130, 3033)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('b85731d2-9f8d-4caa-a3af-4e794fe77513', 7154, 8454)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('6b9e9704-7443-4188-8461-461886686707', 2495, 4159)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('921b2b67-a3c3-40a0-a864-048ac0275e49', 3165, 3196)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('08b89a63-04d7-4a28-a0ed-2bc2290a05b3', 6360, 8511)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('c8a9ecfd-4951-40c9-b6b2-bf2b25aa12a6', 286, 7687)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('4d9d361f-c4ba-496b-bd07-32310bce280b', 1936, 5775)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('7a42bf2f-4a59-4095-aa2a-b29399ad3b69', 6104, 433)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('301b45c3-358f-4fa5-a7f0-168d00541824', 6644, 9277)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('c075f09d-3014-45fc-947f-debe1760f2ed', 7729, 929)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('df1ff19b-4a05-41b2-a1c5-b80aad1272e4', 8372, 3109)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('b41b979f-40a6-4226-ae02-1130d4d00bb2', 6593, 2853)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('969e8ad4-b4f7-47c8-bc28-ff4b08f0b8e0', 5695, 8058)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('ad4d54e2-83e4-4367-a275-81591219dd0b', 7843, 5973)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('4b9b5bcc-8ecc-4d89-b2cb-285055e8492c', 2249, 185)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('6c4154d2-6701-4a5f-928b-7353408c6195', 5555, 5684)'
    => 114 row(s) updated in this batch

PlayerDAO.bulkInsertRandomPlayers:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES ('45f9c266-8047-4d9e-a86e-5780668be105', 5816, 8106)'
    => 114 row(s) updated in this batch
PlayerDAO.bulkInsertRandomPlayers:
    => 1938 total inserted players
PlayerDAO.countPlayers:
    => 1939 total players

[createPlayers]:
    'com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO player (id, coins, goods) VALUES (** NOT SPECIFIED **, ** NOT SPECIFIED **, ** NOT SPECIFIED **)'
PlayerDAO.createPlayers:
    => 2 total inserted players

PlayerDAO.buyGoods:
    => this trade will fail

[buyGoods]:
    'check goods and coins enough'
    id       =>          1
    coins    =>        100
    goods    =>          0

[buyGoods]:
    'check goods and coins enough'
    id       =>          2
    coins    =>     114514
    goods    =>         20
[buyGoods] ERROR: { state => null, cause => null, message => buy player 1 coins not enough. }
[buyGoods] Rollback
PlayerDAO.buyGoods:
    => 0 total update players

PlayerDAO.buyGoods:
    => this trade will success

[buyGoods]:
    'check goods and coins enough'
    id       =>          1
    coins    =>        100
    goods    =>          0

[buyGoods]:
    'check goods and coins enough'
    id       =>          2
    coins    =>     114514
    goods    =>         20

[buyGoods]:
    'trade success'
PlayerDAO.buyGoods:
    => 2 total update players
```

## plain-java-hibernate

```
cheese@CheesedeMacBook-Pro tidb-example-java % make plain-java-hibernate
/Library/Developer/CommandLineTools/usr/bin/make -C plain-java-hibernate
make build run
mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.pingcap:plain-java-hibernate >------------------
[INFO] Building plain-java-hibernate 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ plain-java-hibernate ---
[INFO] Deleting /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ plain-java-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ plain-java-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ plain-java-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ plain-java-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ plain-java-hibernate ---
[INFO] Surefire report directory: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.pingcap.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ plain-java-hibernate ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/plain-java-hibernate-0.0.1.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.3.0:single (make-assembly) @ plain-java-hibernate ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/plain-java-hibernate-0.0.1-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.459 s
[INFO] Finished at: 2022-03-23T15:29:30+08:00
[INFO] ------------------------------------------------------------------------
java -jar target/plain-java-hibernate-0.0.1-jar-with-dependencies.jar
3月 23, 2022 3:29:31 下午 org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version [WORKING]
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using built-in connection pool (not intended for production use)
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: Loaded JDBC driver class: com.mysql.cj.jdbc.Driver
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001012: Connecting with JDBC URL [jdbc:mysql://localhost:4000/test]
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, autocommit=false, user=root}
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH10001115: Connection pool size: 20 (min=1)
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl logSelectedDialect
INFO: HHH000400: Using dialect: org.hibernate.dialect.TiDBDialect
Hibernate: 
    
    drop table if exists player_hibernate
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@6ab4a5b] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table player_hibernate (
       id varchar(255) not null,
        coins integer,
        goods integer,
        primary key (id)
    ) engine=InnoDB
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@54db056b] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
3月 23, 2022 3:29:31 下午 org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
APP: createPlayers() --> 1
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
APP: COMMIT;
APP: COMMIT;
PlayerDAO.getPlayer:
    => id: test
    => coins: 1
    => goods: 1
3月 23, 2022 3:29:31 下午 org.hibernate.jpa.internal.LegacySpecHelper getValue
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: 
    select
        count(p1_0.id) 
    from
        player_hibernate p1_0
APP: COMMIT;
PlayerDAO.countPlayers:
    => 1 total players
3月 23, 2022 3:29:31 下午 org.hibernate.jpa.internal.LegacySpecHelper getValue
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: 
    SELECT
        * 
    FROM
        player_hibernate LIMIT ?

[printPlayers]:
    id       =>       test
    coins    => 1
    goods    => 1
APP: COMMIT;
APP: createPlayers() --> 2
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
APP: COMMIT;
PlayerDAO.createPlayers:
    => 2 total inserted players

PlayerDAO.buyGoods:
    => this trade will fail
APP: ROLLBACK BY LOGIC; coins or goods not enough, rollbackPlayerDAO.buyGoods:
    => null total update players

PlayerDAO.buyGoods:
    => this trade will success
Hibernate: 
    select
        p1_0.id,
        p1_0.coins,
        p1_0.goods 
    from
        player_hibernate p1_0 
    where
        p1_0.id=?
Hibernate: 
    select
        p1_0.id,
        p1_0.coins,
        p1_0.goods 
    from
        player_hibernate p1_0 
    where
        p1_0.id=?
APP: buyGoods --> sell: 2, buy: 1, amount: 2, price: 100
Hibernate: 
    update
        player_hibernate 
    set
        coins=?,
        goods=? 
    where
        id=?
Hibernate: 
    update
        player_hibernate 
    set
        coins=?,
        goods=? 
    where
        id=?
APP: COMMIT;
PlayerDAO.buyGoods:
    => 0 total update players
3月 23, 2022 3:29:31 下午 org.hibernate.tool.schema.internal.SchemaDropperImpl$DelayedDropActionImpl perform
INFO: HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: 
    
    drop table if exists player_hibernate
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@7b96de8d] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:4000/test]
```

## spring-jpa-hibernate request

```
cheese@CheesedeMacBook-Pro tidb-example-java % make request
/Library/Developer/CommandLineTools/usr/bin/make -C spring-jpa-hibernate request
./request.sh
loop to create 10 players:
1111111111

get player 1:
{"id":1,"coins":100,"goods":20}

get players by limit 3:
[{"id":1,"coins":100,"goods":20},{"id":2,"coins":100,"goods":20},{"id":3,"coins":100,"goods":20}]

get first players:
{"content":[{"id":1,"coins":100,"goods":20},{"id":2,"coins":100,"goods":20}],"pageable":{"sort":{"empty":true,"unsorted":true,"sorted":false},"offset":0,"pageNumber":0,"pageSize":2,"paged":true,"unpaged":false},"last":false,"totalPages":5,"totalElements":10,"first":true,"size":2,"number":0,"sort":{"empty":true,"unsorted":true,"sorted":false},"numberOfElements":2,"empty":false}

get players count:
10

trade by two players:
true% 
```

## spring-jpa-hibernate service

```
cheese@CheesedeMacBook-Pro tidb-example-java % make plain-java-hibernate
/Library/Developer/CommandLineTools/usr/bin/make -C plain-java-hibernate
make build run
mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.pingcap:plain-java-hibernate >------------------
[INFO] Building plain-java-hibernate 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ plain-java-hibernate ---
[INFO] Deleting /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ plain-java-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ plain-java-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ plain-java-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ plain-java-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ plain-java-hibernate ---
[INFO] Surefire report directory: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.pingcap.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ plain-java-hibernate ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/plain-java-hibernate-0.0.1.jar
[INFO] 
[INFO] --- maven-assembly-plugin:3.3.0:single (make-assembly) @ plain-java-hibernate ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/plain-java-hibernate/target/plain-java-hibernate-0.0.1-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.459 s
[INFO] Finished at: 2022-03-23T15:29:30+08:00
[INFO] ------------------------------------------------------------------------
java -jar target/plain-java-hibernate-0.0.1-jar-with-dependencies.jar
3月 23, 2022 3:29:31 下午 org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version [WORKING]
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using built-in connection pool (not intended for production use)
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: Loaded JDBC driver class: com.mysql.cj.jdbc.Driver
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001012: Connecting with JDBC URL [jdbc:mysql://localhost:4000/test]
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, autocommit=false, user=root}
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH10001115: Connection pool size: 20 (min=1)
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl logSelectedDialect
INFO: HHH000400: Using dialect: org.hibernate.dialect.TiDBDialect
Hibernate: 
    
    drop table if exists player_hibernate
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@6ab4a5b] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table player_hibernate (
       id varchar(255) not null,
        coins integer,
        goods integer,
        primary key (id)
    ) engine=InnoDB
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@54db056b] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
3月 23, 2022 3:29:31 下午 org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
APP: createPlayers() --> 1
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
APP: COMMIT;
APP: COMMIT;
PlayerDAO.getPlayer:
    => id: test
    => coins: 1
    => goods: 1
3月 23, 2022 3:29:31 下午 org.hibernate.jpa.internal.LegacySpecHelper getValue
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: 
    select
        count(p1_0.id) 
    from
        player_hibernate p1_0
APP: COMMIT;
PlayerDAO.countPlayers:
    => 1 total players
3月 23, 2022 3:29:31 下午 org.hibernate.jpa.internal.LegacySpecHelper getValue
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: 
    SELECT
        * 
    FROM
        player_hibernate LIMIT ?

[printPlayers]:
    id       =>       test
    coins    => 1
    goods    => 1
APP: COMMIT;
APP: createPlayers() --> 2
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        player_hibernate
        (coins, goods, id) 
    values
        (?, ?, ?)
APP: COMMIT;
PlayerDAO.createPlayers:
    => 2 total inserted players

PlayerDAO.buyGoods:
    => this trade will fail
APP: ROLLBACK BY LOGIC; coins or goods not enough, rollbackPlayerDAO.buyGoods:
    => null total update players

PlayerDAO.buyGoods:
    => this trade will success
Hibernate: 
    select
        p1_0.id,
        p1_0.coins,
        p1_0.goods 
    from
        player_hibernate p1_0 
    where
        p1_0.id=?
Hibernate: 
    select
        p1_0.id,
        p1_0.coins,
        p1_0.goods 
    from
        player_hibernate p1_0 
    where
        p1_0.id=?
APP: buyGoods --> sell: 2, buy: 1, amount: 2, price: 100
Hibernate: 
    update
        player_hibernate 
    set
        coins=?,
        goods=? 
    where
        id=?
Hibernate: 
    update
        player_hibernate 
    set
        coins=?,
        goods=? 
    where
        id=?
APP: COMMIT;
PlayerDAO.buyGoods:
    => 0 total update players
3月 23, 2022 3:29:31 下午 org.hibernate.tool.schema.internal.SchemaDropperImpl$DelayedDropActionImpl perform
INFO: HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: 
    
    drop table if exists player_hibernate
3月 23, 2022 3:29:31 下午 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@7b96de8d] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
3月 23, 2022 3:29:31 下午 org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:4000/test]
cheese@CheesedeMacBook-Pro tidb-example-java % clear
cheese@CheesedeMacBook-Pro tidb-example-java % make spring-jpa-hibernate
/Library/Developer/CommandLineTools/usr/bin/make -C spring-jpa-hibernate
make build run
mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.pingcap:spring-jpa-hibernate >------------------
[INFO] Building spring-jpa-hibernate 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ spring-jpa-hibernate ---
[INFO] Deleting /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ spring-jpa-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.9.0:compile (default-compile) @ spring-jpa-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 6 source files to /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ spring-jpa-hibernate ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.9.0:testCompile (default-testCompile) @ spring-jpa-hibernate ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ spring-jpa-hibernate ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.pingcap.SpringJpaHibernateApplicationTests
15:54:21.412 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
15:54:21.418 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
15:54:21.431 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.pingcap.SpringJpaHibernateApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
15:54:21.436 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.pingcap.SpringJpaHibernateApplicationTests], using SpringBootContextLoader
15:54:21.437 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.pingcap.SpringJpaHibernateApplicationTests]: class path resource [com/pingcap/SpringJpaHibernateApplicationTests-context.xml] does not exist
15:54:21.438 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.pingcap.SpringJpaHibernateApplicationTests]: class path resource [com/pingcap/SpringJpaHibernateApplicationTestsContext.groovy] does not exist
15:54:21.438 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.pingcap.SpringJpaHibernateApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
15:54:21.438 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.pingcap.SpringJpaHibernateApplicationTests]: SpringJpaHibernateApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
15:54:21.455 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.pingcap.SpringJpaHibernateApplicationTests]
15:54:21.481 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target/classes/com/pingcap/App.class]
15:54:21.482 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.pingcap.App for test class com.pingcap.SpringJpaHibernateApplicationTests
15:54:21.514 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.pingcap.SpringJpaHibernateApplicationTests]: using defaults.
15:54:21.514 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.event.ApplicationEventsTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
15:54:21.523 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@1ae8bcbc, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@6cdba6dc, org.springframework.test.context.event.ApplicationEventsTestExecutionListener@7d3d101b, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@30c8681, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@5cdec700, org.springframework.test.context.support.DirtiesContextTestExecutionListener@6d026701, org.springframework.test.context.transaction.TransactionalTestExecutionListener@78aa1f72, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@1f75a668, org.springframework.test.context.event.EventPublishingTestExecutionListener@35399441, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@4b7dc788, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@6304101a, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@5170bcf4, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@2812b107, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@df6620a, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@4e31276e]
15:54:21.524 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@4816278d testClass = SpringJpaHibernateApplicationTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@4eaf3684 testClass = SpringJpaHibernateApplicationTests, locations = '{}', classes = '{class com.pingcap.App}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@68567e20, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@394a2528, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@45ca843, org.springframework.boot.test.autoconfigure.actuate.metrics.MetricsExportContextCustomizerFactory$DisableMetricExportContextCustomizer@236e3f4e, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@152aa092, org.springframework.boot.test.context.SpringBootTestArgs@1, org.springframework.boot.test.context.SpringBootTestWebEnvironment@5ec0a365], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [false] with mode [null].

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v3.0.0-M1)

2022-03-23 15:54:21.653  INFO 36569 --- [           main] c.p.SpringJpaHibernateApplicationTests   : Starting SpringJpaHibernateApplicationTests using Java 17.0.2 on CheesedeMacBook-Pro.local with PID 36569 (started by cheese in /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate)
2022-03-23 15:54:21.654  INFO 36569 --- [           main] c.p.SpringJpaHibernateApplicationTests   : No active profile set, falling back to default profiles: default
2022-03-23 15:54:21.893  INFO 36569 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-03-23 15:54:21.911  INFO 36569 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 15 ms. Found 1 JPA repository interfaces.
2022-03-23 15:54:22.102  INFO 36569 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-03-23 15:54:22.129  INFO 36569 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.0.0.CR2
2022-03-23 15:54:22.194  WARN 36569 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead
2022-03-23 15:54:22.245  INFO 36569 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-03-23 15:54:22.362  INFO 36569 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@7ac48e10
2022-03-23 15:54:22.363  INFO 36569 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-03-23 15:54:22.381  INFO 36569 --- [           main] SQL dialect                              : HHH000400: Using dialect: org.hibernate.dialect.TiDBDialect
Hibernate: drop table if exists player_jpa
Hibernate: drop sequence player_jpa_id_seq
2022-03-23 15:54:22.702  WARN 36569 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "drop sequence player_jpa_id_seq" via JDBC Statement

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop sequence player_jpa_id_seq" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlString(SchemaDropperImpl.java:419) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlStrings(SchemaDropperImpl.java:403) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:286) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:178) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:149) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:117) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:242) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:143) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:140) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:333) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:415) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1425) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) ~[spring-orm-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:362) ~[spring-orm-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:338) ~[spring-orm-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1788) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1737) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:604) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:526) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1132) ~[spring-context-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:907) ~[spring-context-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:719) ~[spring-boot-3.0.0-M1.jar:3.0.0-M1]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:401) ~[spring-boot-3.0.0-M1.jar:3.0.0-M1]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:302) ~[spring-boot-3.0.0-M1.jar:3.0.0-M1]
        at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:124) ~[spring-boot-test-3.0.0-M1.jar:3.0.0-M1]
        at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:123) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:189) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:131) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:248) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:138) ~[spring-test-6.0.0-M2.jar:6.0.0-M2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$8(ClassBasedTestDescriptor.java:363) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:368) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$9(ClassBasedTestDescriptor.java:363) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
        at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179) ~[na:na]
        at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
        at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
        at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:310) ~[na:na]
        at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735) ~[na:na]
        at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734) ~[na:na]
        at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762) ~[na:na]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:362) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$6(ClassBasedTestDescriptor.java:283) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:282) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$4(ClassBasedTestDescriptor.java:272) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at java.base/java.util.Optional.orElseGet(Optional.java:364) ~[na:na]
        at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$5(ClassBasedTestDescriptor.java:271) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:102) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:101) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:66) ~[junit-jupiter-engine-5.8.2.jar:5.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$2(NodeTestTask.java:123) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:123) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:90) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
        at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
        at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54) ~[junit-platform-engine-1.8.2.jar:1.8.2]
        at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:220) ~[junit-platform-launcher-1.3.1.jar:1.3.1]
        at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$6(DefaultLauncher.java:188) ~[junit-platform-launcher-1.3.1.jar:1.3.1]
        at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:202) ~[junit-platform-launcher-1.3.1.jar:1.3.1]
        at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:181) ~[junit-platform-launcher-1.3.1.jar:1.3.1]
        at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:128) ~[junit-platform-launcher-1.3.1.jar:1.3.1]
        at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invokeAllTests(JUnitPlatformProvider.java:150) ~[surefire-junit-platform-2.22.2.jar:2.22.2]
        at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invoke(JUnitPlatformProvider.java:124) ~[surefire-junit-platform-2.22.2.jar:2.22.2]
        at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384) ~[surefire-booter-2.22.2.jar:2.22.2]
        at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345) ~[surefire-booter-2.22.2.jar:2.22.2]
        at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126) ~[surefire-booter-2.22.2.jar:2.22.2]
        at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418) ~[surefire-booter-2.22.2.jar:2.22.2]
Caused by: java.sql.SQLException: Unknown SEQUENCE: 'test.player_jpa_id_seq'
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129) ~[mysql-connector-java-8.0.28.jar:8.0.28]
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-java-8.0.28.jar:8.0.28]
        at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:763) ~[mysql-connector-java-8.0.28.jar:8.0.28]
        at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:648) ~[mysql-connector-java-8.0.28.jar:8.0.28]
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar:na]
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar:na]
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54) ~[hibernate-core-6.0.0.CR2.jar:6.0.0.CR2]
        ... 102 common frames omitted

Hibernate: create sequence player_jpa_id_seq start with 1 increment by 1
Hibernate: create table player_jpa (id bigint not null, coins integer, goods integer, primary key (id)) engine=InnoDB
2022-03-23 15:54:22.798  INFO 36569 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-03-23 15:54:22.802  INFO 36569 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-03-23 15:54:23.008  WARN 36569 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
2022-03-23 15:54:23.016  WARN 36569 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
2022-03-23 15:54:23.096  WARN 36569 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-03-23 15:54:23.234  INFO 36569 --- [           main] c.p.SpringJpaHibernateApplicationTests   : Started SpringJpaHibernateApplicationTests in 1.695 seconds (JVM running for 2.046)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.936 s - in com.pingcap.SpringJpaHibernateApplicationTests
2022-03-23 15:54:23.321  INFO 36569 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-03-23 15:54:23.322  INFO 36569 --- [ionShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: drop table if exists player_jpa
Hibernate: drop sequence player_jpa_id_seq
2022-03-23 15:54:23.397  INFO 36569 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-03-23 15:54:23.404  INFO 36569 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ spring-jpa-hibernate ---
[INFO] Building jar: /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target/spring-jpa-hibernate-0.0.1.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.0.0-M1:repackage (repackage) @ spring-jpa-hibernate ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.058 s
[INFO] Finished at: 2022-03-23T15:54:24+08:00
[INFO] ------------------------------------------------------------------------
java -jar target/spring-jpa-hibernate-0.0.1.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v3.0.0-M1)

2022-03-23 15:54:24.632  INFO 36591 --- [           main] com.pingcap.App                          : Starting App v0.0.1 using Java 17.0.2 on CheesedeMacBook-Pro.local with PID 36591 (/Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate/target/spring-jpa-hibernate-0.0.1.jar started by cheese in /Users/cheese/IdeaProjects/tidb-example-java/spring-jpa-hibernate)
2022-03-23 15:54:24.633  INFO 36591 --- [           main] com.pingcap.App                          : No active profile set, falling back to default profiles: default
2022-03-23 15:54:24.920  INFO 36591 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-03-23 15:54:24.943  INFO 36591 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 18 ms. Found 1 JPA repository interfaces.
2022-03-23 15:54:25.223  INFO 36591 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-03-23 15:54:25.230  INFO 36591 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-03-23 15:54:25.230  INFO 36591 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/10.0.16]
2022-03-23 15:54:25.265  INFO 36591 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-03-23 15:54:25.266  INFO 36591 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 609 ms
2022-03-23 15:54:25.358  INFO 36591 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-03-23 15:54:25.388  INFO 36591 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.0.0.CR2
2022-03-23 15:54:25.487  WARN 36591 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead
2022-03-23 15:54:25.556  INFO 36591 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-03-23 15:54:25.669  INFO 36591 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@4593ff34
2022-03-23 15:54:25.671  INFO 36591 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-03-23 15:54:25.700  INFO 36591 --- [           main] SQL dialect                              : HHH000400: Using dialect: org.hibernate.dialect.TiDBDialect
Hibernate: drop table if exists player_jpa
Hibernate: drop sequence player_jpa_id_seq
2022-03-23 15:54:26.107  WARN 36591 --- [           main] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL "drop sequence player_jpa_id_seq" via JDBC Statement

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop sequence player_jpa_id_seq" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlString(SchemaDropperImpl.java:419) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlStrings(SchemaDropperImpl.java:403) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:286) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:178) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:149) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:117) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:242) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:143) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:140) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:333) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:415) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1425) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) ~[spring-orm-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:362) ~[spring-orm-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:338) ~[spring-orm-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1788) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1737) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:604) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:526) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1132) ~[spring-context-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:907) ~[spring-context-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-6.0.0-M2.jar!/:6.0.0-M2]
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:145) ~[spring-boot-3.0.0-M1.jar!/:3.0.0-M1]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:719) ~[spring-boot-3.0.0-M1.jar!/:3.0.0-M1]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:401) ~[spring-boot-3.0.0-M1.jar!/:3.0.0-M1]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:302) ~[spring-boot-3.0.0-M1.jar!/:3.0.0-M1]
        at com.pingcap.App.main(App.java:13) ~[classes!/:0.0.1]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) ~[spring-jpa-hibernate-0.0.1.jar:0.0.1]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:95) ~[spring-jpa-hibernate-0.0.1.jar:0.0.1]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) ~[spring-jpa-hibernate-0.0.1.jar:0.0.1]
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65) ~[spring-jpa-hibernate-0.0.1.jar:0.0.1]
Caused by: java.sql.SQLException: Unknown SEQUENCE: 'test.player_jpa_id_seq'
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129) ~[mysql-connector-java-8.0.28.jar!/:8.0.28]
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) ~[mysql-connector-java-8.0.28.jar!/:8.0.28]
        at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:763) ~[mysql-connector-java-8.0.28.jar!/:8.0.28]
        at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:648) ~[mysql-connector-java-8.0.28.jar!/:8.0.28]
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.0.1.jar!/:na]
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.0.1.jar!/:na]
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54) ~[hibernate-core-6.0.0.CR2.jar!/:6.0.0.CR2]
        ... 42 common frames omitted

Hibernate: create sequence player_jpa_id_seq start with 1 increment by 1
Hibernate: create table player_jpa (id bigint not null, coins integer, goods integer, primary key (id)) engine=InnoDB
2022-03-23 15:54:26.162  INFO 36591 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-03-23 15:54:26.167  INFO 36591 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-03-23 15:54:26.417  WARN 36591 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
2022-03-23 15:54:26.425  WARN 36591 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
2022-03-23 15:54:26.461  WARN 36591 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-03-23 15:54:26.608  INFO 36591 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-03-23 15:54:26.613  INFO 36591 --- [           main] com.pingcap.App                          : Started App in 2.192 seconds (JVM running for 2.396)
2022-03-23 15:54:38.094  INFO 36591 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-03-23 15:54:38.094  INFO 36591 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-03-23 15:54:38.095  INFO 36591 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select nextval(player_jpa_id_seq)
Hibernate: insert into player_jpa (coins, goods, id) values (?, ?, ?)
Hibernate: select p1_0.id,p1_0.coins,p1_0.goods from player_jpa p1_0 where p1_0.id=?
2022-03-23 15:54:38.540  WARN 36591 --- [nio-8080-exec-1] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: SELECT * FROM player_jpa LIMIT ?
2022-03-23 15:54:38.590  WARN 36591 --- [nio-8080-exec-5] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: select p1_0.id,p1_0.coins,p1_0.goods from player_jpa p1_0 limit ?,?
2022-03-23 15:54:38.614  WARN 36591 --- [nio-8080-exec-5] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: select count(p1_0.id) from player_jpa p1_0
2022-03-23 15:54:38.645  WARN 36591 --- [nio-8080-exec-7] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.lock.timeout], use [jakarta.persistence.lock.timeout] instead
Hibernate: select count(p1_0.id) from player_jpa p1_0
Hibernate: select p1_0.id,p1_0.coins,p1_0.goods from player_jpa p1_0 where p1_0.id=?
Hibernate: select p1_0.id,p1_0.coins,p1_0.goods from player_jpa p1_0 where p1_0.id=?
Hibernate: update player_jpa set coins=?, goods=? where id=?
Hibernate: update player_jpa set coins=?, goods=? where id=?
^C2022-03-23 15:57:44.678  INFO 36591 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-03-23 15:57:44.679  INFO 36591 --- [ionShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: drop table if exists player_jpa
Hibernate: drop sequence player_jpa_id_seq
2022-03-23 15:57:44.764  INFO 36591 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-03-23 15:57:44.770  INFO 36591 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
make[2]: *** [run] Error 130
make[1]: *** [all] Interrupt: 2
make: *** [spring-jpa-hibernate] Interrupt: 2
```
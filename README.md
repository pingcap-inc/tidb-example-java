# tidb-example-java

## Outline

It's an example for Java and TiDB. Contains subproject:

- [plain-java-jdbc](#plain-java-jdbc)
- [plain-java-hibernate](#plain-java-hibernate)
- [plain-java-mybatis](#plain-java-mybatis)
- [spring-jpa-hibernate](#spring-jpa-hibernate)

We use different frameworks or libraries to implement similar processes to reflect 
the solution for connecting to TiDB in different environments

This is a process about the game, each player has two attributes, 
`coins` and `goods`, and each player has their own unique `id` as an identifier. 
Players can trade with each other, provided that the `coins` and `goods` are sufficient

The process is as follows:

1. Create a player
2. Create some players
3. Read players amount
4. Read some players attributes
5. Two player trade with insufficient coins or goods
6. Two player trade with sufficient coins or goods

## Dependency

- [Java 17](https://www.oracle.com/java/technologies/downloads/) ([OpenJDK](https://openjdk.java.net/) also supports)
- [Maven](https://maven.apache.org/)
- mysql client

## plain-java-jdbc

It's an example used plain Java and JDBC to connect TiDB.

### Running way

1. Makefile(recommend)
   - Run `make plain-java-jdbc`

2. Manual
   - Run [create table sql](./plain-java-jdbc/src/main/resources/dbinit.sql) in your TiDB
   - Into `plain-java-jdbc`
   - Run `mvn clean package`
   - Run `java -jar target/plain-java-jdbc-0.0.1-jar-with-dependencies.jar`

### Expected output

plain-java-jdbc [expected output](./Expected-Output.md#plain-java-jdbc)

### Code

- [Initial SQL](./plain-java-jdbc/src/main/resources/dbinit.sql)
- [Main Class](./plain-java-jdbc/src/main/java/com/pingcap/JDBCExample.java)

## plain-java-hibernate

> *Notes:*
> Hibernate 6.0.0.Beta2 and above supports the TiDB dialect, so our examples
> will be written based on this version, and we recommend using this version when connecting to TiDB as well

It's an example used plain Java and Hibernate to connect TiDB.

### Running way

1. Makefile(recommend)
    - Run `make plain-java-hibernate`

2. Manual
    - Into `plain-java-hibernate`
    - Run `mvn clean package`
    - Run `java -jar target/plain-java-hibernate-0.0.1-jar-with-dependencies.jar`

### Expected output
plain-java-hibernate [expected output](./Expected-Output.md#plain-java-hibernate)

### Code

- [Hibernate Config](./plain-java-hibernate/src/main/resources/hibernate.cfg.xml)
- [Main Class](./plain-java-hibernate/src/main/java/com/pingcap/App.java)
- [Data Access Object](./plain-java-hibernate/src/main/java/com/pingcap/PlayerDAO.java)
- [Data Entity](./plain-java-hibernate/src/main/java/com/pingcap/PlayerBean.java)

## plain-java-mybatis

It's an example used plain Java and Mybatis to connect TiDB.

### Running way

1. Makefile(recommend)
    - Run `make plain-java-mybatis`

2. Manual
    - Into `plain-java-mybatis`
    - Run `mvn clean package`
    - Run `java -jar target/plain-java-mybatis-0.0.1-jar-with-dependencies.jar`

### Code generate

1. Makefile(recommend)
    - Run `make plain-java-mybatis-gen`

2. Manual
    - Into `plain-java-mybatis`
    - Remove `src/main/java/com/pingcap/dao/Player.java`
    - Remove `src/main/java/com/pingcap/dao/PlayerMapper.java`
    - Remove `src/main/resources/mapper/PlayerMapper.xml`
    - Run `mvn mybatis-generator:generate`

### Expected output
plain-java-mybatis [expected output](./Expected-Output.md#plain-java-mybatis)

### Code

#### Config

- [Mybatis Generator Config](./plain-java-mybatis/src/main/resources/mybatis-generator.xml)
- [Mybatis Config](./plain-java-mybatis/src/main/resources/mybatis-config.xml)
- [Player Mapper (Auto-generated code)](./plain-java-mybatis/src/main/resources/mapper/PlayerMapper.xml)
- [Player Mapper Extend](./plain-java-mybatis/src/main/resources/mapper/PlayerMapperEx.xml)

#### Java Code

- [Main Class](./plain-java-mybatis/src/main/java/com/pingcap/MybatisExample.java)
- [Player Data Model (Auto-generated code)](./plain-java-mybatis/src/main/java/com/pingcap/model/Player.java)
- [Player Mapper Interface (Auto-generated code)](./plain-java-mybatis/src/main/java/com/pingcap/model/PlayerMapper.java)
- [Player Mapper Interface Extend](./plain-java-mybatis/src/main/java/com/pingcap/model/PlayerMapperEx.java)
- [Player DAO](./plain-java-mybatis/src/main/java/com/pingcap/dao/PlayerDAO.java)

## spring-jpa-hibernate

> *Notes:*
> Hibernate 6.0.0.Beta2 and above supports the TiDB dialect, so our examples
> will be written based on this version, and we recommend using this version when connecting to TiDB as well

It's an example service used Spring Boot, JPA and Hibernate to connect TiDB. 
Provide a group of HTTP Restful interface.

### Running way

1. Makefile(recommend)
   1. First terminal
       - Run `make spring-jpa-hibernate`
   2. Second terminal
       - Run `make request`
   3. You can quit first terminal or run `make stop` to stop service

2. Manual
    - Into `spring-jpa-hibernate`
    - Run `mvn clean package`
    - Run `java -jar target/spring-jpa-hibernate-0.0.1.jar`
    - Request:
      - Option 1 (recommend):
        - Input [Request Collection](spring-jpa-hibernate/Player.postman_collection.json) to [Postman](https://www.postman.com/)
        - Request by Postman application
      - Option 2:
        - Using [script](spring-jpa-hibernate/request.sh) to request. It's based on `curl`
      - Option 3:
        - Request HTTP Restful interface by other way
   
### Expected output

1. request [expected output](./Expected-Output.md#spring-jpa-hibernate-request)
2. service [expected output](./Expected-Output.md#spring-jpa-hibernate-service)

### Code

- [Application Config](./spring-jpa-hibernate/src/main/resources/application.yml)
- [Main Class](./spring-jpa-hibernate/src/main/java/com/pingcap/App.java)
- controller (Provide HTTP Restful interface)
  - [PlayerController](./spring-jpa-hibernate/src/main/java/com/pingcap/controller/PlayerController.java)
- dao (Data access object)
  - [Data Entity](./spring-jpa-hibernate/src/main/java/com/pingcap/dao/PlayerBean.java)
  - [Data Repository](./spring-jpa-hibernate/src/main/java/com/pingcap/dao/PlayerRepository.java)
- service (Feature interface and implement)
  - [Interface](./spring-jpa-hibernate/src/main/java/com/pingcap/service/PlayerService.java)
  - [Implement Class](./spring-jpa-hibernate/src/main/java/com/pingcap/service/impl/PlayerServiceImpl.java)

## More Demo

- [plain-java-jdbc-bookshop](./plain-java-jdbc-bookshop/README.md)
- [plain-java-txn-optimistic](./plain-java-txn-optimistic/README.md)
- [plain-java-txn-pessimistic](./plain-java-txn-pessimistic/README.md)
- [plain-java-write-skew](./plain-java-write-skew/README.md)
- [plain-java-batch-update](./plain-java-batch-update/README.md)
- [plain-java-batch-delete](./plain-java-batch-delete/README.md)

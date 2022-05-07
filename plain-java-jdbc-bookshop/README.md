# plain-java-jdbc-bookshop

It's an example, which is based on the bookshop application dataset, used plain Java and JDBC to connect TiDB.

## Running way

1. Makefile(recommend)

- Run `make all`

2. Manual

- Run `tiup demo bookshop prepare` to create the data structure on TiDB
- Run `mvn clean package`
- Run `java -jar target/plain-java-jdbc-bookshop-0.0.1-jar-with-dependencies.jar`

## Code

- [Get Data From Single Table Example Main Class](./src/main/java/com/pingcap/example/GetDataFromSingleTableExample.java)
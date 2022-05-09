# plain-java-batch-delete

This is an example of a pessimistic transaction using TiDB and plain Java and JDBC.

## Running way

1. Makefile(recommend)

- Run `make all`

2. Manual

- Run `mvn clean package` to clean and package JAR file.
- Run `tiup demo bookshop prepare --drop-tables --books 0 --authors 0 --orders 0 --ratings 0 --users 0` to create the data structure only.
- Run `java -jar target/plain-java-txn-pessimistic-0.0.1-jar-with-dependencies.jar ALICE_NUM=4 BOB_NUM=6` to check not oversell example output.
- Run `tiup demo bookshop prepare --drop-tables --books 0 --authors 0 --orders 0 --ratings 0 --users 0` to create the data structure again.
- Run `java -jar target/plain-java-txn-pessimistic-0.0.1-jar-with-dependencies.jar ALICE_NUM=4 BOB_NUM=6` to check oversell example output.

## Code

- [Pessimistic Transaction Example](./src/main/java/com/pingcap/txn/PessimisticTxnExample.java)
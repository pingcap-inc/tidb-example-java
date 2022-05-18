# plain-java-batch-delete

This is an example of a bulk-delete using TiDB and plain Java and JDBC.

## Running way

1. Makefile(recommend)

- Run `make all`

2. Manual

- Run `tiup demo bookshop prepare --drop-tables` to create the data structure and data on TiDB.
- Run `mvn clean package`.
- Run `java -jar target/plain-java-batch-delete-0.0.1-jar-with-dependencies.jar`.

## Code

- [Batch Delete Example](./src/main/java/com/pingcap/bulkDelete/BatchDeleteExample.java)

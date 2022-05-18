# plain-java-batch-batch

This is an example of a bulk-batch using TiDB and plain Java and JDBC.

## Running way

1. Makefile(recommend)

- Run `make all`.

2. Manual

- Run `tiup demo bookshop prepare --drop-tables` to create the data structure and data on TiDB.
- Run `mysql --host 127.0.0.1 --port 4000 -u root<add_attr_ten_point.sql` to add `ten_point` field.
- Run `mvn clean package`.
- Run `java -jar target/plain-java-batch-batch-0.0.1-jar-with-dependencies.jar`.

## Code

- [Batch Update Example](./src/main/java/com/pingcap/bulkUpdate/BatchUpdateExample.java)

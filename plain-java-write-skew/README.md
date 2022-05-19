# plain-java-batch-delete

This is an example of write skew using TiDB and plain Java and JDBC.

## Running way

1. Makefile(recommend)

- Run `make all`

2. Manual

- Run `mvn clean package` to clean and package JAR file.
- Run `java -jar target/plain-java-write-skew-0.0.1-jar-with-dependencies.jar`.

## Code

- [Write Skew Example](./src/main/java/com/pingcap/EffectWriteSkew.java)
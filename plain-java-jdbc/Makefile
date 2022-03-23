.PHONY: all mysql build run

all:
	make mysql build run

mysql:
	mysql --host 127.0.0.1 --port 4000 -u root<src/main/resources/dbinit.sql

build:
	mvn clean package

run:
	java -jar target/plain-java-jdbc-0.0.1-jar-with-dependencies.jar
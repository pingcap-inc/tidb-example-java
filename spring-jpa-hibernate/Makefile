.PHONY: all build run stop

all:
	make build run

build:
	mvn clean package

run:
	java -jar target/spring-jpa-hibernate-0.0.1.jar

stop:
	kill `cat spring-jpa-hibernate.pid`

request:
	./request.sh

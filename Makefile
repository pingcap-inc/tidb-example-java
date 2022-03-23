.PHONY: plain-java-jdbc plain-java-hibernate spring-jpa-hibernate request stop

plain-java-jdbc:
	$(MAKE) -C plain-java-jdbc

plain-java-hibernate:
	$(MAKE) -C plain-java-hibernate

spring-jpa-hibernate:
	$(MAKE) -C spring-jpa-hibernate

request:
	$(MAKE) -C spring-jpa-hibernate request

stop:
	$(MAKE) -C spring-jpa-hibernate stop

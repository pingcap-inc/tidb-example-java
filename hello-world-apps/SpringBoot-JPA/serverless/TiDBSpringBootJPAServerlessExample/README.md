# TiDBSpringBootJPAServerlessExample

> **Note:**
>
> This example showcases only the core part of building a Hello World program. For a more comprehensive and detailed example of CRUD operations, transactions, and other functionalities, please refer to the [Build a TiDB App Using Spring Boot](https://docs.pingcap.com/tidb/stable/dev-guide-sample-application-java-spring-boot).

This article explains how to build a Hello World application for TiDB using [Spring Boot](https://spring.io/projects/spring-boot) and [Spring Data JPA](https://spring.io/projects/spring-data-jpa). It includes the following steps:

1. Connect to the TiDB cluster and execute the `SELECT 'Hello World'` SQL query.
2. Retrieve the result of the SQL query.
3. Make an HTTP API call and display the SQL query result `Hello World` in the response.

## Prerequisites

Before reading this article, make sure you have the following resources ready:

- Create a [TiDB Serverless Tier cluster](https://docs.pingcap.com/tidbcloud/dev-guide-build-cluster-in-cloud) or [TiDB cluster](https://docs.pingcap.com/tidb/stable/quick-start-with-tidb).
- Install [JDK](https://openjdk.org/projects/jdk/17/), version 11 or above is required.
- Install [IntelliJ IDEA](https://www.jetbrains.com/idea/).
- Clone this repository and navigate to the current folder.

## 1. Get TiDB Cluster Connection Parameters

Get the connection parameters for the TiDB Serverless cluster, including `host`, `port`, `user`, `password`, and `ssl_ca`. For detailed steps, please refer to the [Obtain TiDB Serverless Connection Parameters](https://docs.pingcap.com/tidbcloud/connect-via-standard-connection-serverless#obtain-tidb-serverless-connection-parameter) documentation.

## 2. Modify Configuration File

Modify the `application.yaml` configuration file. Replace the placeholders like `${host}` in the configuration file:

![hello-world-java-spring-boot-jpa-config-serverless](/media/hello-world-java-spring-boot-jpa-config-serverless.jpeg)

## 3. Run

![hello-world-java-spring-boot-jpa-run](/media/hello-world-java-spring-boot-jpa-run.jpg)

## 4. Request

Use any web browser capable of sending network requests to access `http://localhost:8080/hello`. Here, we'll use Chrome:

![hello-world-java-spring-boot-result](/media/hello-world-java-spring-boot-result.jpg)

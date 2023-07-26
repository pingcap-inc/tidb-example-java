# TiDBSpringBootMyBatisServerlessExample

> **Note:**
>
> This example showcases only the core part of building a Hello World program. For a more comprehensive and detailed example of CRUD operations, transactions, and other functionalities, please refer to the [Build a TiDB App Using Spring Boot](https://docs.pingcap.com/tidb/stable/dev-guide-sample-application-java-spring-boot).

This article explains how to build a Hello World application for TiDB using [Spring Boot](https://spring.io/projects/spring-boot) and [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html). It includes the following steps:

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

获取 TiDB Serverless 集群的连接参数，包括 `host`、`port`、`user`、`password` 和 `ssl_ca`。详细步骤，请参考[获取 TiDB Serverless 连接参数](https://docs.pingcap.com/tidbcloud/connect-via-standard-connection-serverless#obtain-tidb-serverless-connection-parameter)。

## 2. Modify Configuration File

Modify the `application.yaml` configuration file. Replace the placeholders like `${host}` in the configuration file:

![hello-world-java-spring-boot-mybatis-config-serverless](/media/hello-world-java-spring-boot-mybatis-config-serverless.jpg)

## 3. Run

![hello-world-java-spring-boot-mybatis-run](/media/hello-world-java-spring-boot-mybatis-run.jpg)

## 4. Request

Use any web browser capable of sending network requests to access `http://localhost:8080/hello`. Here, we'll use Chrome:

![hello-world-java-spring-boot-result](/media/hello-world-java-spring-boot-result.jpg)

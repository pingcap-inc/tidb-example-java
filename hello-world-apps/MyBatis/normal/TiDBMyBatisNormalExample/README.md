# TiDBMyBatisNormalExample

> **Note:**
>
> This example showcases only the core part of building a Hello World program. For a more comprehensive and detailed example of CRUD operations, transactions, and other functionalities, please refer to the [Build a Simple CRUD App with TiDB and Mybatis](https://docs.pingcap.com/tidbcloud/dev-guide-sample-application-java-mybatis).

This example explains how to build a Hello World application for TiDB using [Mybatis](https://mybatis.org/mybatis-3/index.html). It includes the following steps:

1. Connect to the TiDB cluster and execute the `SELECT 'Hello World'` SQL query.
2. Retrieve the result of the SQL query.
3. Output the query result `Hello World`.

## Prerequisites

Before reading this article, make sure you have the following resources ready:

- Create a [TiDB Serverless Tier cluster](https://docs.pingcap.com/tidbcloud/dev-guide-build-cluster-in-cloud) or [TiDB cluster](https://docs.pingcap.com/tidb/stable/quick-start-with-tidb).
- Install [JDK](https://openjdk.org/projects/jdk/17/), version 11 or above is required.
- Install [IntelliJ IDEA](https://www.jetbrains.com/idea/).
- Clone this repository and navigate to the current folder.

## 1. Get TiDB Cluster Connection Parameters

Retrieve the `host`, `port`, `user`, and `password` parameters for the locally deployed TiDB cluster. The default connection parameters for a cluster deployed using `tiup playground` are as follows:

```properties
host: '127.0.0.1'
port: 4000
user: 'root'
password: ''
```

## 2. Modify Configuration File

Modify the `mybatis-config.xml` configuration file under `src/main/resources`. Replace the placeholders like `${host}` in the configuration file:

![hello-world-java-maven-quickstart-mybatis-config](/media/hello-world-java-maven-quickstart-mybatis-config.jpg)

## 3. Run

![hello-world-java-mybatis-run](/media/hello-world-java-mybatis-run.jpg)

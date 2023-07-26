# TiDBHibernateServerlessExample

> **Note:**
>
> This example showcases only the core part of building a Hello World program. For a more comprehensive and detailed example of CRUD operations, transactions, and other functionalities, please refer to the [Build a Simple CRUD App with TiDB and Hibernate](https://docs.pingcap.com/tidbcloud/dev-guide-sample-application-java-hibernate).

This example explains how to build a Hello World application for TiDB using [Hibernate ORM](https://hibernate.org/orm/). It includes the following steps:

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

Get the connection parameters for the TiDB Serverless cluster, including `host`, `port`, `user`, `password`, and `ssl_ca`. For detailed steps, please refer to the [Obtain TiDB Serverless Connection Parameters](https://docs.pingcap.com/tidbcloud/connect-via-standard-connection-serverless#obtain-tidb-serverless-connection-parameter) documentation.

## 2. Modify Configuration File

Modify the `hibernate.cfg.xml` configuration file under `src/main/resources`. Replace the placeholders like `${host}` in the configuration file:

![hello-world-java-maven-quickstart-hibernate-config-serverless](/media/hello-world-java-maven-quickstart-hibernate-config-serverless.jpeg)

<details>

<summary>Curious about the <code>&amp;amp;</code> in the configuration?</summary>

This is actually an escape character in XML files. In XML, you should not directly use the `&` character because it is a special character. Instead, you need to use `&amp;` to replace the `&` character so that the XML parser can correctly interpret your string. Similarly, some common replacements are:
>
> - `&`: `&amp;`
> - `<`: `&lt;`
> - `>`: `&gt;`
> - `"`: `&quot;`
> - `'`: `&apos;`

</details>

## 3. Run

![hello-world-java-hibernate-run](/media/hello-world-java-hibernate-run.jpg)

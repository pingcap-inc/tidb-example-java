package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Connector {

  public static MysqlDataSource getDatasource() {
    // 1.1 Create a mysql data source instance
    MysqlDataSource mysqlDataSource = new MysqlDataSource();

    // 1.2 Set server name, port, database name , username and password
    mysqlDataSource.setServerName("localhost");
    mysqlDataSource.setPortNumber(4000);
    mysqlDataSource.setDatabaseName("bookshop");
    mysqlDataSource.setUser("root");
    mysqlDataSource.setPassword("");

    // Or you can use jdbc string instead
    // mysqlDataSource.setURL("jdbc:mysql://{host}:{port}/test?user={user}&password={password}");
    return mysqlDataSource;
  }

}

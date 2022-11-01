// Copyright 2022 PingCAP, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.pingcap;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.net.URL;
import java.sql.*;

/**
 * Main class for the basic JDBC example.
 **/
public class JDBCExample
{
    public static void main(String[] args) throws SQLException {
        // 1. Create a mysql data source instance.
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        // 2. Set connection properties
        mysqlDataSource.setServerName("{serverless tier host}");
        mysqlDataSource.setPortNumber(4000);
        mysqlDataSource.setDatabaseName("test");
        mysqlDataSource.setUser("{serverless tier username}");
        mysqlDataSource.setPassword("{serverless tier password}");

        // If you are using serverless tier at TiDB Cloud, you mast use TLS to link it
        mysqlDataSource.setUseSSL(true);
        URL jks = ClassLoader.getSystemResource("test-tidb.key");
        mysqlDataSource.setTrustCertificateKeyStoreUrl(jks.toExternalForm());
        mysqlDataSource.setTrustCertificateKeyStorePassword("{key password}");

        // You can use jdbc string instead.
        // mysqlDataSource.setURL("jdbc:mysql://{host}:{port}/test?user={user}&password={password}&useSSL=true" +
        //         "&trustCertificateKeyStoreUrl={key path}&trustCertificateKeyStorePassword={key password}");

        Connection connection = mysqlDataSource.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT VERSION()");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}

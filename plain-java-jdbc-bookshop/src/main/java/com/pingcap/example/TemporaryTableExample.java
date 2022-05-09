package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TemporaryTableExample {

  public static class AuthorDAO {

    private final MysqlDataSource ds;

    AuthorDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Author> getTop50EldestAuthorInfo() throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        conn.setAutoCommit(false);

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("""
          CREATE GLOBAL TEMPORARY TABLE IF NOT EXISTS top_50_eldest_authors (
              id BIGINT,
              name VARCHAR(255),
              age INT,
              PRIMARY KEY(id)
          ) ON COMMIT DELETE ROWS;
        """);

        stmt.executeUpdate("""
          INSERT INTO top_50_eldest_authors
          SELECT a.id, a.name, (IFNULL(a.death_year, YEAR(NOW())) - a.birth_year) AS age
          FROM authors a
          ORDER BY age DESC
          LIMIT 50;
        """);

        ResultSet rs = stmt.executeQuery("""
          SELECT id, name FROM top_50_eldest_authors;
        """);

        conn.commit();
        while (rs.next()) {
          Author author = new Author();
          author.setId(rs.getLong("id"));
          author.setName(rs.getString("name"));
          authors.add(author);
        }
      }
      return authors;
    }

  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data
    AuthorDAO authorDAO = new AuthorDAO(datasource);

    // 3. Run examples.
    runTemporaryTableExample(authorDAO);
  }

  public static void runTemporaryTableExample(AuthorDAO authorDAO) throws SQLException {
    List<Author> top50EldestAuthorInfo = authorDAO.getTop50EldestAuthorInfo();
    System.out.printf("Get top 50 eldest authors, got %d.\n", top50EldestAuthorInfo.size());
  }

}

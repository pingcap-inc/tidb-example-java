package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommonTableExpressionExample {

  public static class AuthorDAO {

    private final MysqlDataSource ds;

    AuthorDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Author> getTop50EldestAuthorInfoByCTE() throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
          WITH top_50_eldest_authors_cte AS (
            SELECT a.id, a.name, (IFNULL(a.death_year, YEAR(NOW())) - a.birth_year) AS age
            FROM authors a
            ORDER BY age DESC
            LIMIT 50
          )
          SELECT
            ANY_VALUE(ta.id) AS author_id,
            ANY_VALUE(ta.name) AS author_name,
            ANY_VALUE(ta.age) AS author_age,
            COUNT(*) AS books
          FROM top_50_eldest_authors_cte ta
          LEFT JOIN book_authors ba ON ta.id = ba.author_id
          GROUP BY ta.id;
        """);
        while (rs.next()) {
          Author author = new Author();
          author.setId(rs.getLong("author_id"));
          author.setName(rs.getString("author_name"));
          author.setAge(rs.getShort("author_age"));
          author.setBooks(rs.getInt("books"));
          authors.add(author);
        }
      }
      return authors;
    }

  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data.
    AuthorDAO authorDAO = new AuthorDAO(datasource);

    // 3. Run examples.
    List<Author> top50EldestAuthorInfo = authorDAO.getTop50EldestAuthorInfoByCTE();
    System.out.printf("Get top 50 eldest authors, got %d.\n", top50EldestAuthorInfo.size());
  }

}

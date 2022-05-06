package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromSingleTableExample {

  public static class AuthorDAO {

    private final MysqlDataSource ds;

    AuthorDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Author> getAuthors() throws SQLException {
      List<Author> authors = new ArrayList<>();

      try (
          Connection conn = ds.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM authors");
      ) {
        while (rs.next()) {
          Author author = new Author();
          author.setId( rs.getLong("id"));
          author.setName(rs.getString("name"));
          authors.add(author);
        }
      }
      return authors;
    }

    public List<Author> getAuthorsByName(String name) throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("SELECT id, name FROM authors WHERE name LIKE CONCAT('%', ?,'%')");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Author author = new Author();
          author.setId( rs.getLong("id"));
          author.setName(rs.getString("name"));
          authors.add(author);
        }
      }
      return authors;
    }

    public List<Author> getAuthorsByBirthYear(Short birthYear) throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("""
                SELECT * FROM authors WHERE birth_year = ?;
                """);
        stmt.setShort(1, birthYear);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Author author = new Author();
          author.setId( rs.getLong("id"));
          author.setName(rs.getString("name"));
          authors.add(author);
        }
      }
      return authors;
    }

    public List<Author> getTop10AuthorsOrderByBooks() throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
                SELECT ANY_VALUE(a.id) AS author_id, ANY_VALUE(a.name) AS author_name, COUNT(ba.book_id) AS books
                FROM authors a
                JOIN book_authors ba ON a.id = ba.author_id
                GROUP BY ba.author_id
                ORDER BY books DESC
                LIMIT 10;
                """);
        while (rs.next()) {
          Author author = new Author();
          author.setId(rs.getLong("author_id"));
          author.setName(rs.getString("author_name"));
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

    // 2. And then, create DAO to manager your data
    AuthorDAO authorDAO = new AuthorDAO(datasource);

    // 3. Run examples.
    System.out.printf("Get %d authors.\n", authorDAO.getAuthors().size());
    System.out.printf("Get %d authors by name 'Dare'.\n", authorDAO.getAuthorsByName("Dare").size());
    short birthYear = 1998;
    System.out.printf("Get %d authors by birth year and gender.\n", authorDAO.getAuthorsByBirthYear(birthYear).size());
    System.out.printf("Get top %d authors order by books.\n", authorDAO.getTop10AuthorsOrderByBooks().size());
  }

}

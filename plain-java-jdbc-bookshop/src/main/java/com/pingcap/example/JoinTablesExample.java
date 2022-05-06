package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinTablesExample {

  public static class BookDAO {
    private final MysqlDataSource ds;

    BookDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Book> getLatestBooksWithAverageScore() throws SQLException {
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
          SELECT b.id AS book_id, ANY_VALUE(b.title) AS book_title, AVG(r.score) AS average_score
          FROM books b
          LEFT JOIN ratings r ON b.id = r.book_id
          GROUP BY b.id
          ORDER BY b.published_at DESC
          LIMIT 10;
        """);
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("book_id"));
          book.setTitle(rs.getString("book_title"));
          book.setAverageScore(rs.getFloat("average_score"));
          books.add(book);
        }
      }
      return books;
    }
  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data.
    BookDAO bookDAO = new BookDAO(datasource);

    // 3. Run some simple example.
    List<Book> books = bookDAO.getLatestBooksWithAverageScore();
    System.out.printf("Get %d books:\n", books.size());
    System.out.println(Arrays.toString(books.toArray()));
  }
}

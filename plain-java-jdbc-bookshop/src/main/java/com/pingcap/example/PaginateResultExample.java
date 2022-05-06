package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaginateResultExample {

  public static class PageMeta<K> {
    private Long pageNum;
    private K startKey;
    private K endKey;
    private Long pageSize;

    public PageMeta() {
    }

    public Long getPageNum() {
      return pageNum;
    }

    public void setPageNum(Long pageNum) {
      this.pageNum = pageNum;
    }

    public K getStartKey() {
      return startKey;
    }

    public void setStartKey(K startKey) {
      this.startKey = startKey;
    }

    public K getEndKey() {
      return endKey;
    }

    public void setEndKey(K endKey) {
      this.endKey = endKey;
    }

    public Long getPageSize() {
      return pageSize;
    }

    public void setPageSize(Long pageSize) {
      this.pageSize = pageSize;
    }

    @Override
    public String toString() {
      return "PageMeta{" +
          "pageNum=" + pageNum +
          ", startKey=" + startKey +
          ", endKey=" + endKey +
          ", pageSize=" + pageSize +
          '}';
    }
  }

  public static class BookDAO {
    private final MysqlDataSource ds;

    BookDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Book> getLatestBooksPage(Long pageNumber, Long pageSize) throws SQLException {
      pageNumber = pageNumber < 1L ? 1L : pageNumber;
      pageSize = pageSize < 10L ? 10L : pageSize;
      Long offset = (pageNumber - 1) * pageSize;
      Long limit = pageSize;
      List<Book> books = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("""
          SELECT id, title, published_at
          FROM books
          ORDER BY published_at DESC
          LIMIT ?, ?;
        """);
        stmt.setLong(1, offset);
        stmt.setLong(2, limit);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          Book book = new Book();
          book.setId(rs.getLong("id"));
          book.setTitle(rs.getString("title"));
          book.setPublishedAt(rs.getDate("published_at"));
          books.add(book);
        }
      }
      return books;
    }

    public List<PageMeta<Long>> getPageMetaList() throws SQLException {
      List<PageMeta<Long>> pageMetaList = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("""
          SELECT
              floor((t.row_num - 1) / 1000) + 1 AS page_num,
              min(t.id) AS start_key,
              max(t.id) AS end_key,
              count(*) AS page_size
          FROM (
              SELECT *, row_number () OVER (ORDER BY id) AS row_num
              FROM books
          ) t
          GROUP BY page_num
          ORDER BY page_num;
        """);
        while (rs.next()) {
          PageMeta<Long> pageMeta = new PageMeta<>();
          pageMeta.setPageNum(rs.getLong("page_num"));
          pageMeta.setStartKey(rs.getLong("start_key"));
          pageMeta.setEndKey(rs.getLong("end_key"));
          pageMeta.setPageSize(rs.getLong("page_size"));
          pageMetaList.add(pageMeta);
        }
      }
      return pageMetaList;
    }

    public void deleteBooksByPageMeta(PageMeta<Long> pageMeta) throws SQLException {
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM books WHERE id >= ? AND id <= ?");
        stmt.setLong(1, pageMeta.getStartKey());
        stmt.setLong(2, pageMeta.getEndKey());
        stmt.executeUpdate();
      }
    }
  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data
    BookDAO bookDAO = new BookDAO(datasource);

    // 3. Run examples.
    runGetBooksByPageExample(bookDAO);
    runDeleteBooksByPageExample(bookDAO);
  }

  public static void runGetBooksByPageExample(BookDAO bookDAO) throws SQLException {
    Long pageNumber = 1L;
    Long pageSize = 20L;
    List<Book> latestBooksPage = bookDAO.getLatestBooksPage(pageNumber, pageSize);
    System.out.printf("Get books by page, except %d books on page %d, actual got %d.\n",
        pageSize, pageNumber, latestBooksPage.size());
  }

  public static void runDeleteBooksByPageExample(BookDAO bookDAO) throws SQLException {
    List<PageMeta<Long>> pageMetaList = bookDAO.getPageMetaList();

    // Delete books on page 1.
    if (pageMetaList.size() > 0) {
      bookDAO.deleteBooksByPageMeta(pageMetaList.get(0));
      System.out.println("Deleted books on page 1.");
    }

    // Delete books on all pages.
    bookDAO.getPageMetaList().forEach((pageMeta) -> {
      try {
        bookDAO.deleteBooksByPageMeta(pageMeta);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    });
    System.out.println("Deleted books on every page.");
  }
}

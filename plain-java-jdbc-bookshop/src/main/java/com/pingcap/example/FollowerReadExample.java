package com.pingcap.example;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pingcap.example.domain.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FollowerReadExample {

  public enum FollowReadMode {
    LEADER("leader"),
    FOLLOWER("follower"),
    LEADER_AND_FOLLOWER("leader-and-follower");

    private final String mode;

    FollowReadMode(String mode) {
      this.mode = mode;
    }

    public String getMode() {
      return mode;
    }
  }

  public static class FollowerReadHelper {

    public static void setSessionReplicaRead(Connection conn, FollowReadMode mode) throws SQLException {
      if (mode == null) mode = FollowReadMode.LEADER;
      try (PreparedStatement stmt = conn.prepareStatement(
          "SET @@tidb_replica_read = ?;"
      )) {
        stmt.setString(1, mode.getMode());
        stmt.execute();
      }
    }

    public static void setGlobalReplicaRead(Connection conn, FollowReadMode mode) throws SQLException {
      if (mode == null) mode = FollowReadMode.LEADER;
      PreparedStatement stmt = conn.prepareStatement(
          "SET GLOBAL @@tidb_replica_read = ?;"
      );
      stmt.setString(1, mode.getMode());
      stmt.execute();
    }

  }

  public static class AuthorDAO {

    private final MysqlDataSource ds;

    AuthorDAO(MysqlDataSource ds) {
      this.ds = ds;
    }

    public List<Author> getAuthorsByBirthYear(Integer birthYear) throws SQLException {
      List<Author> authors = new ArrayList<>();
      try (Connection conn = ds.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement("SELECT id, name FROM authors WHERE birth_year = ?");
        stmt.setInt(1, birthYear);
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

    public void getAuthorsByFollowerRead() throws SQLException {
      try (Connection conn = ds.getConnection()) {
        // Enable the follower read feature.
        FollowerReadHelper.setSessionReplicaRead(conn, FollowReadMode.LEADER_AND_FOLLOWER);

        // Read the authors list for 1000 times.
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
          Integer birthYear = 1920 + random.nextInt(100);
          List<Author> authors = this.getAuthorsByBirthYear(birthYear);
          System.out.println(authors.size());
        }

        // TODO: If we have a better way to observe that TiDB reads data
        //       from the follower region, we will update this example.
      }
    }

  }

  public static void main(String[] args) throws SQLException {
    // 1. Configure the example database connection.
    MysqlDataSource datasource = Connector.getDatasource();

    // 2. And then, create DAO to manager your data.
    AuthorDAO authorDAO = new AuthorDAO(datasource);

    // 3. Run examples.
    authorDAO.getAuthorsByFollowerRead();
  }

}

package ru.kpfu.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.aop.Loggable;
import ru.kpfu.bookstore.models.Book;


@Repository
public class BookRepository implements IBookRepository {

  @Autowired
  private DataSource dataSource;

  @Loggable
  public Book findById(int id) {

    String sql = "SELECT * FROM book WHERE id = ?";
    Connection conn = null;
    Book book = null;

    try {
      conn = dataSource.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        book = new Book(
          rs.getInt("id"),
          rs.getString("name")
        );
      }
      rs.close();
      ps.close();
      return book;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
  }
}

package ru.kpfu.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.kpfu.bookstore.models.Book;

@Repository
public class JdbcBookRepository implements BookRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Book find(int id) {
    Book book = jdbcTemplate.queryForObject(
      "select * from book where id = ?",
      new Object[]{id},
      new RowMapper<Book>() {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
          Book book = new Book();
          book.setId(rs.getInt("id"));
          book.setName(rs.getString("name"));
          return book;
        }
      });
    return book;
  }

}

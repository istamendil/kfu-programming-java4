package ru.kpfu.bookstore.dao;

import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.kpfu.bookstore.model.Book;

@Repository
public class JdbcBookDao implements BookDao { // What methods should we add by typical DAO definition?

  private JdbcTemplate jdbcTemplate;

  @Autowired
  @Qualifier("dataSource")
  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Book find(int id) {
    Book book = jdbcTemplate.queryForObject(
      "select * from book where id = ?",
      new Object[]{id},
      (ResultSet rs, int rowNum) -> { // Lambda or RowMapper implementation
        Book book1 = new Book();
        book1.setId(rs.getInt("id"));
        book1.setName(rs.getString("name"));
        return book1;
      }
    );
    return book;
  }

}

package ru.kpfu.springjdbc.dao;

import org.springframework.stereotype.Repository;
import ru.kpfu.springjdbc.model.Book;

// Dao or Repository?
@Repository
public interface BookDao {
  public Book find(int id);
}

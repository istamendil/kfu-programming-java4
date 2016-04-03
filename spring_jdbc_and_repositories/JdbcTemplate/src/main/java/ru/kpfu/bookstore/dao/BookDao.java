package ru.kpfu.bookstore.dao;

import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.model.Book;

// Dao or Repository?
@Repository
public interface BookDao {
  public Book find(int id);
}

package ru.kpfu.bookstore.dao;

import ru.kpfu.bookstore.models.Book;

public interface BookRepository {
  public Book find(int id);
}

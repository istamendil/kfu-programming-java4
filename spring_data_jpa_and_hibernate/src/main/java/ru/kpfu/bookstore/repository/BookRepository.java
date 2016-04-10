package ru.kpfu.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.model.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer>{}

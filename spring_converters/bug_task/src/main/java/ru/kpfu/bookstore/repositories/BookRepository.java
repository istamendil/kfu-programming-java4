package ru.kpfu.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.models.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer>{}

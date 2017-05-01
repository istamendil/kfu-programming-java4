package ru.kpfu.springconverterstask.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.springconverterstask.models.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer>{}

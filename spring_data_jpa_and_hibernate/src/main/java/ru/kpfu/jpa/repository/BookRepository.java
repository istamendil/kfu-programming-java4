package ru.kpfu.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.jpa.model.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer>{}

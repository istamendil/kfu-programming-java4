package ru.kpfu.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.kpfu.bookstore.dao.BookRepository;
import ru.kpfu.bookstore.models.Book;

@Controller
public class DefaultController {
  
  @Autowired
  private BookRepository bookRepo;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(ModelMap map) {
    Book book = bookRepo.find(1);
    map.put("bookName", book.getName());
    return "index";
  }

}

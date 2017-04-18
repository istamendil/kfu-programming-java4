package ru.kpfu.springjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.kpfu.springjdbc.dao.BookDao;
import ru.kpfu.springjdbc.model.Book;

@Controller
public class DefaultController {
  
  @Autowired
  private BookDao bookRepo; // 1) Why interface instead of class? 2) Should we add one more level of abstraction?

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(ModelMap map) {
    Book book = bookRepo.find(1); // Here on another abstraction level catch org.springframework.dao.EmptyResultDataAccessException
    map.put("book", book);
    return "index";
  }

}

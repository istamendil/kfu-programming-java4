package ru.kpfu.jpa.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.jpa.model.Book;
import ru.kpfu.jpa.repository.BookRepository;

@Controller
public class BookController {

  @Autowired
  private BookRepository bookRepo;

  @RequestMapping("/")
  public String list(ModelMap map) {
    map.put("books", bookRepo.findAll());
    return "books/list";
  }

  @RequestMapping("/book/{id}")
  public String show(@PathVariable int id, ModelMap map) {
    map.put("book", bookRepo.findOne(id));
    return "books/show";
  }

  @RequestMapping(value = "/new_book", method = RequestMethod.GET)
  public String add(ModelMap map) {
    map.put("book", new Book());
    return "books/book_form";
  }

  @RequestMapping(value = "/new_book", method = RequestMethod.POST)
  public String formHandler(
    RedirectAttributes redirectAttributes,
    @Valid Book book,
    BindingResult result,
    ModelMap map
  ) {

    if (result.hasErrors()) {
      return "books/book_form";
    } else {
      bookRepo.save(book);
      redirectAttributes.addFlashAttribute("message", "Book \"" + book.getName() + "\" has been added successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#add").build();
    }
  }

  @RequestMapping("/book/{id}/delete")
  public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, ModelMap map) {
    try{
      bookRepo.delete(id);
      redirectAttributes.addFlashAttribute("message", "Book has been deleted successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
    }
    catch(EmptyResultDataAccessException e){
      redirectAttributes.addFlashAttribute("message", "Can't find book with id " + id);
      redirectAttributes.addFlashAttribute("messageType", "fail");
    }
    catch(DataAccessException e){
      redirectAttributes.addFlashAttribute("message", "Can't delete book with id " + id);
      redirectAttributes.addFlashAttribute("messageType", "fail");
    }
    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#list").build();
  }
}

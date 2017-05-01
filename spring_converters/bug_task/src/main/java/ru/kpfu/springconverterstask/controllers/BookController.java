package ru.kpfu.springconverterstask.controllers;

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

import ru.kpfu.springconverterstask.exceptions.NotFoundException;
import ru.kpfu.springconverterstask.models.Book;
import ru.kpfu.springconverterstask.repositories.BookRepository;
import ru.kpfu.springconverterstask.repositories.PublishingHouseRepository;

@Controller
public class BookController {

  @Autowired
  private BookRepository bookRepo;

  @Autowired
  private PublishingHouseRepository publishingHouseRepository;

  @RequestMapping("/")
  public String list(ModelMap map) {
    map.put("books", bookRepo.findAll());
    return "books/list";
  }

  @RequestMapping("/book/{id}")
  public String show(@PathVariable int id, ModelMap map) {
    Book book = bookRepo.findOne(id);
    if (book == null) {
      throw new NotFoundException("book");
    }
    map.put("book", book);
    return "books/show";
  }

  @RequestMapping(value = "/book/new", method = RequestMethod.GET)
  public String add(ModelMap map) {
    map.put("book", new Book());
    return showForm(map);
  }

  @RequestMapping(value = "/book/new", method = RequestMethod.POST)
  public String addHandler(
    RedirectAttributes redirectAttributes,
    @ModelAttribute("book") @Valid Book book,
    BindingResult result,
    ModelMap map
  ) {
    if (result.hasErrors()) {
      return showForm(map);
    } else {
      bookRepo.save(book);
      redirectAttributes.addFlashAttribute("message", "Book \"" + book.getName() + "\" has been saved successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#add").build();
    }
  }

  @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
  public String edit(@PathVariable int id, ModelMap map) {
    Book book = bookRepo.findOne(id);
    if (book == null) {
      throw new NotFoundException("book");
    }
    map.put("book", book);
    return showForm(map);
  }

  @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.POST)
  public String editHandler(
    RedirectAttributes redirectAttributes,
    @ModelAttribute("book") @Valid Book book,
    BindingResult result,
    ModelMap map
  ) {
    if (result.hasErrors()) {
      return showForm(map);
    } else {
      bookRepo.save(book);
      redirectAttributes.addFlashAttribute("message", "Book \"" + book.getName() + "\" has been saved successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#edit").arg(0, book.getId()).build();
    }
  }

  @RequestMapping("/book/delete/{id}")
  public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, ModelMap map) {
    try {
      bookRepo.delete(id);
      redirectAttributes.addFlashAttribute("message", "Book has been deleted successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
    } catch (EmptyResultDataAccessException e) {
      redirectAttributes.addFlashAttribute("message", "Can't find book with id " + id);
      redirectAttributes.addFlashAttribute("messageType", "fail");
    } catch (DataAccessException e) {
      redirectAttributes.addFlashAttribute("message", "Can't delete book with id " + id);
      redirectAttributes.addFlashAttribute("messageType", "fail");
    }
    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#list").build();
  }

  protected String showForm(ModelMap map) {
    map.put("publishingHouses", publishingHouseRepository.findAll());
    return "books/book_form";
  }
}

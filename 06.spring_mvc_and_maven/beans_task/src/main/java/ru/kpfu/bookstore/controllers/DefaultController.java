package ru.kpfu.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.bookstore.services.MyService;

@Controller
public class DefaultController {
  @Autowired
  private MyService service;
  
  @RequestMapping("/")
  @ResponseBody
  public String index(){
    return service.getMessage();
  }
}

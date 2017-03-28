package ru.kpfu.springjtwig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

  @RequestMapping
  public String index(ModelMap map) {
    map.put("name", "World");
    return "test";
  }
}

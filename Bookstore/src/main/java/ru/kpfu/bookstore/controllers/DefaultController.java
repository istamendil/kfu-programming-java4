package ru.kpfu.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.regex.;

@Controller
public class DefaultController {
    
   @RequestMapping("/")
   public String index(ModelMap map) {
       map.put("siteName", "Books of Universe");
       return "index";
   }
    
   @RequestMapping("/hello")
   public String hello(@RequestParam(value="name", defaultValue="defaultName") String name, ModelMap map) {
       map.put("name", name);
       return "hello";
   }
    
}

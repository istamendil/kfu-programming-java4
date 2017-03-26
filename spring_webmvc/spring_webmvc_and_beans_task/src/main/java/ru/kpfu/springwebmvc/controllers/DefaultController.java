package ru.kpfu.springwebmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
@Controller
public class DefaultController {
  
  @RequestMapping("/")
  @ResponseBody
  public String index(){
//    return messageService.getHello();
    return "Hello world from controller.";
  }
}

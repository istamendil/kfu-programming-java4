package ru.kpfu.springviewresolver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets <istamendil.info>
 */
@Controller
public class DefaultController {
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(ModelMap map) {
       map.put("name", "Student");
       return "index";
   }
    
}

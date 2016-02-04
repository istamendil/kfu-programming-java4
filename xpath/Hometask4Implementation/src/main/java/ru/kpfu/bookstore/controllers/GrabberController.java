package ru.kpfu.bookstore.controllers;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.bookstore.forms.GrabberForm;
import ru.kpfu.bookstore.services.Grabber;
import ru.kpfu.bookstore.validators.GrabberFormValidator;

@Controller
@RequestMapping("/")
public class GrabberController {
  
  @Autowired
  Grabber grabber;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(new GrabberFormValidator());
  }

  @RequestMapping(method = RequestMethod.GET)
  public String show(ModelMap map) {
    map.put("grabberForm", new GrabberForm());
    return "form";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String process(
    RedirectAttributes redirectAttributes,
    @Validated GrabberForm grabberForm,
    BindingResult result,
    ModelMap map
  ) {
    
    if (!result.hasErrors()) {
      try{
        ArrayList<String> data = grabber.grab(grabberForm.getUrl(), grabberForm.getXpath());
        map.put("data", data);
      }
      catch(IOException e){
        map.put("message", "Error with opening page: " + e.toString());
      }
      catch(Exception e){
        map.put("message", "Exception has been thrown: " + e.toString());
      }
    }
    
    return "form";
  }
}

package ru.kpfu.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.bookstore.exceptions.SomeException0;
import ru.kpfu.bookstore.exceptions.SomeException1;
import ru.kpfu.bookstore.exceptions.SomeException2;
import ru.kpfu.bookstore.exceptions.SomeException3;

@Controller
@RequestMapping("/")
public class SomeController {

  @RequestMapping
  public void index(ModelMap map) {
    throw new NotFoundException();
  }

  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Some exception text")
  @ExceptionHandler(SomeException0.class)
  public void standard() {}

  @ExceptionHandler({SomeException1.class, SomeException2.class})
  public String simpleView() {
    return "staticExceptionView";
  }

  @ExceptionHandler(NotFoundException3.class)
  public ModelAndView informedView(HttpServletRequest req, Exception exception) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("exceptionViewWithInfo");
    return mav;
  }

}

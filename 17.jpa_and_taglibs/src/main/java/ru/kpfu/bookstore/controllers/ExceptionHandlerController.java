package ru.kpfu.bookstore.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(Exception.class)
  public ModelAndView informedView(HttpServletRequest req, Exception exception) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error/default");
    return mav;
  }
}

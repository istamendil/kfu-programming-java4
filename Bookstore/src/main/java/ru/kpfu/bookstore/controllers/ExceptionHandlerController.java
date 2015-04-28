package ru.kpfu.bookstore.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.bookstore.exceptions.NotFoundException;

/**
 * Handle exceptions and show proper views.
 * @author Alexander Ferenets <istamendil.info>
 */
@ControllerAdvice
public class ExceptionHandlerController{
  
  /**
   * All unhandled exceptions
   * @param req
   * @param exception
   * @return 
   */
  //@ExceptionHandler(Throwable.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView notFound2(HttpServletRequest req, Exception exception) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error/default");
    return mav;
  }
  
  /**
   * Special exceptions.NotFoundException with Entity property Instead of message.
   * @param req
   * @param exception
   * @return 
   */
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ModelAndView notFound(HttpServletRequest req, Exception exception) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName("error/not_found");
    return mav;
  }
}

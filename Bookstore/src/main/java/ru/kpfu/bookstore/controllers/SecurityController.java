package ru.kpfu.bookstore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.bookstore.models.User;
import ru.kpfu.bookstore.models.forms.LoginForm;
import ru.kpfu.bookstore.repositories.UserAuthorityRepository;
import ru.kpfu.bookstore.services.UserService;

@Controller
public class SecurityController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserAuthorityRepository userAuthorityRepo;
  
  protected String showRegisterForm(ModelMap map){
    map.put("userAuthorities", userAuthorityRepo.findAll());
    return "security/register_form";
  }

  @RequestMapping(value = "/login")
  @PreAuthorize("isAnonymous()")
  public String login(@RequestParam(required = false) String error, @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap map) {
    map.put("error", error);
    return "security/login_form";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  @PreAuthorize("isAnonymous()")
  public String register(ModelMap map) {
    map.put("user", new User());
    return showRegisterForm(map);
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @PreAuthorize("isAnonymous()")
  public String registerHandler(
    RedirectAttributes redirectAttributes,
    @ModelAttribute("user") @Valid User user,
    BindingResult result,
    ModelMap map
  ) {
    if (!result.hasErrors()) {
      try{
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("message", "You has been registered successfully");
        redirectAttributes.addFlashAttribute("messageType", "success");
        return "redirect:" + MvcUriComponentsBuilder.fromPath("/").build();
      }
      catch(DuplicateKeyException ex){
        result.rejectValue("username", "entry.duplicate", "There is account with such email already.");
      }
    }
    return showRegisterForm(map);
  }

  @RequestMapping("/profile")
  @PreAuthorize("isAuthenticated()")
  public String profile(HttpServletRequest request) {
    return "security/profile";
  }
}

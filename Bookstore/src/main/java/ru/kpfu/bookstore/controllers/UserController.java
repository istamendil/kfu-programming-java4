package ru.kpfu.bookstore.controllers;

import java.util.Set;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.bookstore.exceptions.NotFoundException;
import ru.kpfu.bookstore.models.User;
import ru.kpfu.bookstore.repositories.UserAuthorityRepository;
import ru.kpfu.bookstore.repositories.UserRepository;
import ru.kpfu.bookstore.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserAuthorityRepository userAuthorityRepo;
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private UserService userService;
  
  @Autowired
  private Validator validator;
  
  protected String showForm(ModelMap map){
    map.put("authorities", userAuthorityRepo.findAll());
    return "user/form";
  }
  
  @RequestMapping("/list")
  @PreAuthorize("hasRole('ADMIN')")
  public String list(ModelMap map) {
    map.put("users", userRepo.findAll());
    return "user/list";
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  @PreAuthorize("hasRole('ADMIN')")
  public String edit(@PathVariable int id, ModelMap map) {
    User user = userRepo.findOne(id);
    if (user == null) {
      throw new NotFoundException("user");
    }
    map.put("user", user);
    return showForm(map);
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
  @PreAuthorize("hasRole('ADMIN')")
  public String editHandler(
    RedirectAttributes redirectAttributes,
    @PathVariable int id,
    @ModelAttribute("user") User data,
    ModelMap map
  ) {
    User user;
    try{
      user = userService.updateFullNameAndAuthorities(id, data.getFullName(), data.getAuthorities());
    }
    catch(EntityNotFoundException ex){
      throw new NotFoundException("user");
    }
    Set<ConstraintViolation<User>> cv = validator.validate(user, Default.class);
    if (cv.isEmpty()){
      userRepo.save(user);
      redirectAttributes.addFlashAttribute("message", "User \"" + user.getUsername() + "\" has been saved successfully");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("UC#edit").arg(0, user.getId()).build();
    }
    return showForm(map);
  }
}

package ru.kpfu.formsvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.formsvalidation.model.Author;
import ru.kpfu.formsvalidation.model.AuthorValidator;

@Controller
@RequestMapping("/spring")
public class SpringController {

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(new AuthorValidator());// Task: NPE
  }

  @RequestMapping(value = "/new_author", method = RequestMethod.GET)
  public String newAuthor(ModelMap map) {
    map.put("author", new Author());
    return "author_form";
  }

  @RequestMapping(value = "/new_author", method = RequestMethod.POST)
  public String springHandler(
    RedirectAttributes redirectAttributes,
    @Validated @ModelAttribute("author") Author author,
    BindingResult result,
    ModelMap map
  ) {
    if (result.hasErrors()) {
      return "author_form";
    } else {
      redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Author \"" + author.getName() + "\" has been added successfully</span>");
      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#newAuthor").build();
    }

  }
}

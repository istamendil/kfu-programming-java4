package ru.kpfu.formsvalidation.model;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AuthorValidator implements Validator {

  @Override
  public boolean supports(Class clazz) {
    return Author.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors e) {
    ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
    Author a = (Author) obj;
    try {
      new URL(a.getAvatarUrl());
    } catch (MalformedURLException ex) {
      e.reject("avatarUrl", "URL.incorrect");
    }
  }
}

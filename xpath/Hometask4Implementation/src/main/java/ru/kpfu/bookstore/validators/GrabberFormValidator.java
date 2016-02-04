package ru.kpfu.bookstore.validators;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.bookstore.forms.GrabberForm;

public class GrabberFormValidator implements Validator {

  @Override
  public boolean supports(Class clazz) {
    return GrabberForm.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors e) {
    GrabberForm grabber = (GrabberForm) obj;
    
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "url", "url.empty");
    if(!e.hasFieldErrors("url")){
      try {
        new URL(grabber.getUrl());
      } catch (MalformedURLException ex) {
        e.rejectValue("url", "url.format");
      }
    }
    
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "xpath", "xpath.empty");
    if(!e.hasFieldErrors("xpath")){
      try {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(grabber.getXpath());
      } catch (XPathExpressionException ex) {
        e.rejectValue("xpath", "xpath.format");
      }
    }
  }
}

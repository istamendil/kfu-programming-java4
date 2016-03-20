package ru.kpfu.bookstore.config;

import javax.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ru.kpfu.bookstore.utils.StringToEntityConverter;
import ru.kpfu.bookstore.models.PublishingHouse;
import ru.kpfu.bookstore.models.UserAuthority;

@Configuration
@ComponentScan("ru.kpfu.bookstore")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public UrlBasedViewResolver setupViewResolver() {
    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/assets/");//ToDo: update to better paths
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/403").setViewName("error/access_denied");
    registry.addViewController("/about").setViewName("static/about");
  }
  
  @Bean
  public Validator validator(){
    return new LocalValidatorFactoryBean();
  }

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {
    formatterRegistry.addConverter(publishingHouseGenericConverter());
    formatterRegistry.addConverter(userAuthorityGenericConverter());
  }

  @Bean
  public StringToEntityConverter publishingHouseGenericConverter(){
    return new StringToEntityConverter(PublishingHouse.class);
  }
  @Bean
  public StringToEntityConverter userAuthorityGenericConverter(){
    return new StringToEntityConverter(UserAuthority.class);
  }
}

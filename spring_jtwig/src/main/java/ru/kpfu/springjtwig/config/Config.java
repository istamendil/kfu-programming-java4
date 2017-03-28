package ru.kpfu.springjtwig.config;

import org.jtwig.spring.JtwigViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("ru.kpfu.springjtwig.controllers")
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    JtwigViewResolver resolver = new JtwigViewResolver();
    resolver.setPrefix("web:/WEB-INF/views/");
    resolver.setSuffix(".twig.html");
    resolver.setRedirectContextRelative(false);
    return resolver;
  }
}

package ru.kpfu.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.kpfu.bookstore.services.MyService;

@Configuration
@ComponentScan("ru.kpfu.bookstore")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
  @Bean
  public MyService service(){
    return new MyService();
  }
}

package ru.kpfu.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ru.kpfu.bookstore.converters.StringToEntityConverter;
import ru.kpfu.bookstore.converters.StringToPublishingHouseConverter;
import ru.kpfu.bookstore.models.PublishingHouse;

@Configuration
@ComponentScan("ru.kpfu.bookstore")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
  
  @Autowired
  private StringToPublishingHouseConverter stringToPublishingHouseConverter;

  @Override
  public void addFormatters(FormatterRegistry formatterRegistry) {
  	// One or another
    //formatterRegistry.addConverter(publishingHouseGenericConverter());
    //formatterRegistry.addConverter(stringToPublishingHouseConverter);
  }

  @Bean
  public StringToEntityConverter publishingHouseGenericConverter(){
    return new StringToEntityConverter(PublishingHouse.class);
  }
}

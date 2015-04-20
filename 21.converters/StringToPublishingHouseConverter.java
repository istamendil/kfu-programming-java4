package ru.kpfu.bookstore.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ru.kpfu.bookstore.models.PublishingHouse;
import ru.kpfu.bookstore.repositories.PublishingHouseRepository;

@Component
public class StringToPublishingHouseConverter implements Converter<String, PublishingHouse> {

  @Autowired
  private PublishingHouseRepository publishingHouseRepository;

  @Override
  public PublishingHouse convert(String s) {
    if(s.equals("NONE")){
      return null;
    }
    return publishingHouseRepository.findOne(Integer.parseInt(s));
  }
  
}

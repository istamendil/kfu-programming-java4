package ru.kpfu.springconverterstask.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import ru.kpfu.springconverterstask.models.PublishingHouse;
import ru.kpfu.springconverterstask.repositories.PublishingHouseRepository;

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

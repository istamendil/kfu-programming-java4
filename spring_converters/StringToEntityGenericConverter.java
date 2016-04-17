package ru.kpfu.bookstore.converters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Converter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

public class StringToEntityConverter implements GenericConverter {

  private final Class<?> clazz;

  @PersistenceContext
  private EntityManager em;

  public StringToEntityConverter(Class<?> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public Set<ConvertiblePair> getConvertibleTypes() {
    Set<ConvertiblePair> types = new HashSet<GenericConverter.ConvertiblePair>();
    types.add(new ConvertiblePair(String.class, this.clazz));
    types.add(new ConvertiblePair(this.clazz, String.class));
    return types;
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    if (String.class.equals(sourceType.getType())) {
      if (!StringUtils.hasText((String) source) || ((String) source).equals("NONE")) {
        return null;
      }
      Integer id = Integer.parseInt((String) source);
      return this.em.find(this.clazz, id);
    } else if (this.clazz.equals(sourceType.getType())) {
      if (source == null) {
        return "";
      } else {
        try {
          Method method = this.clazz.getMethod("getId");
          return method.invoke(source, null).toString();
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
          throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type: can't call getId method of " + this.clazz.getName() + "!");
        }
      }
    }
    throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type!");
  }
}

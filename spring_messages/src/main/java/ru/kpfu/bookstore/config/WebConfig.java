package ru.kpfu.bookstore.config;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("ru.kpfu.bookstore.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public UrlBasedViewResolver setupViewResolver() {
    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
    res.setBasenames("classpath:i18n/messages", "classpath:i18n/validation");
    res.setCacheSeconds(0);
    res.setDefaultEncoding("UTF-8");
    res.setUseCodeAsDefaultMessage(false);
    return res;
  }

  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setCookieName("lang");
    localeResolver.setDefaultLocale(new Locale("ru", "RU"));
    return localeResolver;
  }
}

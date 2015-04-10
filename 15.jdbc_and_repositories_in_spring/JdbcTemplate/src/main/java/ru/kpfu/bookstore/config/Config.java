package ru.kpfu.bookstore.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("ru.kpfu.bookstore")
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

  @Bean
  public UrlBasedViewResolver setupViewResolver() {
    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/test");
    dataSource.setUsername("root");
    dataSource.setPassword("");;
    return dataSource;
  }
}

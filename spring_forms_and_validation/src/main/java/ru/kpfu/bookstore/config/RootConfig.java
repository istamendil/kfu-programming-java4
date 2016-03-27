package ru.kpfu.bookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.bookstore.model"})
@EnableWebMvc
public class RootConfig{}

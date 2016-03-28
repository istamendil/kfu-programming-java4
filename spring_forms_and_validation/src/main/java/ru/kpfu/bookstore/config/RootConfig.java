package ru.kpfu.bookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.bookstore.model"})
public class RootConfig{}

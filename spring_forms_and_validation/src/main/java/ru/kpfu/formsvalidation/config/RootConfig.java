package ru.kpfu.formsvalidation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.formsvalidation.model"})
public class RootConfig{}

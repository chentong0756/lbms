package com.lbms.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages="com.lbms.serviceimpl")
@ImportResource("classpath:spring-service.xml")
public class ServiceConfig {

}
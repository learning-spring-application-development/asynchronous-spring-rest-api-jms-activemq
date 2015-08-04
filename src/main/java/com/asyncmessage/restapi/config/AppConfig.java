package com.asyncmessage.restapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:app-conf.xml")
public class AppConfig {

}

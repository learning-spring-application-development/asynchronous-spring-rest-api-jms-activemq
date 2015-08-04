package com.asyncmessage.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Ravi Kant Soni
 * @since Aug/04/2015 {@link learningspringapplicationdevelopment.com}
 */
@SpringBootApplication
@EnableAsync
public class App {

	// http://localhost:8080/hello-world
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
package com.lti.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lti")
public class AirlinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}

}


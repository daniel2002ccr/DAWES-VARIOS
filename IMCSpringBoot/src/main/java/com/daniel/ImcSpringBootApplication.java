package com.daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.daniel.imc.controller")
public class ImcSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImcSpringBootApplication.class, args);
	}

}

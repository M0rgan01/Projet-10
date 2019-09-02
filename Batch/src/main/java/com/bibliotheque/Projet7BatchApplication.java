package com.bibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:batch.properties")
public class Projet7BatchApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Projet7BatchApplication.class, args);	

	}

}

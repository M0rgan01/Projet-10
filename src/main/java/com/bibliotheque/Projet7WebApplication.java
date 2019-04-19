package com.bibliotheque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.thymeleaf.spring5.SpringTemplateEngine;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;


@SpringBootApplication
public class Projet7WebApplication extends SpringBootServletInitializer implements CommandLineRunner   {

	public static void main(String[] args) {
		SpringApplication.run(Projet7WebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//ajout du dialect thymeleaf
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new LayoutDialect(new GroupingStrategy()));
				
	}

}

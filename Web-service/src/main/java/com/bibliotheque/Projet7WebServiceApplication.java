package com.bibliotheque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:bibliotheque.properties"),
    @PropertySource(value ="file:${catalina.home}/conf/Projet7-WebService/bibliotheque.properties", ignoreResourceNotFound = true),
    @PropertySource(value ="file:${catalina.home}/conf/Projet7-WebService/application.properties", ignoreResourceNotFound = true),
})
public class Projet7WebServiceApplication extends SpringBootServletInitializer implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	
	}

}

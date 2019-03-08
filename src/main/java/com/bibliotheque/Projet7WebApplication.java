package com.bibliotheque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.bibliotheque.service.BibliothequeServiceService;
import com.bibliotheque.service.BibliothequeWS;
import com.bibliotheque.service.Mail;
import com.bibliotheque.service.Utilisateur;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;

@SpringBootApplication
public class Projet7WebApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Projet7WebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new LayoutDialect(new GroupingStrategy()));
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		Utilisateur u1 = new Utilisateur();
		u1.setId(1l);
		u1.setPseudo("morgan3");
		u1.setPassWord("12345");
		u1.setActive(true);
		
			
//		Mail mail = new Mail();
//		mail.setEmail("@gmail.com");
//		mail.setUtilisateur(u1);
			
		ws.saveUtilisateur(u1);
		//ws.saveMail(mail);
	}

}

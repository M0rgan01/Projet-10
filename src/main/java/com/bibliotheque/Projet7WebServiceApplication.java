package com.bibliotheque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.MailBusiness;

@SpringBootApplication
public class Projet7WebServiceApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private KindRepository kindRepository;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private BookRepository ouvrageRepository;
	@Autowired
	private LoanRepository reservationRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private UserRepository utilisateurRepository;

	@Autowired
	private LoanBusiness reservationMetier;
	@Autowired
	private MailBusiness mailBusiness;

	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}

}

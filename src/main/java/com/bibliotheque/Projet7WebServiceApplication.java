package com.bibliotheque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.MailBusiness;

@SpringBootApplication
public class Projet7WebServiceApplication implements CommandLineRunner {

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
	
	public static final Logger logger = LoggerFactory.getLogger(Projet7WebServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Roles r1 = rolesRepository.save(new Roles("ROLE_USER"));
//		Roles r2 = rolesRepository.save(new Roles("ROLE_ADMIN"));
//////////	
//		Kind g1 = kindRepository.save(new Kind("aventure"));
//		Kind g2 = kindRepository.save(new Kind("horreur"));
//////////	
//		Ouvrage o1 = ouvrageRepository.save(new Ouvrage("Ouvrage 1", "Auteur 1", "Description 1", true, g1, 2));
//		Ouvrage o2 = ouvrageRepository.save(new Ouvrage("Ouvrage 2", "Auteur 2", "Description 2", true, g2, 3));
//////				
				//reservationMetier.createLoan(2l, 53l);
	}

}

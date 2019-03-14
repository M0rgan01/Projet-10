package com.bibliotheque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bibliotheque.dao.GenreRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.dao.OuvrageRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.dao.UtilisateurRepository;
import com.bibliotheque.entities.Genre;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.Utilisateur;


@SpringBootApplication
public class Projet7WebServiceApplication implements CommandLineRunner{

	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private OuvrageRepository ouvrageRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
			
//	Roles r1 = rolesRepository.save(new Roles("USER"));	
//	Roles r2 = rolesRepository.save(new Roles("ADMIN"));	
//	
	Genre g1 = genreRepository.save(new Genre("aventure"));
	Genre g2 = genreRepository.save(new Genre("horreur"));
//	
	Utilisateur u1 = new Utilisateur("morgan", "1234", true);
//	u1.getRoles().add(r1);
//	u1.getRoles().add(r2);
//	
	Utilisateur u2 =new Utilisateur("emilie", "1234", true);
//	u2.getRoles().add(r1);	
//		
	utilisateurRepository.save(u1);
	utilisateurRepository.save(u2);
//	
	mailRepository.save(new Mail("morgan@gmail.com", u1));
	mailRepository.save(new Mail("emilie@gmail.com", u2));
//	
	Ouvrage o1 = ouvrageRepository.save(new Ouvrage("Harry potter", "mary", "bla", true, g1));
	Ouvrage o2 = ouvrageRepository.save(new Ouvrage("Ouvrage horreur", "auteur", "bla", true, g2));
//	
//	reservationRepository.save(new Reservation(new Date(), new Date(), u1, o1));
//	reservationRepository.save(new Reservation(new Date(), new Date(), u2, o2));
	}


	
}

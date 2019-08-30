
package com.bibliotheque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.dao.RolesRepository;
import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.User;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.ReservationBusiness;
import com.bibliotheque.metier.UserBusiness;
import com.bibliotheque.utilities.Jasypt;

@SpringBootApplication
@PropertySources({ @PropertySource("classpath:bibliotheque.properties"),
		@PropertySource(value = "file:${catalina.home}/conf/Projet7-WebService/bibliotheque.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:${catalina.home}/conf/Projet7-WebService/application.properties", ignoreResourceNotFound = true), })
public class Projet7WebServiceApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private KindRepository kindRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoanBusiness loanBusiness;
	@Autowired
	private ReservationBusiness reservationBusiness;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Jasypt enJasypt;

	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//loanBusiness.createLoan(1l, 1l);
		// loanBusiness.returnLoan(1l);
		// loanBusiness.createLoan(4l, 1l);
		// loanBusiness.createLoan(4l, 2l);
	}
}

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
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.UserBusiness;
import com.bibliotheque.utilities.Jasypt;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:bibliotheque.properties"),
    @PropertySource(value ="file:${catalina.home}/conf/Projet7-WebService/bibliotheque.properties", ignoreResourceNotFound = true),
    @PropertySource(value ="file:${catalina.home}/conf/Projet7-WebService/application.properties", ignoreResourceNotFound = true),
})
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
	private Jasypt enJasypt;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Projet7WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User("Morgan", "YesYes123", true);
		User user2 = new User("Emilie", "YesYes123", true);
		
		user.setPassWord(enJasypt.setEncrypt(user.getPassWord()));
		user.setPassWordConfirm(enJasypt.setEncrypt("YesYes123"));
		user2.setPassWord(enJasypt.setEncrypt(user2.getPassWord()));
		user2.setPassWordConfirm(enJasypt.setEncrypt("YesYes123"));
		
		Mail mail = new Mail("pichat.morgan@gmail.com", user);
		Mail mail2 = new Mail("pichat2.morgan@gmail.com", user2);
		
		
		Roles role = new Roles("ROLE_USER");
		Roles role2 = new Roles("ROLE_ADMIN");
		
		rolesRepository.save(role);
		rolesRepository.save(role2);
		
		userBusiness.createUser(user, mail);
		userBusiness.createUser(user2, mail2);
		
		Kind kind = new Kind("Aventure");
		
		kindRepository.save(kind);
		
		Book book = new Book("test", "test", "test", false, kind, 10, 0);
		
		bookRepository.save(book);
		
		Reservation reservation = new Reservation(new Date(), user, book);
		Reservation reservation2 = new Reservation(new Date(), user2, book);
		
		reservationRepository.save(reservation);
		reservationRepository.save(reservation2);
		
		Loan loan = new Loan(new Date(),new Date(), user, book);
		
		loanRepository.save(loan);
		loanBusiness.returnLoan(loan.getId());
		
	}
}

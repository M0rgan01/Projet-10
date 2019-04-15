package com.bibliotheque.service;

import java.text.ParseException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.entities.Library;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.BookBusiness;
import com.bibliotheque.metier.KindBusiness;
import com.bibliotheque.metier.LibraryBusiness;
import com.bibliotheque.metier.LoanBusiness;
import com.bibliotheque.metier.MailBusiness;
import com.bibliotheque.metier.Pagination;
import com.bibliotheque.metier.RolesBusiness;
import com.bibliotheque.metier.UserBusiness;

/**
 * 
 * Web service de gestion d'une bibliotheque
 * 
 * @author pichat morgan
 *
 */
@Component
@WebService(name = "BibliothequeWS")
public class BibliothequeService {

	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private MailBusiness mailBusiness;
	@Autowired
	private BookBusiness bookBusiness;
	@Autowired
	private KindBusiness kindBusiness;
	@Autowired
	private LoanBusiness loanBusiness;
	@Autowired
	private RolesBusiness rolesBusiness;
	@Autowired
	private LibraryBusiness libraryBusiness;
	
//////////////////////// AUTHENTIFICATION - GESTION COMPTE UTILISATEUR ////////////////////////

	@WebMethod
	public void saveUser(@WebParam(name = "user") User user) throws BibliothequeException {
		userBusiness.saveUser(user);
	}

	@WebMethod
	public User createUser(@WebParam(name = "user") User user,
			@WebParam(name = "mail") Mail mail) throws BibliothequeException {
		return userBusiness.createUser(user, mail);
	}

	@WebMethod
	public void deleteUser(@WebParam(name = "id") Long id) {		
		userBusiness.disableUser(id);
	}

	@WebMethod
	public User getUser(@WebParam(name = "id") Long id) {
		return userBusiness.getUser(id);
	}

	@WebMethod
	public User doConnection(@WebParam(name = "pseudo") String pseudo,
			@WebParam(name = "passWord") String passWord) throws BibliothequeException {
		return userBusiness.doConnection(pseudo, passWord);
	}

	@WebMethod
	public void saveMail(@WebParam(name = "mail") Mail mail, @WebParam(name = "user_id") Long user_id)
			throws BibliothequeException {
		mailBusiness.saveMail(mail, user_id);
	}

	@WebMethod
	public Mail getMail(@WebParam(name = "user_id") Long id) {
		return mailBusiness.getMailByUserID(id);
	}

	@WebMethod
	public List<Roles> getListRoles(@WebParam(name = "pseudo") String pseudo) {
		return rolesBusiness.getListRoles(pseudo);
	}

	@WebMethod
	public void sendToken(@WebParam(name = "email") String email) throws BibliothequeException {
		mailBusiness.sendToken(email);		
	}
	
	@WebMethod
	public void validateToken(@WebParam(name = "email") String email,@WebParam(name = "token") String token) throws BibliothequeException {
		mailBusiness.validateToken(token, email);
	}
	
	@WebMethod
	public void editPassWordByRecovery(@WebParam(name = "email") String email, @WebParam(name = "password") String passWord, @WebParam(name = "passwordConfirm") String passWordConfirm) throws BibliothequeException {
		userBusiness.editPasswordByRecovery(email, passWord, passWordConfirm);
	}
	
	
//////////////////////// GESTION OUVRAGE - RECHERCHE ////////////////////////
	
	
	@WebMethod
	public void createBook(@WebParam(name = "book") Book book)
			throws BibliothequeException {
		bookBusiness.createBook(book);
	}

	@WebMethod
	public void updateBook(@WebParam(name = "book") Book book)
			throws BibliothequeException {
		bookBusiness.saveBook(book);
	}

	@WebMethod
	public void deleteBook(Long id) throws BibliothequeException {
		bookBusiness.deleteBook(id);
	}

	@WebMethod
	public Book getBook(Long id) throws BibliothequeException {
		return bookBusiness.getBook(id);
	}

	@WebMethod
	public Pagination<Book> listBook(@WebParam(name = "mot-cle") String mc, @WebParam(name = "kind") String kind,
			@WebParam(name = "available") boolean available, @WebParam(name = "page") int page,
			@WebParam(name = "size") int size) {
		return bookBusiness.listBook(mc, kind, available, page, size);
	}

	@WebMethod
	public List<Kind> getListKind() {
		return kindBusiness.getListKind();
	}

	@WebMethod
	public void saveLibrary(@WebParam(name = "library") Library library) {
		libraryBusiness.saveLibrary(library);
	}
	
	@WebMethod
	public List<Library> getListLibrary() {
		return libraryBusiness.getListLibrary();
	}
	
	@WebMethod
	public Library getLibrary(@WebParam(name = "library_id")Long id) {
		return libraryBusiness.getLibrary(id);
	}
	
//////////////////////// GESTION RESERVATION ////////////////////////
	
	
	@WebMethod
	public void createLoan(@WebParam(name = "book_id") Long book_id, @WebParam(name = "user_id") Long user_id)
			throws BibliothequeException, ParseException {
		loanBusiness.createLoan(book_id, user_id);
	}

	@WebMethod
	public void returnLoan(Long id) {
		loanBusiness.returnLoan(id);
	}

	@WebMethod
	public Loan getLoan(Long id) {
		return loanBusiness.getLoan(id);
	}

	@WebMethod
	public List<Loan> getListLoanByUserID(@WebParam(name = "user_id") Long user_id) {
		return loanBusiness.getListLoanByUserID(user_id);
	}

	@WebMethod
	public List<Loan> getListLoanLate() {
		return loanBusiness.getListLoanLate();
	}
	
	@WebMethod
	public List<Loan> getListLoanLateByUserID(
			@WebParam(name = "user_id") Long user_id) {
		return loanBusiness.getListLoanLateByUserID(user_id);
	}

	@WebMethod
	public void extendLoan(@WebParam(name = "Loan_ID")Long Loan_ID, @WebParam(name = "user_id") Long user_ID) throws BibliothequeException {
		loanBusiness.extendLoan(Loan_ID, user_ID);
	}

	@WebMethod
	public int getDaysExtend() throws BibliothequeException {
		return loanBusiness.getDaysExtend();
	}
	
	@WebMethod
	public int getDaysLoan() throws BibliothequeException {
		return loanBusiness.getDaysLoan();
	}
}

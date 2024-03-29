package com.bibliotheque.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class LoanBusinessImpl implements LoanBusiness {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private ReservationBusiness reservationBusiness;
	@Value("${prolongation.days}")
	private int extendDays;
	@Value("${loan.days}")
	private int loanDays;

	private static final Logger logger = LoggerFactory.getLogger(LoanBusinessImpl.class);

	@Override
	public Loan extendLoan(Long loan_ID, Long user_ID) throws BibliothequeException {
		Loan r = loanRepository.findById(loan_ID).orElse(null);

		if (r == null) {
			logger.error("loan id " + loan_ID + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("3");
			bibliothequeFault.setFaultString("loan.id.not.correct");

			throw new BibliothequeException("loan.id.not.correct", bibliothequeFault);

		} else if (r.getUser().getId() != user_ID) {

			logger.error("utilisateur id " + user_ID + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("4");
			bibliothequeFault.setFaultString("user.id.not.correct");

			throw new BibliothequeException("user.id.not.correct", bibliothequeFault);

		} else if (r.isExtension()) {

			logger.error("loan " + loan_ID + " already in extention");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("5");
			bibliothequeFault.setFaultString("loan.already.extention");

			throw new BibliothequeException("loan.already.extention", bibliothequeFault);

		// si l'emprunt est en retard
		} else if (new Date().after(r.getEnd_loan())) {

			logger.error("loan " + loan_ID + " late for extention");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("6");
			bibliothequeFault.setFaultString("loan.late");

			throw new BibliothequeException("loan.late", bibliothequeFault);
		}

		// on règle la date sur celle désirée
		Calendar c = Calendar.getInstance();
		c.setTime(r.getEnd_loan());
		c.add(Calendar.DATE, extendDays);

		r.setEnd_loan(c.getTime());
		r.setExtension(true);
		
		r = loanRepository.save(r);
		
		logger.info("Add " + extendDays + " days to loan " + loan_ID);
	
		//après sauvegarde, on ajuste la prochaine disponnibilité du livre si changement
		if (!r.getBook().isAvailable()) {
			r.getBook().setLoanBack(setLoanBackForBook(r.getBook().getId()));
			bookRepository.save(r.getBook());
		}
		
		return r;	
	}

	@Override
	@Transactional
	public Loan returnLoan(Long id) throws BibliothequeException {
		Loan loan = loanRepository.findById(id).orElse(null);
		loan.setMade(true);

		reservationBusiness.checkReservation(loan.getBook());
		
		logger.info("Close the loan " + id);
		
		return loanRepository.save(loan);
		
	}

	@Override
	public Loan getLoan(Long id) {
		logger.info("Get loan " + id);
		return loanRepository.findById(id).orElse(null);
	}

	@Override
	public Loan createLoan(Long book_id, Long User_id) throws BibliothequeException {
		User user = userBusiness.getUser(User_id);
		Book book = bookRepository.findById(book_id).orElse(null);

		if (book == null || book.isDisable()) {
			logger.error("book id " + book_id + " not correct");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("book.id.not.correct");

			throw new BibliothequeException("book.id.not.correct", bibliothequeFault);
		}

		if (book.getCopyAvailable() == 0) {
			logger.error("book " + book_id + " not available");
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("6");
			bibliothequeFault.setFaultString("loan.book.not.available");

			throw new BibliothequeException("loan.book.not.available", bibliothequeFault);
		}

		// on décrémente le nombre de copy disponible
		book.setCopyAvailable(book.getCopyAvailable() - 1);

		// on règle les dates de début et de fin
		Calendar c = Calendar.getInstance();
		Date start_loan = c.getTime();

		c.add(Calendar.DATE, loanDays);
		Date end_loan = c.getTime();

		// s'il est à 0 on rend le livre non disponible
		if (book.getCopyAvailable() == 0) {
			book.setAvailable(false);
			book.setAvailableReservation(true);
			book.setLoanBack(setLoanBackForBook(book.getId()));
		}
	
		bookRepository.save(book);
		logger.info("Update book " + book.getId());
		Loan loan = new Loan(start_loan, end_loan, user, book);		
		logger.info("Create loan " + loan.getId());
		return loanRepository.save(loan);
	}

	@Override
	public List<Loan> getListLoanByUserID(Long user_id) {
		logger.info("Get list of loan not late for user id " + user_id);
		return loanRepository.getListLoanByUserID(user_id, new Date());
	}

	@Override
	public List<Loan> getListLoanLateByUserID(Long user_id) {

		List<Loan> list = loanRepository.getListLoanLateByUserID(user_id, new Date());

		logger.info("Get list of loan late for user id " + user_id);

		return list;
	
	}

	@Override
	public int getDaysExtend() {
		return extendDays;
	}

	@Override
	public int getDaysLoan() {
		return loanDays;
	}

	@Override
	public List<Loan> getListLoanLate() {
		logger.info("Get list of loan late");
		return loanRepository.getListLoanLate(new Date());
	}

	@Override
	public Date setLoanBackForBook(Long book_id) {
		try {
			Loan loan = loanRepository.getListLoanByBookAndOrderByEndLoan(book_id).get(0);	
			return loan.getEnd_loan();
		} catch (IndexOutOfBoundsException e) {	}
				
		return null;		
	}

	
	
	
}

package com.bibliotheque.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.BookRepository;
import com.bibliotheque.dao.LoanRepository;
import com.bibliotheque.entities.Book;
import com.bibliotheque.entities.Loan;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
@PropertySource("classpath:bibliotheque.properties")
public class LoanBusinessImpl implements LoanBusiness {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserBusiness userBusiness;
	@Value("${prolongation.days}")
	private int extendDays;
	@Value("${loan.days}")
	private int loanDays;

	@Override
	public void extendLoan(Long loan_ID, Long user_ID) throws BibliothequeException {
		Loan r = loanRepository.findById(loan_ID).orElse(null);

		if (r == null) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("3");
			bibliothequeFault.setFaultString("loan.id.not.correct");

			throw new BibliothequeException("loan.id.not.correct", bibliothequeFault);

		} else if (r.getUser().getId() != user_ID) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("4");
			bibliothequeFault.setFaultString("user.id.not.correct");

			throw new BibliothequeException("user.id.not.correct", bibliothequeFault);

		} else if (r.isExtension()) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("5");
			bibliothequeFault.setFaultString("loan.already.extention");

			throw new BibliothequeException("loan.already.extention", bibliothequeFault);

			// s'il serra en retard après extention
		} else if (checkLate(r)) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("6");
			bibliothequeFault.setFaultString("loan.late.after.extention");

			throw new BibliothequeException("loan.late.after.extention", bibliothequeFault);
		}

		// on règle la date sur celle désirée
		Calendar c = Calendar.getInstance();
		c.setTime(r.getEnd_loan());
		c.add(Calendar.DATE, extendDays);

		r.setEnd_loan(c.getTime());
		r.setExtension(true);

		loanRepository.save(r);
	}

	@Override
	public void returnLoan(Long id) {
		Loan loan = loanRepository.findById(id).orElse(null);
		loan.setMade(true);
		loanRepository.save(loan);
	}

	@Override
	public Loan getLoan(Long id) {
		return loanRepository.findById(id).orElse(null);
	}

	@Override
	public void createLoan(Long book_id, Long User_id) throws BibliothequeException, ParseException {
		User user = userBusiness.getUser(User_id);
		Book book = bookRepository.findById(book_id).orElse(null);

		if (user == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("4");
			bibliothequeFault.setFaultString("user.id.not.correct");

			throw new BibliothequeException("user.id.not.correct", bibliothequeFault);

		} else if (book == null || book.isDisable()) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("book.id.not.correct");

			throw new BibliothequeException("book.id.not.correct", bibliothequeFault);
		}

		if (book.getCopyAvailable() == 0) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("6");
			bibliothequeFault.setFaultString("loan.book.not.available");

			throw new BibliothequeException("loan.book.not.available", bibliothequeFault);
		}

		// on décrémente le nombre de copy disponible
		book.setCopyAvailable(book.getCopyAvailable() - 1);

		// s'il est à 0 on rend le livre non disponible
		if (book.getCopyAvailable() == 0)
			book.setAvailable(false);

		// on règle les dates de début et de fin
		Calendar c = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		c.setTime(sdf.parse("2019-01-25"));
		Date start_loan = c.getTime();

		c.add(Calendar.DATE, loanDays);
		Date end_loan = c.getTime();

		bookRepository.save(book);
		loanRepository.save(new Loan(start_loan, end_loan, user, book));
	}

	@Override
	public List<Loan> getListLoanByUserID(Long user_id) {
		return loanRepository.getListLoanByUserID(user_id, new Date());
	}

	@Override
	public List<Loan> getListLoanLateByUserID(Long user_id) {

		List<Loan> list = loanRepository.getListLoanLateByUserID(user_id, new Date());

		for (Loan loan : list) {
			// si l'emprunt n'est pas en extention
			if (!loan.isExtension()) {
				// on regarde s'il serra en retard après extention
				if (checkLate(loan))
					loan.setLate(true);
			}
		}
		return list;
	}

	public boolean checkLate(Loan loan) {
		Calendar c = Calendar.getInstance();
		c.setTime(loan.getEnd_loan());
		c.add(Calendar.DATE, extendDays);
		Date retard = c.getTime();

		if (retard.before(new Date())) {
			return true;
		}
		return false;
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
		return loanRepository.getListLoanLate(new Date());
	}

}

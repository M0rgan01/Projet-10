package com.bibliotheque.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bibliotheque.pager.PagerModel;
import com.bibliotheque.service.BibliothequeException_Exception;
import com.bibliotheque.service.BibliothequeServiceService;
import com.bibliotheque.service.BibliothequeWS;
import com.bibliotheque.service.Book;
import com.bibliotheque.service.Kind;
import com.bibliotheque.service.Loan;
import com.bibliotheque.service.Mail;
import com.bibliotheque.service.Pagination;
import com.bibliotheque.service.Roles;
import com.bibliotheque.service.User;
import com.bibliotheque.utilities.Encrypt;
import com.bibliotheque.utilities.Messages;

@Controller
public class BibliothequeController {

	@Autowired
	private Encrypt encrypt;
	@Autowired
	private Messages messages;
	
	// page d'accueil
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index() {	
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {	
		return "Authentification/login";
	}

//////////////////////// RECHERCHE ////////////////////////

	@RequestMapping(value = "/recherche")
	public String recherche(Model model, @RequestParam(name = "page", defaultValue = "0") Optional<Integer> page,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "MotCle", defaultValue = "") String mc,
			@RequestParam(name = "genre", defaultValue = "") String genre, boolean isReserved) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		// si page est null ou inferieur a 0, on lui assigne 0, sinon on le decremente
		int evalPage = (page.orElse(0) < 1) ? 0 : page.get() - 1;

		Pagination list = ws.listBook(mc, genre, isReserved, evalPage, s);

		PagerModel pager = new PagerModel(list.getTotalsPage(), list.getPage(), 7);

		List<Kind> listKind = ws.getListKind();

		model.addAttribute("listKind", listKind);
		model.addAttribute("genre", genre);
		// ajout des operations au model
		model.addAttribute("listOuvrages", list);
		// ajout des pages au model
		model.addAttribute("pager", pager);
		// nous ajoutons le mot cle actuel au model
		model.addAttribute("MotCle", mc);
		// nous ajoutons le mot cle actuel au model
		model.addAttribute("isReserved", isReserved);

		return "Recherche/ouvrages";
	}

//////////////////////// INSCRIPTION ////////////////////////

	@RequestMapping(value = "/inscription")
	public String inscription() {
		return "Authentification/inscription";
	}

	@RequestMapping(value = "/saveInscription", method = RequestMethod.POST)
	public String saveInscription(HttpSession httpSession, Model model, Mail mail, User user)
			throws BibliothequeException_Exception {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			user.setPassWord(encrypt.setEncrypt(user.getPassWord()));
			user.setPassWordConfirm(encrypt.setEncrypt(user.getPassWordConfirm()));

			user = ws.createUser(user, mail);
			httpSession.setAttribute("user_id", user.getId());

		} catch (BibliothequeException_Exception e) {

			model.addAttribute("user", user);
			model.addAttribute("mail", mail);
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "Authentification/inscription";
		}
		
		
		List<GrantedAuthority> grantedAuths = new ArrayList<>();		
		for (Roles roles : user.getRoles()) {		
			grantedAuths.add(new SimpleGrantedAuthority(roles.getRole()));
		}
				
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
				user.getPseudo(), user.getPassWord(), grantedAuths));

		return "redirect:/index";

	}

	//////////////////////// RECUPERATION MDP ////////////////////////
	
	@RequestMapping(value = "/recuperation")
	public String recuperation() {
		return "Authentification/recuperation";
	}
	
	@RequestMapping(value = "/sendToken")
	public String sendToken(HttpSession httpSession, Model model, String email) {
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		try {
			
			ws.sendToken(email);
			httpSession.setAttribute("email", email);
			
		} catch (BibliothequeException_Exception e) {
			
			model.addAttribute("email", email);
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "Authentification/recuperation";
		}
		
		return "Authentification/insertToken";
	}
	
	@RequestMapping(value = "/validateToken")
	public String validateToken(HttpSession httpSession, Model model, String token) {
		
		if( httpSession.getAttribute("email") != null) {
						
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		try {
			
			ws.validateToken((String) httpSession.getAttribute("email"), token);
			httpSession.setAttribute("token", token);
			
		} catch (BibliothequeException_Exception e) {
					
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "Authentification/insertToken";
		}
		
		return "Authentification/editPassword";
		}
		return "Authentification/recuperation";
	}
	
	@RequestMapping(value = "/editPassword")
	public String editPassword(HttpSession httpSession, Model model, String password, String passwordConfirm) {
		
		if( httpSession.getAttribute("token") != null) {
						
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		try {
			
			password = encrypt.setEncrypt(password);
			passwordConfirm = encrypt.setEncrypt(passwordConfirm);
			
			ws.editPassWordByRecovery((String) httpSession.getAttribute("email"), password, passwordConfirm);
			httpSession.removeAttribute("email");
			httpSession.removeAttribute("token");
			
		} catch (BibliothequeException_Exception e) {
					
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "Authentification/editPassword";
		}
		
		return "redirect:/login?editPassWord";
		
		}
		return "Authentification/recuperation";
	}
	
	
	//////////////////////// AJOUT OUVRAGE ////////////////////////


	@RequestMapping(value = "/ajout")
	public String ajout(Model model) {
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		List<Kind> listKind = ws.getListKind();

		model.addAttribute("listKind", listKind);
		return "EditOuvrage/ajout";
	}

	@RequestMapping(value = "/saveAjout")
	public String saveAjout(Model model, Book book, @RequestParam(name = "style") String genre) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {		
			Kind kind = new Kind();
			kind.setName(genre);
			book.setKind(kind);
			ws.createBook(book);
		} catch (BibliothequeException_Exception e) {

			List<Kind> listKind = ws.getListKind();

			model.addAttribute("listKind", listKind);
			model.addAttribute("book", book);
			model.addAttribute("style", genre);
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "EditOuvrage/ajout";
		}

		return "redirect:/confirmationAjout?title=" + book.getTitle() + "&author=" + book.getAuthor()
				+ "&description=" + book.getDescription() + "&genre=" + genre + "&copyTotals="
				+ book.getCopyTotals();
	}

	@RequestMapping(value = "/confirmationAjout")
	public String confirmationAjout(Model model, String title, String author, String description, String genre,
			int copyTotals) {

		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("description", description);
		model.addAttribute("genre", genre);
		model.addAttribute("copyTotals", copyTotals);

		return "EditOuvrage/confirmationAjout";
	}
	
//////////////////////// MODIFICATION OUVRAGE ////////////////////////

	@RequestMapping(value = "/modificationOuvrage")
	public String modificationOuvrage(Model model, Long id) throws BibliothequeException_Exception {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		Book book = ws.getBook(id);
		List<Kind> listKind = ws.getListKind();

		model.addAttribute("book", book);
		model.addAttribute("style", book.getKind().getName());
		model.addAttribute("listKind", listKind);

		return "EditOuvrage/modificationOuvrage";
	}

	@RequestMapping(value = "/saveModificationOuvrage")
	public String saveModificationOuvrage(Model model, Book book, @RequestParam(name = "style") String genre) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			Kind kind = new Kind();
			kind.setName(genre);
			book.setKind(kind);
			ws.updateBook(book);
		} catch (BibliothequeException_Exception e) {

			List<Kind> listKind = ws.getListKind();

			model.addAttribute("listKind", listKind);
			model.addAttribute("book", book);
			model.addAttribute("style", genre);
			model.addAttribute("exception", messages.get(e.getMessage()));
			return "EditOuvrage/modificationOuvrage";
		}

		return "redirect:/modificationOuvrage?id=" + book.getId() + "&returnEdit";
	}

//////////////////////// SUPPRESSION OUVRAGE ////////////////////////

	@RequestMapping(value = "/deleteOuvrage")
	public String deleteOuvrage(Long id, int page, String MotCle, String genre, boolean isReserved) throws BibliothequeException_Exception {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		ws.deleteBook(id);

		return "redirect:/recherche?page=" + page + "&MotCle=" + MotCle + "&genre=" + genre + "&isReserved="
				+ isReserved + "&returnDelete";
	}

//////////////////////// MODIFICATION COMPTE UTILISATEUR ////////////////////////

	@RequestMapping(value = "/modificationCompte")
	public String modificationCompte(HttpSession httpSession, Model model) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		Mail mail = ws.getMail((Long) httpSession.getAttribute("user_id"));
		User user = mail.getUser();

		model.addAttribute("user", user);
		model.addAttribute("mail", mail);

		return "Authentification/editAccount";
	}

	@RequestMapping(value = "/saveModificationCompte")
	public String saveModificationCompte(HttpSession httpSession, Model model, User user, Mail mail) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			user.setPassWord(encrypt.setEncrypt(user.getPassWord()));
			user.setPassWordConfirm(encrypt.setEncrypt(user.getPassWordConfirm()));
			user.setOldPassWord(encrypt.setEncrypt(user.getOldPassWord()));

			ws.saveUser(user);
			ws.saveMail(mail, user.getId());

		} catch (BibliothequeException_Exception e) {

			model.addAttribute("exception", messages.get(e.getMessage()));

			return "Authentification/editAccount";
		}

		return "redirect:/modificationCompte?returnEdit";
	}

//////////////////////// SUPPRESSION COMPTE UTILISATEUR ////////////////////////

	@RequestMapping(value = "/suppressionCompte")
	public String SuppressionCompte() {
		return "Authentification/deleteAccount";
	}

	@RequestMapping(value = "/suppressionCompteConfirm")
	public String SuppressionCompteConfirm(HttpSession httpSession) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		ws.deleteUser((Long) httpSession.getAttribute("user_id"));

		return "redirect:/login?logout";
	}

//////////////////////// RESERVATION UTILISATEUR ////////////////////////

	@RequestMapping(value = "/reservationCompte")
	public String reservationCompte(HttpSession httpSession, Model model) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		List<Loan> listLoan = ws
				.getListLoanByUserID((Long) httpSession.getAttribute("user_id"));
		List<Loan> listLoanLate = ws
				.getListLoanLateByUserID((Long) httpSession.getAttribute("user_id"));

		model.addAttribute("listLoan", listLoan);
		model.addAttribute("listLoanLate", listLoanLate);

		return "Reservation/reservation";
	}

	@RequestMapping(value = "/prolongerReservation")
	public String prolongerReservation(Model model, Long id) throws DatatypeConfigurationException {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			Loan r = ws.getLoan(id);
			int prolongationDays = ws.getDaysExtend();
			GregorianCalendar calendar = r.getEndLoan().toGregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, prolongationDays);
			r.setEndLoan(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));

			model.addAttribute("fin", r.getEndLoan());
			model.addAttribute("prolongation", prolongationDays);
			model.addAttribute("id", id);

		} catch (BibliothequeException_Exception e) {
			return "error";
		}

		return "Reservation/prolongation";
	}

	@RequestMapping(value = "/saveProlongerReservation")
	public String saveProlongerReservation(HttpSession httpSession, Long id) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			ws.extendLoan(id, (Long) httpSession.getAttribute("user_id"));
		} catch (BibliothequeException_Exception e) {
			return "error";
		}

		return "redirect:/reservationCompte?returnProlongation";
	}


}

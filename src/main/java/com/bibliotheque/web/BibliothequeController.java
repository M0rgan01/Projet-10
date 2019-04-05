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
import com.bibliotheque.service.Genre;
import com.bibliotheque.service.Mail;
import com.bibliotheque.service.Ouvrage;
import com.bibliotheque.service.PageOuvrage;
import com.bibliotheque.service.Reservation;
import com.bibliotheque.service.Utilisateur;
import com.bibliotheque.utilities.Encrypt;

@Controller
public class BibliothequeController {

	@Autowired
	private Encrypt encrypt;

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

		PageOuvrage list = ws.listOuvrage(mc, genre, isReserved, evalPage, s);

		PagerModel pager = new PagerModel(list.getTotalPage(), list.getPage(), 7);

		List<Genre> listGenre = ws.getListGenre();

		model.addAttribute("listGenre", listGenre);
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
	public String saveInscription(HttpSession httpSession, Model model, Mail mail, Utilisateur utilisateur)
			throws BibliothequeException_Exception {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			utilisateur.setPassWord(encrypt.setEncrypt(utilisateur.getPassWord()));
			utilisateur.setPassWordConfirm(encrypt.setEncrypt(utilisateur.getPassWordConfirm()));

			utilisateur = ws.createUtilisateur(utilisateur, mail);
			httpSession.setAttribute("utilisateur_id", utilisateur.getId());

		} catch (BibliothequeException_Exception e) {

			model.addAttribute("utilisateur", utilisateur);
			model.addAttribute("mail", mail);
			model.addAttribute("exception", e);
			return "Authentification/inscription";
		}

		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
				utilisateur.getPseudo(), utilisateur.getPassWord(), grantedAuths));

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
			model.addAttribute("exception", e);
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
					
			model.addAttribute("exception", e);
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
			
			ws.editPassWordByRecuperation((String) httpSession.getAttribute("email"), password, passwordConfirm);
			httpSession.removeAttribute("email");
			httpSession.removeAttribute("token");
			
		} catch (BibliothequeException_Exception e) {
					
			model.addAttribute("exception", e);
			return "Authentification/editPassword";
		}
		
		return "redirect:/login?editPassWord";
		
		}
		return "Authentification/recuperation";
	}
	
	
	//////////////////////// AJOUT OUVRAGE ////////////////////////

	@RequestMapping(value = "/confirmationAjout")
	public String confirmationAjout(Model model, String titre, String auteur, String description, String genre,
			int nombreExemplaire) {

		model.addAttribute("titre", titre);
		model.addAttribute("auteur", auteur);
		model.addAttribute("description", description);
		model.addAttribute("genre", genre);
		model.addAttribute("nombreExemplaire", nombreExemplaire);

		return "EditOuvrage/confirmationAjout";
	}

	@RequestMapping(value = "/ajout")
	public String ajout(Model model) {
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		List<Genre> listGenre = ws.getListGenre();

		model.addAttribute("listGenre", listGenre);
		return "EditOuvrage/ajout";
	}

	@RequestMapping(value = "/saveAjout")
	public String saveAjout(Model model, Ouvrage ouvrage, @RequestParam(name = "style") String genre) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			ws.createOuvrage(ouvrage, genre);
		} catch (BibliothequeException_Exception e) {

			List<Genre> listGenre = ws.getListGenre();

			model.addAttribute("listGenre", listGenre);
			model.addAttribute("ouvrage", ouvrage);
			model.addAttribute("style", genre);
			model.addAttribute("exception", e);
			return "EditOuvrage/ajout";
		}

		return "redirect:/confirmationAjout?titre=" + ouvrage.getTitre() + "&auteur=" + ouvrage.getAuteur()
				+ "&description=" + ouvrage.getDescription() + "&genre=" + genre + "&nombreExemplaire="
				+ ouvrage.getExemplaireTotaux();
	}

//////////////////////// MODIFICATION OUVRAGE ////////////////////////

	@RequestMapping(value = "/modificationOuvrage")
	public String modificationOuvrage(Model model, Long id) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		Ouvrage ouvrage = ws.getOuvrage(id);
		List<Genre> listGenre = ws.getListGenre();

		model.addAttribute("ouvrage", ouvrage);
		model.addAttribute("style", ouvrage.getGenre().getNom());
		model.addAttribute("listGenre", listGenre);

		return "EditOuvrage/modificationOuvrage";
	}

	@RequestMapping(value = "/saveModificationOuvrage")
	public String saveModificationOuvrage(Model model, Ouvrage ouvrage, @RequestParam(name = "style") String genre) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			ws.updateOuvrage(ouvrage, genre);
		} catch (BibliothequeException_Exception e) {

			List<Genre> listGenre = ws.getListGenre();

			model.addAttribute("listGenre", listGenre);
			model.addAttribute("ouvrage", ouvrage);
			model.addAttribute("style", genre);
			model.addAttribute("exception", e);
			return "EditOuvrage/modificationOuvrage";
		}

		return "redirect:/modificationOuvrage?id=" + ouvrage.getId() + "&returnEdit";
	}

//////////////////////// SUPPRESSION OUVRAGE ////////////////////////

	@RequestMapping(value = "/deleteOuvrage")
	public String deleteOuvrage(Long id, int page, String MotCle, String genre, boolean isReserved) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		ws.deleteOuvrage(id);

		return "redirect:/recherche?page=" + page + "&MotCle=" + MotCle + "&genre=" + genre + "&isReserved="
				+ isReserved + "&returnDelete";
	}

//////////////////////// MODIFICATION COMPTE UTILISATEUR ////////////////////////

	@RequestMapping(value = "/modificationCompte")
	public String modificationCompte(HttpSession httpSession, Model model) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		Mail mail = ws.getMail((Long) httpSession.getAttribute("utilisateur_id"));
		Utilisateur utilisateur = mail.getUtilisateur();

		model.addAttribute("utilisateur", utilisateur);
		model.addAttribute("mail", mail);

		return "Authentification/modificationCompte";
	}

	@RequestMapping(value = "/saveModificationCompte")
	public String saveModificationCompte(HttpSession httpSession, Model model, Utilisateur utilisateur, Mail mail) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			utilisateur.setPassWord(encrypt.setEncrypt(utilisateur.getPassWord()));
			utilisateur.setPassWordConfirm(encrypt.setEncrypt(utilisateur.getPassWordConfirm()));
			utilisateur.setOldPassWord(encrypt.setEncrypt(utilisateur.getOldPassWord()));

			ws.saveUtilisateur(utilisateur);
			ws.saveMail(mail, utilisateur.getId());

		} catch (BibliothequeException_Exception e) {

			model.addAttribute("exception", e);

			return "Authentification/modificationCompte";
		}

		return "redirect:/modificationCompte?returnEdit";
	}

//////////////////////// SUPPRESSION COMPTE UTILISATEUR ////////////////////////

	@RequestMapping(value = "/suppressionCompte")
	public String SuppressionCompte() {
		return "Authentification/suppressionCompte";
	}

	@RequestMapping(value = "/suppressionCompteConfirm")
	public String SuppressionCompteConfirm(HttpSession httpSession) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		ws.deleteUtilisateur((Long) httpSession.getAttribute("utilisateur_id"));

		return "redirect:/login?logout";
	}

//////////////////////// RESERVATION UTILISATEUR ////////////////////////

	@RequestMapping(value = "/reservationCompte")
	public String reservationCompte(HttpSession httpSession, Model model) {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		List<Reservation> listResa = ws
				.getListReservationByUtilisateurID((Long) httpSession.getAttribute("utilisateur_id"));
		List<Reservation> listResaRetard = ws
				.getListReservationRetardedByUtilisateurID((Long) httpSession.getAttribute("utilisateur_id"));

		model.addAttribute("listResa", listResa);
		model.addAttribute("listResaRetard", listResaRetard);

		return "Reservation/reservation";
	}

	@RequestMapping(value = "/prolongerReservation")
	public String prolongerReservation(Model model, Long id) throws DatatypeConfigurationException {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {
			Reservation r = ws.getReservation(id);
			int prolongationDays = ws.getDaysProlongation();
			GregorianCalendar calendar = r.getFin().toGregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, prolongationDays);
			r.setFin(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));

			model.addAttribute("fin", r.getFin());
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
			ws.prolongerReservation(id, (Long) httpSession.getAttribute("utilisateur_id"));
		} catch (BibliothequeException_Exception e) {
			return "error";
		}

		return "redirect:/reservationCompte?returnProlongation";
	}

//////////////////////// RESERVATION OUVRAGE ////////////////////////

//	@RequestMapping(value = "/reserverOuvrage")
//	public String reserverOuvrage(Model model, Long id) {
//		model.addAttribute("id", id);
//		return "reservation";
//	}
//
//	@RequestMapping(value = "/saveReserverOuvrage")
//	public String saveReserverOuvrage(String dateFin, Long id) {
//
//		Reservation reservation = new Reservation();
//		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
//
//		try {
//
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			GregorianCalendar cal = new GregorianCalendar();
//			Date debut = new Date();
//			Date fin = formatter.parse(dateFin);
//
//			cal.setTime(debut);
//			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//			reservation.setDebut(xmlGregCal);
//
//			cal.setTime(fin);
//			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//			reservation.setFin(xmlGregCal);
//
//			ws.createReservation(reservation, id, 1l);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return "reservation";
//	}

}

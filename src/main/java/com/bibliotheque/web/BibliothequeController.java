package com.bibliotheque.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.bibliotheque.service.Utilisateur;

@Controller
public class BibliothequeController {

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
		return "login";
	}

//////////////////////// RECHERCHE ////////////////////////

	@RequestMapping(value = "/recherche")
	public String recherche(Model model, @RequestParam(name = "page", defaultValue = "0") Optional<Integer> page,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "MotCle", defaultValue = "") String mc, @RequestParam(name = "genre", defaultValue = "") String genre, boolean isReserved) {
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		// si page est null ou inferieur a 0, on lui assigne 0, sinon on le decremente
		int evalPage = (page.orElse(0) < 1) ? 0 : page.get() - 1;

		PageOuvrage list = ws.listOuvrage(mc, genre, isReserved, evalPage, s);

		PagerModel pager = new PagerModel(list.getTotalPage(), list.getPage(), 7);

		List<Genre> listGenre = ws.getListGenre();
				
		model.addAttribute("listGenre",listGenre);
		model.addAttribute("genre",genre);
		// ajout des operations au model
		model.addAttribute("listOuvrages", list);
		// ajout des pages au model
		model.addAttribute("pager", pager);
		// nous ajoutons le mot cle actuel au model
		model.addAttribute("MotCle", mc);
		// nous ajoutons le mot cle actuel au model
		model.addAttribute("isReserved", isReserved);
		
		return "ouvrages";
	}

//////////////////////// INSCRIPTION ////////////////////////
		
	@RequestMapping(value = "/inscription")
	public String inscription() {
		return "inscription";
	}

	@RequestMapping(value = "/saveInscription", method = RequestMethod.POST)
	public String saveInscription(Model model, Mail mail, Utilisateur utilisateur)
			throws BibliothequeException_Exception {

		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		try {			
			ws.createUtilisateur(utilisateur, mail);		
		} catch (BibliothequeException_Exception e) {				
			model.addAttribute("utilisateur", utilisateur);	
			model.addAttribute("mail", mail);	
			model.addAttribute("exception", e);					
			return "inscription";
		}

		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
				utilisateur.getPseudo(), utilisateur.getPassWord(), grantedAuths));

		return "redirect:/index";

	}

	//////////////////////// AJOUT OUVRAGE ////////////////////////
	
	
	@RequestMapping(value = "/ajout")
	public String ajout(Model model) {
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		List<Genre> listGenre = ws.getListGenre();
		
		model.addAttribute("listGenre",listGenre);
		return "ajout";
	}
	
	@RequestMapping(value = "/saveAjout")
	public String saveAjout(Model model, Ouvrage ouvrage,@RequestParam(name = "style")String genre) {
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();		
	
		try {			
			ws.createOuvrage(ouvrage, genre);		
		} catch (BibliothequeException_Exception e) {	
			
			List<Genre> listGenre = ws.getListGenre();
			
			model.addAttribute("listGenre",listGenre);
			model.addAttribute("ouvrage", ouvrage);	
			model.addAttribute("style", genre);	
			model.addAttribute("exception", e);					
			return "ajout";
		}
				
		return "redirect:/index";
	}
	
//////////////////////// MODIFICATION OUVRAGE ////////////////////////
	
	@RequestMapping(value = "/modificationOuvrage")
	public String modificationOuvrage(Model model, Long id) {
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
		
		Ouvrage ouvrage = ws.getOuvrage(id);
		List<Genre> listGenre = ws.getListGenre();
		
		model.addAttribute("ouvrage", ouvrage);	
		model.addAttribute("style", ouvrage.getGenre().getNom());	
		model.addAttribute("listGenre",listGenre);
		
		return "modificationOuvrage";
	}
	
	@RequestMapping(value = "/saveModificationOuvrage")
	public String saveModificationOuvrage(Model model, Ouvrage ouvrage, @RequestParam(name = "style")String genre) {
		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();
				
		try {			
			ws.updateOuvrage(ouvrage, genre);		
		} catch (BibliothequeException_Exception e) {	
			
			List<Genre> listGenre = ws.getListGenre();
			
			model.addAttribute("listGenre",listGenre);
			model.addAttribute("ouvrage", ouvrage);	
			model.addAttribute("style", genre);	
			model.addAttribute("exception", e);					
			return "ajout";
		}
				
		return "redirect:/index";
	}
}

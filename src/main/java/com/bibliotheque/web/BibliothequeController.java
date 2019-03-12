package com.bibliotheque.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bibliotheque.pager.PagerModel;
import com.bibliotheque.service.BibliothequeServiceService;
import com.bibliotheque.service.BibliothequeWS;
import com.bibliotheque.service.Ouvrage;
import com.bibliotheque.service.PageOuvrage;

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

	@RequestMapping(value = "/recherche")
	public String recherche(Model model, @RequestParam(name = "page", defaultValue = "0")Optional<Integer> page,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "MotCle", defaultValue = "") String mc) {

		
		BibliothequeWS ws = new BibliothequeServiceService().getBibliothequeWSPort();

		// si page est null ou inferieur a 0, on lui assigne 0, sinon on le decremente
		int evalPage = (page.orElse(0) < 1) ? 0 : page.get() - 1;
		
		PageOuvrage list = ws.listOuvrage(mc, evalPage, s);

		PagerModel pager = new PagerModel(list.getTotalPage(), list.getPage(), 7);

		// ajout des operations au model
		model.addAttribute("listOuvrages", list);
		// ajout des pages au model
		model.addAttribute("pager", pager);
		// nous ajoutons le mot cle actuel au model
		model.addAttribute("MotCle", mc);
		
		for (Ouvrage o : list.getOuvrages()) {
			System.out.println(o.getGenre().getNom());
		}
			
		return "ouvrages";
	}
}

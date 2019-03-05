package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.UtilisateurRepository;
import com.bibliotheque.entities.Utilisateur;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier{

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public void saveUtilisateur(Utilisateur utilisateur) {		
		utilisateurRepository.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Long id) {	
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {		
		return utilisateurRepository.findById(id).orElse(null);
	}

}

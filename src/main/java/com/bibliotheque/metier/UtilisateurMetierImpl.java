package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.UtilisateurRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Transactional
@Service
public class UtilisateurMetierImpl implements UtilisateurMetier{

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MailMetier mailMetier;
	
	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {				
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Long id) {	
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {		
		return utilisateurRepository.findById(id).orElse(null);
	}

	@Override
	public Utilisateur getUtilisateur(String pseudo) {		
		return utilisateurRepository.findByPseudo(pseudo);
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur, Mail mail) throws BibliothequeException {
		
		Utilisateur utilisateur2 = getUtilisateur(utilisateur.getPseudo());
		
		if (utilisateur2 != null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("1");
			bibliothequeFault.setFaultString("Le pseudo demander est déjà utilisater");
			
			throw new BibliothequeException("Pseudo utiliser", bibliothequeFault);
		}
						
		mailMetier.createMail(mail, utilisateur);
		
		return utilisateurRepository.save(utilisateur);
	}

}

package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class ReservationMetierImpl implements ReservationMetier {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private OuvrageMetier ouvrageMetier;
	@Autowired
	private UtilisateurMetier utilisateurMetier;

	@Override
	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation getRerservation(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public void createReservation(Long ouvrage_id, Long Utilisateur_id, Reservation reservation)
			throws BibliothequeException {
		Utilisateur utilisateur = utilisateurMetier.getUtilisateur(Utilisateur_id);
		Ouvrage ouvrage = ouvrageMetier.getOuvrage(ouvrage_id);

		if (utilisateur == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("12");
			bibliothequeFault.setFaultString("ID utilisateur incorrect");

			throw new BibliothequeException("ID return null", bibliothequeFault);
			
		} else if (ouvrage == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("13");
			bibliothequeFault.setFaultString("ID ouvrage incorrect");

			throw new BibliothequeException("ID return null", bibliothequeFault);
		}

		if (ouvrage.getExemplaireDisponible() == 0) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("14");
			bibliothequeFault.setFaultString("Ouvrage non disponible au prêt pour cette période");

			throw new BibliothequeException("Non disponible", bibliothequeFault);
		}

		ouvrage.setExemplaireDisponible(ouvrage.getExemplaireDisponible() - 1);
		
		if (ouvrage.getExemplaireDisponible() == 0)
			ouvrage.setDisponible(false);

		ouvrageMetier.saveOuvrage(ouvrage);

		reservation.setUtilisateur(utilisateur);
		reservation.setOuvrage(ouvrage);

		reservationRepository.save(reservation);
	}

}

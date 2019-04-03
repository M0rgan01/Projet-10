package com.bibliotheque.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.ReservationRepository;
import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.entities.Reservation;
import com.bibliotheque.entities.Utilisateur;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
@PropertySource("classpath:bibliotheque.properties")
public class ReservationMetierImpl implements ReservationMetier {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private OuvrageMetier ouvrageMetier;
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Value("${prolongation.days}")
	private int prolongationDays;

	@Override
	public void prolongerReservation(Long reservationID, Long utilisateurID) throws BibliothequeException {
		Reservation r = reservationRepository.findById(reservationID).orElse(null);

		if (r == null) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("30");
			bibliothequeFault.setFaultString("ID reservation incorrect");

			throw new BibliothequeException("ID return null", bibliothequeFault);

		} else if (r.getUtilisateur().getId() != utilisateurID) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("31");
			bibliothequeFault.setFaultString("ID utilisateur incorrect");

			throw new BibliothequeException("ID utilisateur incorrect", bibliothequeFault);

		} else if (r.isProlongation()) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("32");
			bibliothequeFault.setFaultString("Réservation déjà prolonger");

			throw new BibliothequeException("Prolongation true", bibliothequeFault);

		} else if (checkRetard(r)) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("33");
			bibliothequeFault.setFaultString("Retard après prolongation");

			throw new BibliothequeException("Retard après prolongation", bibliothequeFault);
		}

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, prolongationDays);
		r.setFin(c.getTime());
		r.setProlongation(true);

		reservationRepository.save(r);
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

	@Override
	public List<Reservation> getListReservationByUtilisateurID(Long utilisateur_id) {
		return reservationRepository.getListReservationByUtilisateurID(utilisateur_id, new Date());
	}

	@Override
	public List<Reservation> getListReservationRetardedByUtilisateurID(Long utilisateur_id) {

		List<Reservation> listResa = reservationRepository.getListReservationRetardedByUtilisateurID(utilisateur_id,
				new Date());

		for (Reservation reservation : listResa) {
			if (!reservation.isProlongation()) {

				if (checkRetard(reservation))
					reservation.setRetard(true);
			}
		}
		return listResa;
	}

	public boolean checkRetard(Reservation reservation) {
		Calendar c = Calendar.getInstance();
		c.setTime(reservation.getFin());
		c.add(Calendar.DATE, prolongationDays);
		Date retard = c.getTime();

		if (retard.before(new Date())) {
			return true;
		}
		return false;
	}

	@Override
	public int getDaysProlongation() {
		return prolongationDays;
	}

}

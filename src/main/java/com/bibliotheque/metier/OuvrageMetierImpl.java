package com.bibliotheque.metier;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.OuvrageRepository;
import com.bibliotheque.entities.Genre;
import com.bibliotheque.entities.Ouvrage;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class OuvrageMetierImpl implements OuvrageMetier {

	@Autowired
	private OuvrageRepository ouvrageRepository;
	@Autowired
	private GenreMetier genreMetier;

	@Override
	public void deleteOuvrage(Long id) {
		ouvrageRepository.deleteById(id);
	}

	@Override
	public Ouvrage getOuvrage(Long id) {
		return ouvrageRepository.findById(id).orElse(null);
	}

	@Override
	public PageOuvrage listOuvrage(String mc, String genre, boolean disponnible, int page, int size) {

		Page<Ouvrage> ouvrages = null;

		if (disponnible) {
			ouvrages = ouvrageRepository.getListOuvrages("%" + mc + "%", "%" + genre + "%", disponnible,
					PageRequest.of(page, size));
		} else {
			ouvrages = ouvrageRepository.getListOuvrages("%" + mc + "%", "%" + genre + "%", PageRequest.of(page, size));
		}

		PageOuvrage pageOuvrage = new PageOuvrage();
		pageOuvrage.setOuvrages(ouvrages.getContent());
		pageOuvrage.setNombreOuvrages(ouvrages.getNumberOfElements());
		pageOuvrage.setPage(ouvrages.getNumber());
		pageOuvrage.setTotalPage(ouvrages.getTotalPages());
		pageOuvrage.setTotalOuvrages((int) ouvrages.getTotalElements());

		return pageOuvrage;
	}

	@Override
	public void createOuvrage(Ouvrage ouvrage, String genre) throws BibliothequeException {

		Genre genre2 = new Genre(genre);
		genreMetier.validateGenre(genre2);

		ouvrage.setGenre(genre2);
		ouvrage.setDisponible(true);
		ouvrage.setExemplaireDisponible(ouvrage.getExemplaireTotaux());

		validateOuvrage(ouvrage);

		ouvrageRepository.save(ouvrage);
	}

	@Override
	public void saveOuvrage(Ouvrage ouvrage, String genre) throws BibliothequeException {

		Ouvrage ouvrage2 = ouvrageRepository.findById(ouvrage.getId()).orElse(null);

		if (ouvrage2 == null) {
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultCode("11");
			bibliothequeFault.setFaultString("Aucun ouvrage correspondant");
			throw new BibliothequeException("Aucun ouvrage correspondant", bibliothequeFault);

		} else if (ouvrage.getExemplaireTotaux() != ouvrage2.getExemplaireTotaux()) {

			int a = ouvrage.getExemplaireTotaux() - ouvrage2.getExemplaireTotaux();

			ouvrage.setExemplaireDisponible(ouvrage.getExemplaireDisponible() + a);
			
			if (ouvrage.getExemplaireDisponible() < 0)
				ouvrage.setExemplaireDisponible(0);

			if (ouvrage.getExemplaireDisponible() == 0)
				ouvrage.setDisponible(false);
			
		}

		Genre genre2 = new Genre(genre);
		genreMetier.validateGenre(genre2);
		ouvrage.setGenre(genre2);
		validateOuvrage(ouvrage);

		ouvrageRepository.save(ouvrage);

	}

	@Override
	public void saveOuvrage(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}

	public void validateOuvrage(Ouvrage ouvrage) throws BibliothequeException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Ouvrage>> violations2 = validator.validate(ouvrage);

		for (ConstraintViolation<Ouvrage> violation : violations2) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}

}

package com.bibliotheque.metier;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.GenreRepository;
import com.bibliotheque.entities.Genre;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class GenreMetierImpl implements GenreMetier{

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public void saveGenre(Genre genre) {
		genreRepository.save(genre);
	}

	@Override
	public List<Genre> getListGenre() {		
		return genreRepository.findAll();
	}

	@Override
	public Genre getGenre(String nom) {		
		return genreRepository.findById(nom).orElse(null);
	}

	
	public void validateGenre(Genre genre) throws BibliothequeException {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Genre>> violations = validator.validate(genre);

		for (ConstraintViolation<Genre> violation : violations) {

			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}
	
}

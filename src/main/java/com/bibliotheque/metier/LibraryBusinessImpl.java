package com.bibliotheque.metier;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.LibraryRepository;
import com.bibliotheque.entities.Library;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class LibraryBusinessImpl implements LibraryBusiness{

	@Autowired
	private LibraryRepository libraryRepository;

	private static final Logger logger = LoggerFactory.getLogger(LibraryBusinessImpl.class);
	
	@Override
	public void saveLibrary(Library library) {
	libraryRepository.save(library);
	logger.info("save library" + library.getName());
	}

	@Override
	public List<Library> getListLibrary() {
		logger.info("Return list of library");
		return libraryRepository.findAll();
	}

	@Override
	public Library getLibrary(Long id) {
		logger.info("get library " + id);
		return libraryRepository.findById(id).orElse(null);
	}

	@Override
	public void validateLibrary(Library library) throws BibliothequeException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Library>> violations = validator.validate(library);

		for (ConstraintViolation<Library> violation : violations) {

			logger.error("Library " + violation.getPropertyPath() + " incorrect : " + violation.getMessage());
			
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}
	
	
	
}

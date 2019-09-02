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

import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.exception.BibliothequeFault;

@Service
public class KindBusinessImpl implements KindBusiness{

	@Autowired
	private KindRepository kindRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(KindBusinessImpl.class);
	
	@Override
	public void saveKind(Kind kind) throws BibliothequeException {
		validateKind(kind);
		kindRepository.save(kind);
		logger.info("save kind" + kind.getName());
	}

	@Override
	public List<Kind> getListKind() {	
		logger.info("Return list of kind");
		return kindRepository.findAll();
	}

	@Override
	public Kind getKind(String name) {		
		logger.info("get kind " + name);
		return kindRepository.findById(name).orElse(null);
	}

	
	public void validateKind(Kind kind) throws BibliothequeException {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Kind>> violations = validator.validate(kind);

		for (ConstraintViolation<Kind> violation : violations) {

			logger.error("Kind " + violation.getPropertyPath() + " incorrect : " + violation.getMessage());
			
			BibliothequeFault bibliothequeFault = new BibliothequeFault();
			bibliothequeFault.setFaultString(violation.getMessage());

			throw new BibliothequeException(violation.getMessage(), bibliothequeFault);
		}
	}
	
}

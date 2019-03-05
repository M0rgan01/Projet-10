package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.OuvrageRepository;
import com.bibliotheque.entities.Ouvrage;

@Service
public class OuvrageMetierImpl implements OuvrageMetier{

	@Autowired
	private OuvrageRepository ouvrageRepository;
		
	@Override
	public void saveOuvrage(Ouvrage ouvrage) {
		ouvrageRepository.save(ouvrage);
	}

	@Override
	public void deleteOuvrage(Long id) {
		ouvrageRepository.deleteById(id);
	}

	@Override
	public Ouvrage getOuvrage(Long id) {		
		return ouvrageRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Ouvrage> listOuvrage(int page, int size) {		
		return ouvrageRepository.listOuvrage(PageRequest.of(page, size));
	}

}

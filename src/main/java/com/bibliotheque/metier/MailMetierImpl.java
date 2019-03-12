package com.bibliotheque.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Mail;

@Service
public class MailMetierImpl implements MailMetier{

	@Autowired
	private MailRepository mailRepository;
	
	@Override
	public void saveMail(Mail mail) {		
		mailRepository.save(mail);		
	}

	@Override
	public void deleteMail(Long id) {
		mailRepository.deleteById(id);
	}

	@Override
	public Mail getMail(Long id) {		
		return mailRepository.findById(id).orElse(null);
	}

}

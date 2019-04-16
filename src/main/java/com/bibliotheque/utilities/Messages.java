package com.bibliotheque.utilities;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * 
 * Aide pour simplifier l'accès aux ressources i18n
 * 
 * Trouve automatiquement les messages depuis src/main/resources (messages.properties)
 *
 * @author Pichat morgan
 */
@Component
public class Messages {

	@Autowired
	private MessageSource messageSource;

	private MessageSourceAccessor accessor;

	@PostConstruct
	private void init() {
		accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
	}

	public String get(String code) {
		return accessor.getMessage(code);
	}
}

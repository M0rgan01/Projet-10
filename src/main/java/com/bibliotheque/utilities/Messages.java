package com.bibliotheque.utilities;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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

	private MessageSourceAccessor accessor;

	public MessageSource getMessageSource() {
		String pathToMessages = "file:" + System.getProperty("catalina.home") + File.separator +"conf"+ File.separator +"Projet7-WebApplication" + File.separator + "messages";
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("messages", pathToMessages);
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(60);
	    return messageSource;
	}

	@PostConstruct
	private void init() {		
		accessor = new MessageSourceAccessor(getMessageSource(), LocaleContextHolder.getLocale());
	}

	public String get(String code) {
		return accessor.getMessage(code);
	}
}

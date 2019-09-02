package com.bibliotheque;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * classe de configuration du web-service
 * 
 * @author PICHAT morgan
 *
 */
@Configuration
@PropertySource("classpath:bibliotheque.properties")
public class MyConfig {

	@Value("${WS.adress}")
	private String WS_adress;	
	
	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress(WS_adress);
		return exporter;
	}
	
	@Bean
	public BCryptPasswordEncoder getBcrypt() {
		return new BCryptPasswordEncoder();
	}
		    
}

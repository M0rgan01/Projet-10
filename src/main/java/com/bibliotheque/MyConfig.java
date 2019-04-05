package com.bibliotheque;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
//@EnableBatchProcessing
@PropertySource("classpath:bibliotheque.properties")
public class MyConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/biblio");
		return exporter;
	}
	
//	  @Bean
//	  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//	    return new PropertySourcesPlaceholderConfigurer();
//	  }
}

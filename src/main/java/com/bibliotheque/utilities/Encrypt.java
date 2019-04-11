package com.bibliotheque.utilities;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Service;


/**
 * Objet servant a l'encryptage, le decryptage 
 * 
 * @author PICHAT morgan
 *
 */
@Service
public class Encrypt{


	
	/**
	 * Encrypte une chaine de caractere
	 * @param string
	 * chaine de caractere a encrypte
	 * @return 
	 * chaine de caractere encrypte
	 */
	public String setEncrypt(String string) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("jasypt");
		string = encryptor.encrypt(string);
		return string;	
	}
	
	
	/**
	 * Decrypte une chaine de caractère
	 * @param string
	 * chaine de caractere encrypte
	 * @return 
	 * chaine de caractere décrypte
	 */
	public String getDecrypt(String string) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("jasypt");
		string = encryptor.decrypt(string);
		return string;	
	}
	
}

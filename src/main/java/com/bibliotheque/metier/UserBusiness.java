package com.bibliotheque.metier;

import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;

public interface UserBusiness {
	
	public void validateUser(User user) throws BibliothequeException;
	public void validatePassWord(User user) throws BibliothequeException;
	public User saveUser(User user) throws BibliothequeException;
	public User createUser(User user, Mail mail) throws BibliothequeException;
	public void disableUser(Long id);
	public User doConnection(String pseudo, String passWord) throws BibliothequeException;
	public void checkPseudoExist(String pseudo) throws BibliothequeException;
	public User getUser(Long id);
	public void editPasswordByRecovery(String email, String password, String passwordConfirm) throws BibliothequeException;;
}

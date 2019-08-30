package com.bibliotheque.unitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.bibliotheque.dao.MailRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.MailBusinessImpl;
import com.bibliotheque.utilities.Jasypt;
import com.bibliotheque.utilities.SendMail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestMailBusiness {

	@InjectMocks
	private MailBusinessImpl mailBusiness;
	@Mock
	private MailRepository mailRepository;
	@Mock
	private Jasypt jasypt;
	@Mock
	private SendMail sendMail;
	private Mail mail;
	private User user;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(mailBusiness, "emailUsers", "");
		ReflectionTestUtils.setField(mailBusiness, "emailPassword", "");
		ReflectionTestUtils.setField(mailBusiness, "objectRecovery", "");
		ReflectionTestUtils.setField(mailBusiness, "bodyRecovery", "");
		ReflectionTestUtils.setField(mailBusiness, "expirationToken", 30);
		user = new User();
		user.setId(1l);
		mail = new Mail();
		mail.setEmail("pichat.morgan@gmail.com");
		mail.setId(1l);
		mail.setUser(user);
	}
	
	@Test
	public void testValidateMail() throws BibliothequeException {
		mailBusiness.validateMail(mail);	
	}
	
//	@Test(expected = BibliothequeException.class)
//	public void testValidateMailWithBadEmail() throws BibliothequeException {
//		mail.setEmail("Test@test");
//		mailBusiness.validateMail(mail);	
//	}
	
//	@Test(expected = BibliothequeException.class)
//	public void testValidateMailWithBadEmail2() throws BibliothequeException {
//		mail.setEmail("Test");
//		mailBusiness.validateMail(mail);	
//	}
//	
//	@Test(expected = BibliothequeException.class)
//	public void testValidateMailWithBadEmail3() throws BibliothequeException {
//		mail.setEmail("Test.test");
//		mailBusiness.validateMail(mail);	
//	}
	
	@Test(expected = BibliothequeException.class)
	public void testValidateMailWithEmailAlreadyExist() throws BibliothequeException {
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		mailBusiness.validateMail(mail);	
	}
	
	@Test
	public void testCreateMail() throws BibliothequeException {

		Mockito.when(mailRepository.save(mail)).thenReturn(mail);

		mailBusiness.createMail(mail, user);
		// on vérifie que l'utilisateur à bien l'état actif à sa création
		assertEquals(user, mail.getUser());		
	}
	
	@Test
	public void testSaveMail() throws BibliothequeException {

		Mail mail2 =new Mail();
		mail2.setEmail("Test2@test.test");
		
		Mockito.when(mailRepository.findByUserID(user.getId())).thenReturn(mail);
		Mockito.when(mailRepository.save(Mockito.any(Mail.class))).thenAnswer(i -> i.getArguments()[0]);
		mail = mailBusiness.saveMail(mail2, user.getId());
		// on vérifie que l'utilisateur à bien l'état actif à sa création
		assertEquals(mail.getEmail(), mail2.getEmail());		
	}
	
	@Test
	public void testSaveMailWithSameEmail() throws BibliothequeException {
	
		Mail mail2 =new Mail();
		mail2.setEmail(mail.getEmail());
		
		Mockito.when(mailRepository.findByUserID(user.getId())).thenReturn(mail);
		mail = mailBusiness.saveMail(mail2, user.getId());
		// on vérifie que l'utilisateur à bien l'état actif à sa création
		assertEquals(mail.getEmail(), mail2.getEmail());		
	}
	
	@Test
	public void testSendToken() throws BibliothequeException {
		mail.getUser().setActive(true);
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		Mockito.when(mailRepository.save(mail)).thenReturn(mail);
		
		mailBusiness.sendToken(mail.getEmail());
		
		ArgumentCaptor<Mail> argument = ArgumentCaptor.forClass(Mail.class);
		verify(mailRepository).save(argument.capture());
		
		assertEquals(argument.getValue().getTryToken(), 0);
		assertTrue(!argument.getValue().getToken().isEmpty());
		assertTrue(argument.getValue().getExpiryToken() != null);
	}
	
	@Test(expected = BibliothequeException.class)
	public void testSendTokenWithBadEmail() throws BibliothequeException {		
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(null);
		
		mailBusiness.sendToken(mail.getEmail());				
	}
	
	@Test(expected = BibliothequeException.class)
	public void testSendTokenWithUserNotActive() throws BibliothequeException {	
		mail.getUser().setActive(false);
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		
		mailBusiness.sendToken(mail.getEmail());				
	}
	
	@Test
	public void testValidateToken() throws BibliothequeException {	
		mail.setToken("token");
		mail.setTryToken(0);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 1);
		mail.setExpiryToken(c.getTime());
		
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		//si la méthode ne lève aucune erreur c'est bon
		mailBusiness.validateToken(mail.getToken(), mail.getEmail());			
	}
	
	@Test(expected = BibliothequeException.class)
	public void testValidateTokenWithTokenExpiry() throws BibliothequeException {	
		mail.setToken("token");
		mail.setTryToken(0);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, -1);
		mail.setExpiryToken(c.getTime());
		
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		//si la méthode ne lève aucune erreur c'est bon
		mailBusiness.validateToken(mail.getToken(), mail.getEmail());			
	}
	
	@Test(expected = BibliothequeException.class)
	public void testValidateTokenWithBadTryToken() throws BibliothequeException {	
		mail.setToken("token");
		mail.setTryToken(3);
			
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		//si la méthode ne lève aucune erreur c'est bon
		mailBusiness.validateToken(mail.getToken(), mail.getEmail());			
	}
	
	@Test
	public void testValidateTokenWithBadToken() throws BibliothequeException {	
		mail.setToken("token");
		mail.setTryToken(0);
			
		Mockito.when(mailRepository.findByEmail(mail.getEmail())).thenReturn(mail);
		Mockito.when(mailRepository.save(mail)).thenReturn(mail);
		//si la méthode ne lève aucune erreur c'est bon
		try {
			mailBusiness.validateToken("Bla", mail.getEmail());	
		} catch (BibliothequeException e) {
			ArgumentCaptor<Mail> argument = ArgumentCaptor.forClass(Mail.class);
			verify(mailRepository).save(argument.capture());
			assertEquals(argument.getValue().getTryToken(), 1);
		}				
	}
}

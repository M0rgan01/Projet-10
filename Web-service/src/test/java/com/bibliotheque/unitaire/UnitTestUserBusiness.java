package com.bibliotheque.unitaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Calendar;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.bibliotheque.dao.UserRepository;
import com.bibliotheque.entities.Mail;
import com.bibliotheque.entities.Roles;
import com.bibliotheque.entities.User;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.MailBusiness;
import com.bibliotheque.metier.UserBusinessImpl;
import com.bibliotheque.utilities.Jasypt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestUserBusiness {

	@InjectMocks
	private UserBusinessImpl userBusiness;
	@Mock
	private UserRepository userRepository;
	@Mock
	private Jasypt jasytp;
	@Mock
	private MailBusiness mailBusiness;
	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private User user;
	private Mail mail;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(userBusiness, "minuteInMillisForConnection", 600000);
		user = new User();
		user.setPseudo("TestPseudo");
		user.setPassWord("Test1234");
		user.setPassWordConfirm("Test1234");
		user.setId(1l);
		mail = new Mail("Test@test.com", user);
	}

	@Test
	public void testCreateUser() throws BibliothequeException {

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(bCryptPasswordEncoder.encode(user.getPassWord())).thenReturn("PasswordEncoded");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		user = userBusiness.createUser(user, mail);

		// on vérifie que l'utilisateur à bien l'état actif à sa création
		assertTrue(user.isActive());
		// on vérifie que l'utilisateur à bien son mot de passe encodé
		assertEquals(user.getPassWord(), "PasswordEncoded");
		// on vérifie qu'il à bien le role user
		for (Roles role : user.getRoles()) {
			assertEquals(role.getRole(), "ROLE_USER");
		}
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidateUserWithSamePseudoExist() throws BibliothequeException {
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		userBusiness.validateUser(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtEmptyPassWord() throws BibliothequeException {
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtEmptyPassWordConfirm() throws BibliothequeException {
		user.setPassWordConfirm("Test");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test");
		Mockito.when(jasytp.getDecrypt(user.getPassWordConfirm())).thenReturn("");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtRegexNoMatch() throws BibliothequeException {
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("test1234");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtRegexNoMatch2() throws BibliothequeException {
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtRegexNoMatch3() throws BibliothequeException {
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("TestTest");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testvalidatePassWordWihtPasswordConfirmNoMatch() throws BibliothequeException {
		user.setPassWordConfirm("Test");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(jasytp.getDecrypt(user.getPassWordConfirm())).thenReturn("Test12345");
		userBusiness.validatePassWord(user);
	}

	@Test(expected = BibliothequeException.class)
	public void testgetUserWithBadId() throws BibliothequeException {
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		userBusiness.getUser(2l);
	}

	@Test
	public void testDisableUser() throws BibliothequeException {
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		userBusiness.disableUser(user.getId());

		// on récupère l'object en argument de la méthode save
		ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
		verify(userRepository).save(argument.capture());

		// vérifie que l'utilisateur à bien été désactivé
		assertTrue(!argument.getValue().isActive());
	}

	@Test
	public void testDoconnection() throws BibliothequeException {
		user.setTryConnection(2);
		user.setActive(true);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user.getPassWord())).thenReturn(true);

		user = userBusiness.doConnection(user.getPseudo(), user.getPassWord());

		assertEquals(user.getTryConnection(), 0);
	}

	@Test(expected = BibliothequeException.class)
	public void testDoconnectionWhitNoMatchPseudo() throws BibliothequeException {
		Mockito.when(userRepository.findByPseudo("pseudo")).thenReturn(user);

		userBusiness.doConnection(user.getPseudo(), user.getPassWord());
	}

	@Test(expected = BibliothequeException.class)
	public void testDoconnectionWhitUserNotActive() throws BibliothequeException {
		user.setActive(false);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);

		userBusiness.doConnection(user.getPseudo(), user.getPassWord());

	}

	@Test(expected = BibliothequeException.class)
	public void testDoconnectionWhitExpiryConnectionNoFinish() throws BibliothequeException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 2);
		user.setActive(true);
		user.setExpiryConnection(c.getTime());
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);

		userBusiness.doConnection(user.getPseudo(), user.getPassWord());
	}

	@Test
	public void testDoconnectionWhitExpiryConnectionFinish() throws BibliothequeException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -2);
		user.setTryConnection(3);
		user.setActive(true);
		user.setExpiryConnection(c.getTime());

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user.getPassWord())).thenReturn(true);

		user = userBusiness.doConnection(user.getPseudo(), user.getPassWord());
		assertTrue(user.getExpiryConnection() == null);
		assertEquals(user.getTryConnection(), 0);
	}

	@Test
	public void testDoconnectionWhitExpiryConnectionFinishAndBadPassword() throws BibliothequeException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -2);
		user.setTryConnection(3);
		user.setActive(true);
		user.setExpiryConnection(c.getTime());

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user.getPassWord())).thenReturn(false);

		try {
			userBusiness.doConnection(user.getPseudo(), user.getPassWord());
		} catch (Exception e) {
			// on récupère l'object en argument de la 2eme méthode save
			ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
			verify(userRepository, times(2)).save(argument.capture());
			// la doit date d'expiration doit être effacé
			assertTrue(argument.getValue().getExpiryConnection() == null);
			// et le nombre d'essais de connection échoué à 1
			assertEquals(argument.getValue().getTryConnection(), 1);
		}
	}

	@Test
	public void testDoconnectionWhitBadPassword() throws BibliothequeException {

		user.setTryConnection(0);
		user.setActive(true);

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user.getPassWord())).thenReturn(false);
		try {
			user = userBusiness.doConnection(user.getPseudo(), user.getPassWord());
		} catch (Exception e) {
			// on récupère l'object en argument de la méthode save
			ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
			verify(userRepository).save(argument.capture());
			// et le nombre d'essais de connection échoué à 1
			assertEquals(argument.getValue().getTryConnection(), 1);
		}
	}

	@Test
	public void testDoconnectionWhitBadPasswordAndTwoTryConnection() throws BibliothequeException {

		user.setTryConnection(2);
		user.setActive(true);

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findByPseudo(user.getPseudo())).thenReturn(user);
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user.getPassWord())).thenReturn(false);
		try {
			user = userBusiness.doConnection(user.getPseudo(), user.getPassWord());
		} catch (Exception e) {
			// on récupère l'object en argument de la méthode save
			ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
			verify(userRepository).save(argument.capture());
			// on vérifie la présence d'une date limite avant la possibilité de se connecter
			assertTrue(argument.getValue().getExpiryConnection() != null);
			assertEquals(argument.getValue().getTryConnection(), 3);
		}
	}

	@Test
	public void testEditPasswordByRecovery() throws BibliothequeException {
		Mockito.when(mailBusiness.getMail(mail.getEmail())).thenReturn(mail);
		Mockito.when(bCryptPasswordEncoder.encode(user.getPassWord())).thenReturn("PasswordEncoded");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		
		userBusiness.editPasswordByRecovery(mail.getEmail(), user.getPassWord(), user.getPassWord());
		
		// on récupère l'object en argument de la méthode save
		ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
		verify(userRepository).save(argument.capture());
		//vérification de la modification du mdp
		assertEquals(argument.getValue().getPassWord(), "PasswordEncoded");
	}

	@Test
	public void testSaveUserOnlyPseudo() throws BibliothequeException {
		User user2 = new User();
		user2.setPseudo("TestPseudo2");
		user2.setId(user.getId());
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));	
		Mockito.when(jasytp.getDecrypt(user2.getPassWord())).thenReturn("");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		user = userBusiness.saveUser(user2);
		
		assertEquals(user.getPseudo(), user2.getPseudo());
	}
	
	@Test
	public void testSaveUserOnlyPassword() throws BibliothequeException {
		User user2 = new User();
		user2.setPseudo(user.getPseudo());
		user2.setId(user.getId());
		user2.setPassWord("Test12345");
		user2.setPassWordConfirm("Test12345");
		user2.setOldPassWord(user.getPassWord());
		
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));	
		Mockito.when(jasytp.getDecrypt(user2.getPassWord())).thenReturn("Test12345");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.encode(user2.getPassWord())).thenReturn("PasswordEncoded");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user2.getOldPassWord())).thenReturn(true);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		user = userBusiness.saveUser(user2);
		
		assertEquals(user.getPassWord(), "PasswordEncoded");
	}
	
	@Test(expected = BibliothequeException.class)
	public void testSaveUserWithNoMatchOldPassword() throws BibliothequeException {
		User user2 = new User();
		user2.setPseudo(user.getPseudo());
		user2.setId(user.getId());
		user2.setPassWord("Test12345");
		user2.setPassWordConfirm("Test12345");
		user2.setOldPassWord(user.getPassWord());
		
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));	
		Mockito.when(jasytp.getDecrypt(user2.getPassWord())).thenReturn("Test12345");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("Test1234");
		Mockito.when(bCryptPasswordEncoder.matches(user.getPassWord(), user2.getOldPassWord())).thenReturn(false);
		
		user = userBusiness.saveUser(user2);
	}
	
	@Test(expected = BibliothequeException.class)
	public void testSaveUserWithEmptyOldPassword() throws BibliothequeException {
		User user2 = new User();
		user2.setPseudo(user.getPseudo());
		user2.setId(user.getId());
		user2.setPassWord("Test12345");
		user2.setPassWordConfirm("Test12345");
		user2.setOldPassWord(user.getPassWord());
		
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));	
		Mockito.when(jasytp.getDecrypt(user2.getPassWord())).thenReturn("Test12345");
		Mockito.when(jasytp.getDecrypt(user.getPassWord())).thenReturn("");
		
		user = userBusiness.saveUser(user2);
	}
}

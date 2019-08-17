package com.bibliotheque.unitaire;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.KindBusinessImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestKindBusiness {

	@InjectMocks
	private KindBusinessImpl kindBusiness;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidateKind() throws BibliothequeException {
		Kind kind = new Kind("Test");
		kindBusiness.validateKind(kind);
	}
}

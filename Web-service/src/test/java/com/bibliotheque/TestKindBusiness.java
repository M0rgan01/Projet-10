package com.bibliotheque;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.KindRepository;
import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;
import com.bibliotheque.metier.KindBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestKindBusiness{

	@Autowired
	private KindRepository kindRepository;
	@Autowired
	private KindBusiness kindBusiness;
	
	@Test
	public void testCreateKind() throws BibliothequeException {
		Kind kind = new Kind("Test");
		kindBusiness.saveKind(kind);
		
		Kind kindCompare = kindRepository.findAll().get(0);
		
		assertEquals(kind.getName(), kindCompare.getName());					
	}
	
	@Test(expected=BibliothequeException.class)
	public void testCreateKindWithBlankName() throws BibliothequeException {
		Kind kind = new Kind("");
		kindBusiness.saveKind(kind);
	}
	
	
	@Test
	public void TestGetListKind() throws BibliothequeException {
		
		kindRepository.save(new Kind("Test1"));
		kindRepository.save(new Kind("Test2"));
		kindRepository.save(new Kind("Test3"));
			
		List<Kind> list = kindBusiness.getListKind();
		
		assertEquals(list.size(), 3);		
	}
	
	@Test
	public void TestGetKind() throws BibliothequeException {	
		kindBusiness.saveKind(new Kind("Test"));
		Kind kind = kindBusiness.getKind("Test");	
		assertEquals(kind.getName(), "Test");		
	}
	
}

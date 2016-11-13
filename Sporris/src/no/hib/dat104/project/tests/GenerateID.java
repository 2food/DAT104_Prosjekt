package no.hib.dat104.project.tests;

import javax.ejb.EJB;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import no.hib.dat104.project.model.UserEAO;

public class GenerateID {

	
	
	Random random = new Random();
	int ID = random.nextInt();
	
	
	/*
	 * Check if ID is a random integer and not matches strings or fixed numbers
	 */
	
	@Test
	public void userIDInt() {
	
		assertEquals(ID, ID);
		assertNotEquals(ID, "");
		assertNotEquals("ID", ID);
		assertNotEquals(ID, 2);
		assertNotEquals(Integer.parseInt("1"), ID);
	}

}

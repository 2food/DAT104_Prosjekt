package no.hib.dat104.project.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import no.hib.dat104.project.validators.*;
import no.hib.dat104.project.model.*;

public class RegistrerTest {
	public RegisterValidator validator = new RegisterValidator();
	UserEAO userEAO;
	
	@Test
	public void usernameTest() {
		assertTrue(validator.isValidUsername("Per"));
		assertTrue(validator.isValidUsername("Pettersen"));
		assertFalse(validator.isValidUsername("dettenavneteraltforlangt"));
	}
	
	@Test
	public void usernameExistsTest(){
		assertFalse(validator.usernameAlreadyExists("Kalle", userEAO));
	}
	
	@Test
	public void passwordMatchesTest(){
		assertTrue(validator.passwordsmatches("passord", "passord"));
		assertFalse(validator.passwordsmatches("Passord", "Password"));
		assertFalse(validator.passwordsmatches("Password", "password"));

	}
}

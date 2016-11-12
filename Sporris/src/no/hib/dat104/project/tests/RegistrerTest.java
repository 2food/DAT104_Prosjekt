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
		assertTrue(validator.isValidUsername("Pertter"));
		assertTrue(validator.isValidUsername("Pettersen"));
		assertFalse(validator.isValidUsername("dettenavneteraltforlangt"));
	}
	@Test
	public void passwordTest(){
		assertTrue(validator.isValidPassword("Hingst1234"));
		assertFalse(validator.isValidPassword("Trollebukta?"));
		assertFalse(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword("asdfg"));
		assertTrue(validator.isValidPassword("DetteErGyldig"));
		assertFalse(validator.isValidPassword("123"));
		assertFalse(validator.isValidPassword("pass or 1=1"));
	}
	
	@Test
	public void usernameExistsTest(){
		assertFalse(validator.usernameAlreadyExists("Extra", userEAO));
	}
	
	@Test
	public void passwordMatchesTest(){
		assertTrue(validator.passwordsmatches("passord", "passord"));
		assertFalse(validator.passwordsmatches("Passord", "Password"));
		assertFalse(validator.passwordsmatches("Password", "password"));

	}
}

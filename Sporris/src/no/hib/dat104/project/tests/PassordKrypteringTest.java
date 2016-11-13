package no.hib.dat104.project.tests;
import no.hib.dat104.project.helpers.*;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import org.junit.*;

import junit.framework.Assert;

public class PassordKrypteringTest {
	
	public Passordkryptering passkrypt = new Passordkryptering();
	
	/*
	 * Checking if the strings are equal. They are, so we cryptate one of them and check if they still matches. They dont
	 * So we run the method check if the first one matches the crypted one after decrypting, and it does.
	 */
	@Test
	public void sjekkPassord(){
		String passFor = "heihei";
		String passEtter = "heihei";
		assertSame(passFor, passEtter);
		passEtter = passkrypt.krypterPassord(passEtter);
		assertNotSame(passEtter, passFor);
		assertTrue(passkrypt.sjekkPassord(passFor, passEtter));
		
		
	}

	@Test
	public void krypterPassord(){
		String passord = "passord";
		String salt = "passord";
		assertSame(passord,salt);
		salt = passkrypt.krypterPassord(passord);
		assertNotSame(passord,salt);
	}
	

	
	
}

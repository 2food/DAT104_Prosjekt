package no.hib.dat104.project.tests;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

/*
 * Funskjonell testing av login funksjonalitet
 * @author Tormod
 */
public class LoginFuncTest {

	private static final String HOST = "localhost";
	private static final String PORT = "8080";
	private static final String CONTEXT_ROOT = "Sporris";
	private static final String BASE_URL = "http://" + HOST + ":" + PORT + "/" + CONTEXT_ROOT;
	

	@Before
	public void inject() throws NamingException {
		setBaseUrl(BASE_URL);
	}

	@Test
	public void wrongUsernameTest() {
		beginAt("login");
		setTextField("username", "fe");
		
		submit();
		
		assertTextInElement("wrongUsername", "Brukernavn");
		assertTextNotInElement("wrongPassword", "Passord");
	}
	
	@Test
	public void wrongPasswordTest() {
		beginAt("login");
		setTextField("username", "admin");
		
		submit();
		
		assertTextNotInElement("wrongUsername", "Brukernavn");
		assertTextInElement("wrongPassword", "Passord");
	}
	
	@Test 
	public void correctUserTest() {
		beginAt("login");
		setTextField("username", "admin");
		setTextField("password", "pass");
		
		submit();
		assertTitleEquals("Kontrollpanel");
	}
	

}

package no.hib.dat104.project.validators;
/*
 * Validering av brukerinputt for registreringsskjema
 * @author Vegard
 */
import no.hib.dat104.project.model.*;
public class RegisterValidator {

	/*
	 * Validerer brukernavn
	 * @param username - Må ha mer enn 3 og mindre enn 20 tegn
	 */
	public boolean isValidUsername(String username){
		boolean valid = true;
		if (username.length() < 3 || username.length() > 20) {
			valid = false;
		}
		return valid;
	}
	/*
	 * Sjekker om brukernavn allerede er i bruk
	 * @param username, UserEAO
	 * @return true hvis brukernavn finnes
	 */
	public boolean usernameAlreadyExists(String username, UserEAO UEAO){
		// return UEAO.findUserByUserName(username)!= null
		return false;
	}
	/*
	 * Sjekker om bruker skriver inn 2 like passord
	 * @param pass1(passord), pass2(gjenta passord)
	 * @return true hvis passord er like
	 */
	public boolean passwordsmatches(String pass1, String pass2){
		return pass1.matches(pass2);
	}
}

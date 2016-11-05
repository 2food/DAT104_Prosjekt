package no.hib.dat104.project.validators;
import java.util.List;

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
	public static boolean isValidUsername(String username){
		boolean valid = true;
		if (username.length() < 3 || username.length() > 20) {
			valid = false;
		}
		return valid;
	}
	/*
	 * Validerer passord
	 */
	public static boolean isValidPassword(String password){
		boolean validp = true;
		if(password.length() < 1){
			validp = false;
		}
		return validp;
	}
	
	/*
	 * Sjekker om brukernavn allerede er i bruk
	 * @param username, UserEAO
	 * @return true hvis brukernavn finnes
	 */
	public static boolean usernameAlreadyExists(String username, UserEAO UEAO){
		boolean nameExists =false;
		List<User> allUsers = UEAO.allUsers();
		for(User user : allUsers){
			if(username.equals(user.getUser_name())){
				nameExists = true;
			}
		}
		return nameExists;
	}
	/*
	 * Sjekker om bruker skriver inn 2 like passord
	 * @param pass1(passord), pass2(gjenta passord)
	 * @return true hvis passord er like
	 */
	public static boolean passwordsmatches(String pass1, String pass2){
		return pass1 != null && pass1.equals(pass2);
	
	}
}

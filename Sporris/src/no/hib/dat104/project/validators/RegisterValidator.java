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
	 * @param username - M� ha mer enn 3 og mindre enn 20 tegn, bare tall og bokstaver
	 */
	public static boolean isValidUsername(String username){
		return username.matches("^[a-zA-Z0-9]{4,20}$");
	}
	/*
	 * Validerer passord
	 */
	public static boolean isValidPassword(String password){
		return password.matches("^[a-zA-Z0-9]{8,20}$");
	}
	
	/*
	 * Sjekker om brukernavn allerede er i bruk
	 * @param username, UserEAO
	 * @return true hvis brukernavn finnes
	 */
	public static boolean usernameAlreadyExists(String username, UserEAO UEAO){
		boolean nameExists =false;
//		List<User> allUsers = UEAO.allUsers();
//		for(User user : allUsers){
//			if(username.equals(user.getUser_name())){
//				nameExists = true;
//			}
//		}
//	if(UEAO.findUser(username) != null)
//			nameExists = true;
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

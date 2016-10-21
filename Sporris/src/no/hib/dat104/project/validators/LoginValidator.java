package no.hib.dat104.project.validators;

/*
 * Validerer logininfo
 * @author Tormod
 */

public class LoginValidator {


	/*
	 * Validerer username
	 * Ikke valid hvis kortere enn 3 eler lengre enn 20 karakterer.
	 * @author Tormod
	 */
	public static boolean usernameValidator(String username){
		boolean valid = true;
		if (username.length() < 3 || username.length() > 20) {
			valid = false;
		}
		return valid;
	}
	
	/*
	 * Validerer password.
	 * Ikke valid hvis kortere enn 8 karakterer
	 * @author Tormod
	 */
	public static boolean passwordValidator(String password) {
		boolean valid = true;
		if (password.length() < 8) {
			valid = false;
		}
		return valid;
	}
	

	

}

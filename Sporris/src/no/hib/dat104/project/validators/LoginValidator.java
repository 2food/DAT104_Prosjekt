package no.hib.dat104.project.validators;

import javax.ejb.EJB;

import no.hib.dat104.project.helpers.Passordkryptering;
import no.hib.dat104.project.javabeans.LoginJavaBean;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

/*
 * Validerer login
 * @author Tormod
 */

public class LoginValidator {

	

	/*
	 * Sjekker om username finnes i databsen og om password er riktig
	 * 
	 * @Param LoginJavaBean
	 * 
	 * @author Tormod
	 */
	public static boolean validate(LoginJavaBean login, UserEAO ueao) {
		ueao.isOpen();
		User user = ueao.findUser(login.getUsername());
		boolean valid = false;
		if (user == null) {
			// bruker finnes ikke
			login.setValidUsername(false);
			login.setValidPassword(true);
		} else if (!Passordkryptering.sjekkPassord(login.getPassword(),user.getUser_password())) {
			// bruker finnes, men passord er feil
			login.setValidUsername(true);
			login.setValidPassword(false);
		} else {
			// bruker finnes og passord er riktig
			login.setValidUsername(true);
			login.setValidPassword(true);
			valid = true;
		}
		return valid;
	}
}

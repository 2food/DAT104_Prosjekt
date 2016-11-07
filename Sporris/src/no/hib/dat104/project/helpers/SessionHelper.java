package no.hib.dat104.project.helpers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.User;
/*
 * Hjelpeklasse for sessionshåndtering 
 * @author Vegard
 */
public class SessionHelper {
	/*
	 * logger inn en bruker
	 */
	public static void logInUser(HttpServletRequest request, User user){
		HttpSession session = request.getSession(false);
		
		session.setAttribute("login", "true");
		session.setAttribute("user", user);
		
	}

	
	/*
	 * Sjekker om brukeren er logget inn
	 * @param HttpSession
	 * @return true hvis bruker er logget in
	 */
	public boolean isUserLoggedIn(HttpSession session){
		
		return session.getAttribute("login").equals("true");
	}
}

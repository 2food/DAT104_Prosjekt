package no.hib.dat104.project.helpers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.User;
/*
 * Hjelpeklasse for sessionsh�ndtering 
 * @author Vegard
 */
public class SessionHelper {
	/*
	 * logger inn en bruker
	 */
	public static void logInUser(HttpServletRequest request, User user){
		HttpSession session = request.getSession(false);
		session.setAttribute("loggedin", true);
		session.setAttribute("user", user);
		
	}

	
	/*
	 * Sjekker om brukeren er logget inn
	 * @param HttpSession
	 * @return true hvis bruker er logget in
	 */
	public static boolean isUserLoggedIn(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		return (session.getAttribute("loggedin") != null && ((boolean) session.getAttribute("loggedin")));
	}
}

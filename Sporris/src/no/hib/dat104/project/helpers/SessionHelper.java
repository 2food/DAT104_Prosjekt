package no.hib.dat104.project.helpers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/*
 * Hjelpeklasse for sessionshåndtering 
 * @author Vegard
 */
public class SessionHelper {
	/*
	 * logger inn en bruker
	 */
	public static void logInUser(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		String username = (String) request.getAttribute("username");
		session.setAttribute("login", "true");
		session.setAttribute("username", username);
		
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

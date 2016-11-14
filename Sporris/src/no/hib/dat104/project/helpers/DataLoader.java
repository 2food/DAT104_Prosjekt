package no.hib.dat104.project.helpers;

import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.SporrisEAO;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

public class DataLoader {

	/**
	 * gets the user from the session
	 * @param session
	 * @param ueao
	 * @return
	 * @author Torstein
	 */
	public static User getUser(HttpSession session, UserEAO ueao) {
		User user;
		int userId;
		if (session.getAttribute("userId") == null || session.getAttribute("sporrisId") == null) {
			session.setAttribute("userId", 100);
		}
		userId = (Integer) session.getAttribute("userId");
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
		}
		return user;
	}

	/**
	 * gets the sporris from the session
	 * @param session
	 * @param ueao
	 * @return
	 * @author Torstein
	 */
	public static Sporris getSporris(HttpSession session, UserEAO ueao) {
		Sporris sporris = null;
		if (session.getAttribute("sporrisId") == null){
			sporris = (Sporris) session.getAttribute("sporris");
		} else {
			int sporrisId = (Integer) session.getAttribute("sporrisId");
			sporris = ueao.findSporrisCascade(sporrisId);
		}
		return sporris;
	}
}

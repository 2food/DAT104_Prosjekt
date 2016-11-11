package no.hib.dat104.project.helpers;

import javax.servlet.http.HttpServletRequest;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

public class QuestionHelper {

	
	/**
	 * Creates questions from an HttpServletRequest, adds them to a Sporris, and stores them in the database with an UserEAO
	 * @param ueao
	 * @param sporris
	 * @param request
	 * @author Torstein
	 */
	public static void saveNewQuestions(UserEAO ueao, Sporris sporris, HttpServletRequest request) {
		User user = sporris.getSporris_user();
		

		if (request.getParameter("sporrisName") != null) {
			sporris.setSporris_name(request.getParameter("sporrisName"));
			if (sporris.getSporris_name().length() == 0) {
				sporris.setSporris_name("Sporris uten navn");
			}
		} else {
			sporris.setSporris_name("Sporris uten navn");
		}
		if (request.getParameter("newQCounter") != null && request.getParameter("newACounter") != null) {
			// TODO type exception!!!!
			int newQCounter = Integer.parseInt(request.getParameter("newQCounter"));
			int newACounter = Integer.parseInt(request.getParameter("newACounter"));

			Question newQ;
			Alternative newA;
			for (int q = 0; q <= newQCounter; q++) {
				if (request.getParameter("newQ_" + q) != null) {
					boolean allowText = (request.getParameter("newQ_" + q + "_text") != null
							&& request.getParameter("newQ_" + q + "_text").equals("on"));
					boolean allowMultiple = (request.getParameter("newQ_" + q + "_multiple") != null
							&& request.getParameter("newQ_" + q + "_multiple").equals("on"));
					newQ = new Question(request.getParameter("newQ_" + q), allowText, allowMultiple, sporris);
					
					for (int a = 0; a <= newACounter; a++) {
						if (request.getParameter("newQ_" + q + "_aid_" + a) != null) {
							newA = new Alternative(request.getParameter("newQ_" + q + "_aid_" + a), newQ);
							newQ.getAlternatives().add(newA);

//							System.out.println("added newQ_" + q + "_aid_" + a);
						}
					}
					if (!sporris.contains(newQ)) {
						sporris.getQuestions().add(newQ);
					}
//					System.out.println("added newQ_" + q);
				}
			}
			// System.out.println(user.getSporrises().get(0).getQuestions().size());
			ueao.updateUser(user);
		}
	}
}

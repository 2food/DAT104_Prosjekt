package no.hib.dat104.project.helpers;

import javax.servlet.http.HttpServletRequest;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

public class QuestionHelper {

	/**
	 * Creates questions from an HttpServletRequest, adds them to a Sporris, and
	 * stores them in the database with an UserEAO
	 * 
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
					// add alternatives
					for (int a = 0; a <= newACounter; a++) {
						if (request.getParameter("newQ_" + q + "_newA_" + a) != null) {
							newA = new Alternative(request.getParameter("newQ_" + q + "_newA_" + a), newQ);
							newQ.addAlternative(newA);
							// System.out.println("added newQ_" + q + "_aid_" +
							// a);
						}
					}
					if (!sporris.contains(newQ)) {
						sporris.addQuestion(newQ);
						// System.out.println("added newQ_" + q);
					}
				}
			}
			// System.out.println(user.getSporrises().get(0).getQuestions().size());
			ueao.updateUser(user);
			// ueao.updateSporris(sporris);
		}
	}

	/**
	 * creates a dummy sporris for testing
	 * 
	 * @param existingSporris
	 *            - the old sporris for comparison
	 * @param request
	 *            - for the input
	 * @return dummy sporris
	 * @author Torstein
	 */
	public static Sporris editSporris(Sporris existingSporris, HttpServletRequest request) {
		Sporris sporris = new Sporris(new User());

		int newQCounter = Integer.parseInt(request.getParameter("newQCounter"));
		int newACounter = Integer.parseInt(request.getParameter("newACounter"));

		Question newQ;
		Alternative newA;
		if (request.getParameter("sporrisName") != null) {
			sporris.setSporris_name(request.getParameter("sporrisName"));
		}
		// add existing questions
		for (Question q : sporris.getQuestionsOrdered()) {
			if (request.getParameter("oldQ_" + q.getQid()) != null) {
				boolean allowText = (request.getParameter("oldQ_" + q + "_text") != null
						&& request.getParameter("oldQ_" + q + "_text").equals("on"));
				boolean allowMultiple = (request.getParameter("newQ_" + q + "_multiple") != null
						&& request.getParameter("oldQ_" + q + "_multiple").equals("on"));
				newQ = new Question(request.getParameter("oldQ_" + q), allowText, allowMultiple, sporris);

				// add existing alternatives
				for (Alternative a : q.getAlternatives()) {
					if (request.getParameter("oldQ_" + q.getQid() + "_oldA_" + a.getAid()) != null) {
						newA = new Alternative(request.getParameter("oldQ_" + q.getQid() + "_oldA_" + a.getAid()),
								newQ);
						newQ.addAlternative(newA);
					}
				}

				// add new alternatives to old questions
				for (int a = 0; a <= newACounter; a++) {
					if (request.getParameter("oldQ_" + q.getQid() + "_newA_" + a) != null) {
						newA = new Alternative(request.getParameter("newQ_" + q.getQid() + "_newA_" + a), newQ);
						newQ.addAlternative(newA);
					}
				}
				sporris.addQuestion(newQ);
			}
		}

		// add new questions
		for (int q = 0; q <= newQCounter; q++) {
			if (request.getParameter("newQ_" + q) != null) {
				boolean allowText = (request.getParameter("newQ_" + q + "_text") != null
						&& request.getParameter("newQ_" + q + "_text").equals("on"));
				boolean allowMultiple = (request.getParameter("newQ_" + q + "_multiple") != null
						&& request.getParameter("newQ_" + q + "_multiple").equals("on"));
				newQ = new Question(request.getParameter("newQ_" + q), allowText, allowMultiple, sporris);
				// add alternatives
				for (int a = 0; a <= newACounter; a++) {
					if (request.getParameter("newQ_" + q + "_newA_" + a) != null) {
						newA = new Alternative(request.getParameter("newQ_" + q + "_newA_" + a), newQ);
						newQ.addAlternative(newA);
					}
				}
				sporris.addQuestion(newQ);
			}
		}
		return sporris;
	}
}

package no.hib.dat104.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

/**
 * Servlet implementation class EditSporrisServlet
 */
@WebServlet("/edit")
public class EditSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    

	@EJB
	private UserEAO ueao;
	int userId;
	int sporrisId;

	public void init() {
		
	}
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		HttpSession session = request.getSession();  
		
		// TODO sync w/ overview
		if (session.getAttribute("userId") == null || session.getAttribute("sporrisId") == null) {
			session.setAttribute("sporrisId", 100);
			session.setAttribute("userId", 100);
			System.out.println("neeeei");
		}
		userId = (Integer) session.getAttribute("userId");
		sporrisId = (Integer) session.getAttribute("sporrisId");
		
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
		}
		Sporris sporris = ueao.findSporrisCascade(sporrisId);
		List<Question> qlist = sporris.getQuestions();
		request.setAttribute("qlist", qlist);
		request.setAttribute("sporrisName", sporris.getSporris_name());
		request.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		Sporris sporris;
		HttpSession session = request.getSession(); 
		
		// TODO sync w/ overview
		if (session.getAttribute("userId") == null || session.getAttribute("sporrisId") == null) {
			session.setAttribute("sporrisId", 100);
			session.setAttribute("userId", 100);
			System.out.println("neeeei");
		}
		userId = (Integer) session.getAttribute("userId");
		sporrisId = (Integer) session.getAttribute("sporrisId");
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
		}
		sporris = user.getSporris(sporrisId);
		
		if (request.getParameter("sporrisName") != null) {
			sporris.setSporris_name(request.getParameter("sporrisName"));
			if (sporris.getSporris_name().length() == 0) {
				sporris.setSporris_name("Sporris uten navn");
			}
		} else {
			sporris.setSporris_name("Sporris uten navn");
		}
		
		if (request.getParameter("newQCounter") != null && request.getParameter("newACounter") != null ) {
			// TODO type exception!!!!
			int newQCounter = Integer.parseInt(request.getParameter("newQCounter"));
			int newACounter = Integer.parseInt(request.getParameter("newACounter"));
			
			
			Question newQ;
			Alternative newA;
			for (int q = 0; q <= newQCounter; q++) {
				if (request.getParameter("newQ_" + q) != null) {
					newQ = new Question();
					newQ.setQuestion_text(request.getParameter("newQ_" + q));
					newQ.setAllow_multiple(true);
					boolean allowText = (request.getParameter("newQ_" + q + "_text") != null && request.getParameter("newQ_" + q + "_text").equals("on"));
					newQ.setAllow_text(allowText ? true : false);
					System.out.println(request.getParameter("newQ_" + q + "_text"));
					System.out.println(newQ.isAllow_text());
					newQ.setQuestion_sporris(sporris);
					newQ.setAlternatives(new ArrayList<Alternative>());
					for (int a = 0; a <= newACounter; a++) {
						if (request.getParameter("newQ_" + q + "_aid_" + a) != null) {
							newA = new Alternative();
							newA.setAlternative_question(newQ);
							newA.setAlternative_text(request.getParameter("newQ_" + q + "_aid_" + a));
							newQ.getAlternatives().add(newA);	

//							System.out.println("added alt");
						}
					}
					if (!sporris.contains(newQ)) {
						sporris.getQuestions().add(newQ);						
					}
//					System.out.println("added q");
				}
			}
//			System.out.println(user.getSporrises().get(0).getQuestions().size());
			ueao.updateUser(user);
			
			
			doGet(request, response);
		} else {
			doGet(request, response);
			
		}
		
		
		
	}
	
//	/**
//	 * 
//	 * @return a static user
//	 */
//	private User makeDummyUser() {
//		User u1 = new User();
//		u1.setUid(10);
//		u1.setUser_name("user2");
//		u1.setUser_password("pass");
//		u1.setSporrises(new ArrayList<Sporris>());
//
//		Sporris s1 = new Sporris();
//		s1.setActive(true);
//		s1.setSid(10);
//		s1.setSporris_name("hepp");
//		s1.setSporris_tag("123qwe");
//		s1.setSporris_user(u1);
//		s1.setQuestions(new ArrayList<Question>());
//		
//		Question q1 = new Question();
//		q1.setAllow_multiple(true);
//		q1.setAllow_text(true);
//		q1.setQid(10);
//		q1.setQuestion_sporris(s1);
//		q1.setQuestion_text("Heter du geir?");
//		q1.setAlternatives(new ArrayList<Alternative>());
//		
//		Alternative a1 = new Alternative();
//		a1.setAid(10);
//		a1.setAlternative_question(q1);
//		a1.setAlternative_text("Ja");
//		
//		Alternative a2 = new Alternative();
//		a2.setAid(11);
//		a2.setAlternative_question(q1);
//		a2.setAlternative_text("Nei");
//		
//		Question q2 = new Question();
//		q2.setAllow_multiple(true);
//		q2.setAllow_text(false);
//		q2.setQid(20);
//		q2.setQuestion_sporris(s1);
//		q2.setQuestion_text("Heter du trine?");
//		q2.setAlternatives(new ArrayList<Alternative>());
//		
//		Alternative a3 = new Alternative();
//		a3.setAid(20);
//		a3.setAlternative_question(q2);
//		a3.setAlternative_text("Ja");
//		
//		Alternative a4 = new Alternative();
//		a4.setAid(21);
//		a4.setAlternative_question(q2);
//		a4.setAlternative_text("Nei");
//
//		q1.getAlternatives().add(a1);
//		q1.getAlternatives().add(a2);
//		q2.getAlternatives().add(a3);
//		q2.getAlternatives().add(a4);
//		s1.getQuestions().add(q1);
//		s1.getQuestions().add(q2);
//		u1.getSporrises().add(s1);
//		
//		return u1;
//	}

}

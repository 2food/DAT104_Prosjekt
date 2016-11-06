package no.hib.dat104.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;


@WebServlet("/UserTest")
public class UserTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserEAO ueao; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		PrintWriter out = response.getWriter();
//		List<User> l = ueao.allUsers();
//		for(User u : l) {
//			out.println(u.getUser_name() + "<br />");
//		}
		
		User user = ueao.findUserCascade(100);
		System.out.println(user.getSporrises().size());
		Sporris s = user.getSporrises().get(0);

		System.out.println(s.getQuestions().size());
		System.out.println(s.getQuestions().get(0).getAlternatives().size());
		

		Question q3 = new Question();
		System.out.println("q3.getQid(): " +q3.getQid()); 
		Alternative a5 = new Alternative();
		a5.setAlternative_question(q3);
		a5.setAlternative_text("Ja");
		Alternative a6 = new Alternative();
		a6.setAlternative_question(q3);
		a6.setAlternative_text("Nei");
		
		
		q3.setAllow_multiple(false);
		q3.setAllow_text(false);
		q3.setQuestion_sporris(s);
		q3.setQuestion_text("Heter du per?");
		q3.setAlternatives(new ArrayList<Alternative>());
//		al.add(a5);
//		al.add(a6);

		
		s.getQuestions().add(q3);
//		ueao.addQuestion(q3);

		q3.getAlternatives().add(a5);
		q3.getAlternatives().add(a6);
//		ueao.updateQuestion(q3);
//		ueao.addAlternative(a5);
//		ueao.addAlternative(a6);

//		s.getQuestions().get(0).setQuestion_text("Heter du fjes?");
		ueao.updateUser(user);
		
		
//		Sporris s1 = new Sporris();
//		s1.setActive(true);
//		s1.setSporris_name("test123");
//		s1.setSporris_tag("123qwe");
//		s1.setSporris_user(user);

	}



}

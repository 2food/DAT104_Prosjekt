package no.hib.dat104.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.project.model.SporrisEAO;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;


@WebServlet("/UserTest")
public class UserTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserEAO ueao; 
	@EJB
	private SporrisEAO seao; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<User> l = ueao.allUsers();
		for(User u : l) {
			out.println(u.getUser_name() + "<br />");
		}
		out.print(seao.getNewId());
		
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
//		u1.getSporrises().add(s1);
//		
//		ueao.addUser(u1);  
	}



}

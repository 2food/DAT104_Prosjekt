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

import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;


@WebServlet("/UserTest")
public class UserTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserEAO ueao; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<User> l = ueao.allUsers();
		for(User u : l) {
			out.println(u.getUser_name() + "<br />");
		}
	}



}

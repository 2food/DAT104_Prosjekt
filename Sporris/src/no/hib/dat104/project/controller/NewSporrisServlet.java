<<<<<<< HEAD
package no.hib.dat104.project.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.helpers.DataLoader;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

/**
 * Servlet implementation class NewSporrisServlet
 */
@WebServlet("/"+UrlMappings.NEWSPORRIS)
public class NewSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserEAO ueao;
	int userId;
	int sporrisId;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		Sporris sporris;
		HttpSession session = request.getSession();
		
		user = DataLoader.getUser(session, ueao);
		System.out.println(user.getUid());
		sporris = new Sporris(user);
//		user.getSporrises().add(sporris);
		user.addSporris(sporris);
		ueao.updateUser(user);
		//ueao.addSporris(sporris);
		System.out.println(sporris.getSid());
		session.setAttribute("sporris", sporris);
		

		response.sendRedirect(UrlMappings.EDITURL);
		
	}

}
=======
package no.hib.dat104.project.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;
import static no.hib.dat104.project.controller.UrlMappings.*;

/**
 * Servlet implementation class NewSporrisServlet
 */
@WebServlet("/"+ NEWSPORRIS)
public class NewSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserEAO ueao;
	int userId;
	int sporrisId;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		Sporris sporris;
		HttpSession session = request.getSession();
		
		// TODO sync w/ overview
//		request.setAttribute("userId", 100);
		if (session.getAttribute("userId") == null) {
			session.setAttribute("userId", 100);
		}
		
		userId = (Integer) session.getAttribute("userId");
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			System.out.println("Dette skjer, uid: " + userId);
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
		}
		System.out.println(user.getUid());
		sporris = new Sporris(user);
		user.getSporrises().add(sporris);
		ueao.updateUser(user);
		ueao.addSporris(sporris);
		System.out.println(sporris.getSid());
		session.setAttribute("sporrisId", sporris.getSid());
		

		response.sendRedirect(EDITURL);
		
	}

}
>>>>>>> refs/heads/master

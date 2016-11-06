package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.LOGINURL;
import static no.hib.dat104.project.controller.UrlMappings.OVERSIKTURL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.javabeans.LoginJavaBean;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;
import no.hib.dat104.project.validators.LoginValidator;

@WebServlet("/" + LOGINURL)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEAO ueao;
	/*
	 * doGet-metode for LoginServlet. Invaliderer session hvis den eksisterer og
	 * oppretter ny. Oppretter LoginJavaBean for login. Forwarder til
	 * login.jsp.
	 * 
	 * @author Tormod
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession oldsession = request.getSession(false);
		if (oldsession != null) {
			oldsession.invalidate();
		}
		HttpSession session = request.getSession();
		session.setAttribute("loggedin", false);
		LoginJavaBean login = new LoginJavaBean();
		session.setAttribute("login", login);
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		LoginJavaBean login = (LoginJavaBean) session.getAttribute("login");
		login.setUsername(username);
		login.setPassword(password);
		LoginValidator.validate(login, ueao);
		if (!login.isValidUsername() || !login.isValidPassword()) {
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
			session.setAttribute("loggedin", true);
			session.setAttribute("user", (User) ueao.findUser(login.getUsername())); 
			response.sendRedirect(OVERSIKTURL);
		}
	}

}

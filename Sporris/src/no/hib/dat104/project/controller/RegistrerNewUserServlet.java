package no.hib.dat104.project.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.helpers.GenerateID;
import no.hib.dat104.project.helpers.SessionHelper;
import no.hib.dat104.project.javabeans.LoginJavaBean;
import no.hib.dat104.project.javabeans.RegistrerJavaBean;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;
import no.hib.dat104.project.validators.RegisterValidator;

import static no.hib.dat104.project.controller.UrlMappings.*;

@WebServlet("/" + NEWUSERURL)
public class RegistrerNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UserEAO userEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession oldsession = request.getSession(false);
		if (oldsession != null) {
			oldsession.invalidate();
		}
		HttpSession session = request.getSession();
		RegistrerJavaBean registrerInfo = new RegistrerJavaBean();
		session.setAttribute("registrerInfo", registrerInfo);
		request.getRequestDispatcher("WEB-INF/jsp/registerNewUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpw = request.getParameter("userpassword");
		String userpw2 = request.getParameter("userpassword2");
		System.out.println(username + ": username");
		System.out.println(userpw + ": userpw");
		System.out.println(userpw2 + ": userpw2");

		RegistrerJavaBean registrerInfo = (RegistrerJavaBean) session.getAttribute("registrerInfo");
		registrerInfo.setUsername(username);
		registrerInfo.setUserpassword1(userpw);
		registrerInfo.setUserpassword2(userpw2);
		registrerInfo.setValidUsername(RegisterValidator.isValidUsername(username));
		registrerInfo.setUsernameExists(RegisterValidator.usernameAlreadyExists(username, userEAO));
		registrerInfo.setPasswordsMatches(RegisterValidator.passwordsmatches(userpw, userpw2));
		System.out.println(registrerInfo.getUsername());
		System.out.println(registrerInfo.getUserpassword1());
		System.out.println(registrerInfo.getUserpassword2());
		
		System.out.println(registrerInfo.isUsernameExists());
		System.out.println(registrerInfo.isValidUsername());
		System.out.println(registrerInfo.isPasswordsMatches());
		

		//Logger inn og går til oversiktssiden hvis registreringsinfo er gyldig
		//henter siden på nytt hvis inpyt ikke er gyldig og viser feilmeldinger
		if (registrerInfo.isValidUsername() && !registrerInfo.isUsernameExists()
				&& registrerInfo.isPasswordsMatches()) {
			
			//Legger til en login, true og username i session
			SessionHelper.logInUser(request);
			//Legg til bruker i databasen
			User user = new User();
			user.setUser_name(username);
			user.setUser_password(userpw);
			int uid = GenerateID.userIDInt(userEAO);
			user.setUid(uid);
			response.sendRedirect(OVERSIKTURL);
		} else {
			response.sendRedirect(NEWUSERURL);
		}

	}

}

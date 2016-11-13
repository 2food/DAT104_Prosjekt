package no.hib.dat104.project.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.helpers.SessionHelper;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.SporrisEAO;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

@WebServlet("/" + UrlMappings.OVERSIKTURL)
public class OversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SporrisEAO seao;
	@EJB
	UserEAO ueao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionHelper.isUserLoggedIn(request)) {
			System.out.println("ugyldig access");
			response.sendRedirect(UrlMappings.LOGINURL);
		} else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println("User i session: " + user.getUser_name());
			request.getRequestDispatcher("WEB-INF/jsp/oversikt.jsp").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int sporrisId = Integer.parseInt(request.getParameter("sporrisID"));
		session.setAttribute("sporrisId", sporrisId);
		User user = (User) session.getAttribute("user");
		System.out.println("User i session: " + user.getUser_name());
		
		if (request.getParameter("activate") != null) {
			seao.activateSporris(sporrisId);
			User u = ueao.findUserCascade(((User) session.getAttribute("user")).getUid());
			session.setAttribute("user", u);
			System.out.println("Endret aktiv");
			response.sendRedirect(UrlMappings.OVERSIKTURL);
		}

		if (request.getParameter("statistics") != null) {
			System.out.println("viser statistikk");
			response.sendRedirect(UrlMappings.RESULTAT);
		}

		if (request.getParameter("edit") != null) {
			response.sendRedirect(UrlMappings.EDITURL);
		}

		if (request.getParameter("delete") != null) {
			seao.removeSporris(sporrisId);
			User u = ueao.findUserCascade(((User) session.getAttribute("user")).getUid()); 
			session.setAttribute("user", u);
			response.sendRedirect(UrlMappings.OVERSIKTURL);
		}

		if (request.getParameter("newSporris") != null) {
			user = ueao.findUserCascade(((User) session.getAttribute("user")).getUid()); 
			Sporris sporris = new Sporris(user);
			user.addSporris(sporris);
			user =  ueao.updateUser(user);
			session.setAttribute("user",user);
			session.setAttribute("sporris", sporris);

//			response.sendRedirect(UrlMappings.EDITURL);
			response.sendRedirect(UrlMappings.OVERSIKTURL);
		}

	}

}

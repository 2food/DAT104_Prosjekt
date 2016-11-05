package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.EDITURL;
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

import no.hib.dat104.project.model.SporrisEAO;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

@WebServlet("/" + OVERSIKTURL)
public class OversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SporrisEAO seao;
	@EJB
	UserEAO ueao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loggedin") == null || !(boolean) session.getAttribute("loggedin")) {
			response.sendRedirect(LOGINURL);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/oversikt.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String sporrisId = request.getParameter("sporrisID");
		System.out.println("Fikk parameter sporrisID: " + sporrisId);
		int sporrisIDAsInt = Integer.parseInt(sporrisId);
		System.out.println("Konveterer parameter sporrisIDAsInt: " + sporrisIDAsInt);

		String buttonActivate = request.getParameter("activate");
		System.out.println("Fikk parameter activate: " + buttonActivate);
		String buttonStatistics = request.getParameter("statistics");
		System.out.println("Fikk parameter statistics: " + buttonStatistics);
		String buttonEdit = request.getParameter("edit");
		System.out.println("Dette er buttonEDIT: " + buttonEdit);
		String buttonDelete = request.getParameter("delete");
		System.out.println("Dette er deleteknappen: " + buttonDelete);
		

		if (buttonActivate != null) {
			System.out.println("knappen er trykket på");
			System.out.println(sporrisId);
			seao.activateSporris(sporrisIDAsInt);
			User u = ueao.findUser(((User) session.getAttribute("user")).getUid());
			session.setAttribute("user", u);
			response.sendRedirect(OVERSIKTURL);
		}
		
		if (buttonStatistics != null) {
			System.out.println("knappen er trykket på");
			System.out.println(sporrisId);
			// sporrisEAO.activateSporris(sporrisIDAsInt);
			response.sendRedirect(OVERSIKTURL);
		}
		
		if (buttonEdit != null) {
			System.out.println("Vi er inne i edit nå");
			session.setAttribute("sporrisId", sporrisId);
			response.sendRedirect(EDITURL);

		}

		if (buttonDelete != null) {
			System.out.println("utfører slett og redirekter til oversikturl");
			// sporrisEAO.removeSporris(sporrisIDAsInt);
			response.sendRedirect(OVERSIKTURL);
		}


	}

}

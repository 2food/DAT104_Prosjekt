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

import no.hib.dat104.project.helpers.SessionHelper;
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
		if (!SessionHelper.isUserLoggedIn(request)) {
			response.sendRedirect(LOGINURL);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/oversikt.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int sporrisId = Integer.parseInt(request.getParameter("sporrisID"));
		session.setAttribute("sporrisId", sporrisId);
		
		if (request.getParameter("activate") != null) {
			seao.activateSporris(sporrisId);
			User u = ueao.findUser(((User) session.getAttribute("user")).getUid());
			session.setAttribute("user", u);
			response.sendRedirect(OVERSIKTURL);
		}

		if (request.getParameter("statistics") != null) {
			// sporrisEAO.activateSporris(sporrisIDAsInt);
			response.sendRedirect(OVERSIKTURL);
		}

		if (request.getParameter("edit") != null) {
			response.sendRedirect(EDITURL);
		}

		if (request.getParameter("delete") != null) {
			seao.removeSporris(sporrisId);
			User u = ueao.findUser(((User) session.getAttribute("user")).getUid());
			session.setAttribute("user", u);
			response.sendRedirect(OVERSIKTURL);
		}

	}

}

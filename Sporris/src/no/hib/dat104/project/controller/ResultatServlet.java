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
import no.hib.dat104.project.model.UserEAO;

/**
 * Servlet for å vise resultater.
 * @author Tormod
 */
@WebServlet("/" + UrlMappings.RESULTAT)
public class ResultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserEAO ueao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Sporris sporris = DataLoader.getSporris(session, ueao);
		session.setAttribute("sporris", sporris);

		request.getRequestDispatcher("WEB-INF/jsp/resultat.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

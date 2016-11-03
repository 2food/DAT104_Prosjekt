package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + OVERSIKTURL)
public class OversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (!(boolean) session.getAttribute("loggedin")) {
			response.sendRedirect(LOGINURL);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/oversikt.jsp").forward(request, response);
		}
	}
	
	/*
	 * "Logger ut" Invaliderer sesjonen og redirecter til innlogging.
	 * 
	 * @author Tormod
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession oldsession = request.getSession(false);
		if (oldsession != null) {
			oldsession.invalidate();
		}
		response.sendRedirect(LOGINURL);
	}

}

package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.EDITURL;
import static no.hib.dat104.project.controller.UrlMappings.SPORRISURL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.helpers.DataLoader;
import no.hib.dat104.project.helpers.QuestionHelper;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.UserEAO;

/**
 * Servlet implementation class EditSporrisServlet
 */
@WebServlet("/" + EDITURL)
public class EditSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    

	@EJB
	private UserEAO ueao;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		
//		User user;
//		user = DataLoader.getUser(session, ueao);
		Sporris sporris;
		sporris = DataLoader.getSporris(session, ueao);
		
		request.setAttribute("sporris", sporris);
		request.getRequestDispatcher("WEB-INF/jsp/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
//		User user;
//		user = DataLoader.getUser(session, ueao);
		Sporris sporris;
		sporris = DataLoader.getSporris(session, ueao);
		
		QuestionHelper.saveNewQuestions(ueao, sporris, request);
		

		request.setAttribute("sporris", sporris);
		response.sendRedirect(EDITURL);
	}
	


}

package no.hib.dat104.project.controller;

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
import no.hib.dat104.project.helpers.ResponseParser;
import no.hib.dat104.project.javabeans.SporrisSubmitJavaBean;
import no.hib.dat104.project.model.Response;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;


@WebServlet("/" + SPORRISURL)
public class SporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserEAO ueao;
	int userId;
	int sporrisId;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		
//		User user;
//		user = DataLoader.getUser(session, ueao);
		Sporris sporris;
		sporris = DataLoader.getSporris(session, ueao);
		request.setAttribute("sporris", sporris);
		
//		request.setAttribute("url", SPORRISURL);

		request.getRequestDispatcher("WEB-INF/jsp/sporris.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();  
		
		User user;
		user = DataLoader.getUser(session, ueao);
		Sporris sporris;
		sporris = DataLoader.getSporris(session, ueao);
		
		Response r = ResponseParser.parseRequest(sporris, request);
		// DEBUG
		System.out.println(r.getResponse_text());
		
		SporrisSubmitJavaBean ssjb = new SporrisSubmitJavaBean(r, sporris);
		if (ssjb.isValid()) {
			sporris.addResponse(r);
			ueao.updateUser(user);
			session.setAttribute("ssjb", null);
			// DEBUG
			System.out.println("response deemed valid");
		} else {
			session.setAttribute("ssjb", ssjb);
		}
		
		
//		doGet(request, response);
		response.sendRedirect(SPORRISURL); 
	}

}

package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.SPORRISURL;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.helpers.ResponseParser;
import no.hib.dat104.project.model.Response;
import no.hib.dat104.project.model.Result;
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
		User user;
		Sporris sporris;
		HttpSession session = request.getSession(); 
		
		// TODO sync w/ overview
		if (session.getAttribute("userId") == null || session.getAttribute("sporrisId") == null) {
			session.setAttribute("sporrisId", 100);
			session.setAttribute("userId", 100);
		}
		userId = (Integer) session.getAttribute("userId");
		sporrisId = (Integer) session.getAttribute("sporrisId");
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
		}
		sporris = user.getSporris(sporrisId);
		request.setAttribute("sporris", sporris);
		request.setAttribute("url", SPORRISURL);

		request.getRequestDispatcher("WEB-INF/jsp/sporris.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		Sporris sporris;
		HttpSession session = request.getSession(); 
		
		// TODO sync w/ overview
		if (session.getAttribute("userId") == null || session.getAttribute("sporrisId") == null) {
			session.setAttribute("sporrisId", 100);
			session.setAttribute("userId", 100);
		}
		userId = (Integer) session.getAttribute("userId");
		sporrisId = (Integer) session.getAttribute("sporrisId");
		if(session.getAttribute("user") == null || session.getAttribute("user").getClass().equals(User.class)) {
			user = ueao.findUserCascade(userId);
			session.setAttribute("user", user);			
		} else {
			user = (User) session.getAttribute("user");
			user = ueao.findUserCascade(user.getUid());
		}
		sporris = user.getSporris(sporrisId);
		
		
		if (sporris.getResults() == null || sporris.getResults().size() == 0) {
			sporris.setResults(new ArrayList<Result>());
			sporris.getResults().add(new Result(sporris));
		}
		Response r = ResponseParser.parseRequest(sporris, sporris.getResults().get(0).getRid(), request);
		sporris.getResults().get(0).addResponse(r);
		
		System.out.println(r.getResponse_text());
		
		ueao.updateUser(user);
		doGet(request, response);
	}

}

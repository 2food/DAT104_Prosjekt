package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.LOGINURL;
import static no.hib.dat104.project.controller.UrlMappings.OVERSIKTURL;
import static no.hib.dat104.project.controller.UrlMappings.*;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.model.SporrisEAO;

@WebServlet("/" + OVERSIKTURL)
public class OversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SporrisEAO sporrisEAO;
	

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
		
		

		HttpSession session = request.getSession();
		String sporrisId = request.getParameter("sporrisID");
		System.out.println("Fikk parameter sporrisID: " + sporrisId );
		int sporrisIDAsInt = Integer.parseInt(sporrisId);
		System.out.println("Konveterer parameter sporrisIDAsInt: " + sporrisIDAsInt );
		
		String buttonEdit = request.getParameter("activate");
		System.out.println("Dette er buttonEDIT: " + buttonEdit);
		String buttonDelete = request.getParameter("activate");
		System.out.println("Dette er deleteknappen: " + buttonDelete);
		String buttonActivate = request.getParameter("activate");
		System.out.println("Fikk parameter activate: " + buttonActivate);
		
		
		
		if(buttonEdit.equals("Rediger")){
			System.out.println("Vi er inne i edit nå");
			session.setAttribute("sporrisId", sporrisId);
			response.sendRedirect(EDITURL);
			
		}
		
		if(buttonDelete.equals("Slett")){
			System.out.println("utfører slett og redirekter til oversikturl");
				//sporrisEAO.removeSporris(sporrisIDAsInt);
				response.sendRedirect(OVERSIKTURL);
			}
			
		
		
		if(buttonActivate.equals("Aktiver")){
			System.out.println("knappen er trykket på");
			System.out.println(sporrisId);
			//sporrisEAO.activateSporris(sporrisIDAsInt);
			response.sendRedirect(OVERSIKTURL);
		}
		
	}

	}



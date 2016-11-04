package no.hib.dat104.project.controller;

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

import no.hib.dat104.project.model.Sporris;
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
		int sporrisIDAsInt = Integer.parseInt(sporrisId);
		String buttonEdit = request.getParameter("edit");
		String buttonDelete = request.getParameter("delete");
		String buttonActivate = request.getParameter("activate");
		
		
		
		if(buttonEdit.equals("edit")){
			
			session.setAttribute("sporrisId", sporrisId);
			request.getRequestDispatcher("WEB-INF/jsp.SporrisRediger").forward(request, response);
			
		}
		
		if(buttonDelete.equals("delete")){
				sporrisEAO.removeSporris(sporrisIDAsInt);
				response.sendRedirect(OVERSIKTURL);
			}
		
		if(buttonActivate.equals("activate")){
			sporrisEAO.activateSporris(sporrisIDAsInt);
			response.sendRedirect(OVERSIKTURL);
		}
		
	}

	}



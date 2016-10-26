package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.FINNSPORRISURL;
import static no.hib.dat104.project.controller.UrlMappings.SPORRISURL;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.SporrisEAO;

@WebServlet("/" + FINNSPORRISURL )
public class FinnSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/finnSporris.jsp").forward(request, response);
	}

	/*
	 * Sjekker om input tag er lik en tag som ligger i databasen for spørris. Hvis det finnes en match
	 * så redirectes bruker til Sporris.jsp ettersom vi henviser til SporrisServlet
	 * 
	 * @Author Bojar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SporrisEAO sporrisEAO = new SporrisEAO();
		List<Sporris> allSporris = sporrisEAO.allSporris();
		String tag = request.getParameter("tag");
		
		
		for(Sporris tagMatch : allSporris){
			if(!tag.equals(tagMatch)){
				response.sendRedirect(FINNSPORRISURL);
			}else{
				response.sendRedirect(SPORRISURL);
			}
		}
	}

}
package no.hib.dat104.project.controller;

import static no.hib.dat104.project.controller.UrlMappings.FINNSPORRISURL;
import static no.hib.dat104.project.controller.UrlMappings.SPORRISURL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.project.javabeans.FinnSporrisJavaBean;
import no.hib.dat104.project.model.Sporris;
import no.hib.dat104.project.model.SporrisEAO;

@WebServlet("/" + FINNSPORRISURL )
public class FinnSporrisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private SporrisEAO seao;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/finnSporris.jsp").forward(request, response);
	}

	/*
	 * Sjekker om input tag er lik en tag som ligger i databasen for sp�rris. Hvis det finnes en match
	 * s� redirectes bruker til Sporris.jsp ettersom vi henviser til SporrisServlet
	 * 
	 * @Author Bojar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//List<Sporris> allSporris = seao.allSporris();
		String tag = request.getParameter("tag");
		HttpSession session = request.getSession(true);
		session.setAttribute("tag", tag);
		Sporris sporris;
		FinnSporrisJavaBean finnInfo = new FinnSporrisJavaBean();
		
		if(seao.findSporrisByTag(tag)==null){
			finnInfo.setFeilmelding("Fant ingen sporris med tag " + tag);
			session.setAttribute("finnInfo", finnInfo);
			System.out.println(finnInfo.getFeilmelding());
			response.sendRedirect(FINNSPORRISURL);
			

		}else {
			sporris = seao.findSporrisByTag(tag);
			if (sporris.isActive()) {
				session.setAttribute("tag", tag);
				session.setAttribute("sporrisId", sporris.getSid());
				System.out.println("Setter tag i session hvis gyldig tag");
				response.sendRedirect(SPORRISURL);
			} else {
				finnInfo.setFeilmelding("Spørris med tag "+tag+" er ikke aktivert");
				session.setAttribute("finnInfo", finnInfo);
				System.out.println(finnInfo.getFeilmelding());
				response.sendRedirect(FINNSPORRISURL);
			}
			
		}
	}

}
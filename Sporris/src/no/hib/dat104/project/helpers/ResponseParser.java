package no.hib.dat104.project.helpers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Response;
import no.hib.dat104.project.model.Sporris;

public class ResponseParser {
	
	public static Response parseRequest(Sporris sporris, int resultId, HttpServletRequest request) {
		String r ="";
		List<String> aList;
		for (Question q : sporris.getQuestions()) {
			r += "q_" + q.getQid();
			
			if (request.getParameterValues("q_" + q.getQid()) != null) {
				aList = Arrays.asList(request.getParameterValues("q_" + q.getQid()));
				for (Alternative a : q.getAlternatives()) {
					if (aList.contains("a_" + a.getAid())) {
						r += "_a_" + a.getAid();
					}
				}
			}
			
			if (request.getParameter("q_" + q.getQid() + "_text") != null && ((String) request.getParameter("q_" + q.getQid() + "_text")).length() > 0) {
				r += "_" + request.getParameter("q_" + q.getQid() + "_text");
			}
			r += "|";
					
		}
		
		Response response = new Response();
		response.setResponse_result(sporris.getResults().get(resultId));
		response.setResponse_text(r);
		return response;
	}
	
}

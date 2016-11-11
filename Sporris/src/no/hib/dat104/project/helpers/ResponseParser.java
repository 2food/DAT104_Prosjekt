package no.hib.dat104.project.helpers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import no.hib.dat104.project.model.Alternative;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Response;
import no.hib.dat104.project.model.Sporris;

public class ResponseParser {
	static String Q_DELIM = "#";
	static String A_DELIM = "_";
	
	public static Response parseRequest(Sporris sporris, HttpServletRequest request) {
		String r ="";
		List<String> aList;
		for (Question q : sporris.getQuestions()) {
			r += "q" + q.getQid() + A_DELIM;
			
			if (request.getParameterValues("q" + A_DELIM + q.getQid()) != null) {
				aList = Arrays.asList(request.getParameterValues("q_" + q.getQid()));
				for (Alternative a : q.getAlternatives()) {
					if (aList.contains("a_" + a.getAid())) {
						r += "a" + a.getAid() + A_DELIM;
					}
				}
			}
			
			if (q.isAllow_text()) {
				r +=  "text" + A_DELIM;
				if (request.getParameter("q_" + q.getQid() + "_text") != null && ((String) request.getParameter("q_" + q.getQid() + "_text")).length() > 0) {
					r += request.getParameter("q_" + q.getQid() + "_text");
				}
			}
			r += Q_DELIM;
					
		}
		if (r.charAt(r.length()-1) == Q_DELIM.charAt(0)) r = r.substring(0, r.length()-1);
		
		Response response = new Response(r, sporris.getActiveResult());
		return response;
	}
	
	public static HashMap<String, Integer> countAlternatives(Response r) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] questions;
		if ( r.getResponse_text() != null) {
			questions = r.getResponse_text().split(Q_DELIM);
		} else {
			questions = new String[1];
			questions[0] = "";
		}
		for (String q : questions){
			System.out.println(q);
		}
		String key;
		Integer value;
		for (String q : questions){
			key = q.substring(0, q.indexOf(A_DELIM));
			if ( q.indexOf("text") >= 0) {
				value = q.length() - q.substring(0, q.indexOf("text")).replaceAll("a","").length();
			} else {
				value = q.length() - q.replaceAll("a","").length();
			}
			map.put(key, value);
		}
		return map;
	}
	
	public static HashMap<String, Boolean> checkText(Response r) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		String[] questions;
		if ( r.getResponse_text() != null) {
			questions = r.getResponse_text().split(Q_DELIM);
		} else {
			questions = new String[1];
			questions[0] = "";
		}
		String key;
		int textStart;
		for (String q : questions){
			key = q.substring(0, q.indexOf(A_DELIM));
			textStart = q.indexOf("text") + 5;
			map.put(key, q.length() > textStart);
		}
		return map;
	}
	
}

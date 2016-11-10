package no.hib.dat104.project.javabeans;

import java.util.HashMap;

import no.hib.dat104.project.helpers.ResponseParser;
import no.hib.dat104.project.model.Question;
import no.hib.dat104.project.model.Response;
import no.hib.dat104.project.model.Sporris;

public class SporrisSubmitJavaBean {

	static String TOO_FEW_ALTERNATIVES = "Du må velge et alternativ.";
	static String NO_TEXT_ANSWER = "Du må fylle inn tekstboksen.";
	
	private HashMap<String, String> errors;
	private boolean valid;
	
	public SporrisSubmitJavaBean(Response r, Sporris s) {		
		valid = false;
		errors = new HashMap<String, String>();
		int a;
		String key;
		HashMap<String, Integer> aCount = ResponseParser.countAlternatives(r);
		HashMap<String, Boolean> checkText = ResponseParser.checkText(r);
		for (Question q : s.getQuestions()){
			key = "q" + q.getQid();
			if (q.getAlternatives().size() > 0 && aCount.get(key) < 1) {
				errors.put(key, TOO_FEW_ALTERNATIVES);
			} else if (q.isAllow_text() && !checkText.get(key)){
				errors.put(key, TOO_FEW_ALTERNATIVES);				
			}
		}
		valid = errors.isEmpty();
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	

	
	
	

}

package no.hib.dat104.project.javabeans;
import javax.servlet.http.HttpServletRequest;

public class FinnSporrisJavaBean {
	private String feilmelding = "";
	String tag;
	private boolean funnet;
	

	public String getFeilmelding() {
		return feilmelding;
	}
	public void setFeilmelding(String feilmelding) {
		this.feilmelding = feilmelding;
	}
	public boolean isFunnet() {
		return funnet;
	}
	public void setFunnet(boolean funnet) {
		this.funnet = funnet;
	}
	
}

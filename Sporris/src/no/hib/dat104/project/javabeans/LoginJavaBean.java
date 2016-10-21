package no.hib.dat104.project.javabeans;

import java.io.Serializable;

/*
 * JavaBean for logininfo. 
 * @author Tormod
 */
public class LoginJavaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean validUsername;
	private boolean validPassword;
	
	public LoginJavaBean() {
		this(null, null, true, true);
	}

	public LoginJavaBean(String username, String password, boolean validUsername, boolean validPassword) {
		this.username = username;
		this.password = password;
		this.validUsername = validUsername;
		this.validPassword = validPassword;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidUsername() {
		return validUsername;
	}

	public void setValidUsername(boolean validUsername) {
		this.validUsername = validUsername;
	}

	public boolean isValidPassword() {
		return validPassword;
	}

	public void setValidPassword(boolean validPassword) {
		this.validPassword = validPassword;
	}
}

package no.hib.dat104.project.javabeans;

/*
 * JavaBean for registrerInfo
 * @author Vegard
 */
public class RegistrerJavaBean {

	private String username;
	private String userpassword1;
	private String userpassword2;
	private boolean validUsername;
	private boolean usernameExists;
	private boolean passwordsMatches;

	public RegistrerJavaBean() {
		this(null, null, null, true, false, true);
	}

	public RegistrerJavaBean(String username, String userpassword1, String userpassword2, boolean validUsername,
			boolean usernameExists, boolean passwordsMatches) {
		this.username = username;
		this.userpassword1 = userpassword1;
		this.userpassword2 = userpassword2;
		this.validUsername = validUsername;
		this.usernameExists = usernameExists;
		this.passwordsMatches = passwordsMatches;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword1() {
		return userpassword1;
	}

	public void setUserpassword1(String userpassword1) {
		this.userpassword1 = userpassword1;
	}

	public String getUserpassword2() {
		return userpassword2;
	}

	public void setUserpassword2(String userpassword2) {
		this.userpassword2 = userpassword2;
	}

	public boolean isValidUsername() {
		return validUsername;
	}

	public void setValidUsername(boolean validUsername) {
		this.validUsername = validUsername;
	}

	public boolean isUsernameExists() {
		return usernameExists;
	}

	public void setUsernameExists(boolean usernameExists) {
		this.usernameExists = usernameExists;
	}

	public boolean isPasswordsMatches() {
		return passwordsMatches;
	}

	public void setPasswordsMatches(boolean passwordsMatches) {
		this.passwordsMatches = passwordsMatches;
	}


}

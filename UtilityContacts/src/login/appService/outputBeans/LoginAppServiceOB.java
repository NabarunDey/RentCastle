package login.appService.outputBeans;

public class LoginAppServiceOB {
	
	boolean userExists;
	boolean credentialMatch;
	public boolean isUserExists() {
		return userExists;
	}
	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}
	public boolean isCredentialMatch() {
		return credentialMatch;
	}
	public void setCredentialMatch(boolean credentialMatch) {
		this.credentialMatch = credentialMatch;
	}
	

}

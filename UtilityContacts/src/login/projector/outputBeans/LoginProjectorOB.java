package login.projector.outputBeans;

public class LoginProjectorOB {
	private boolean userNotExist;
	private boolean invalidCredentials;
	private boolean loginFailure;
	
	
	
	public boolean isLoginFailure() {
		return loginFailure;
	}
	public void setLoginFailure(boolean loginFailure) {
		this.loginFailure = loginFailure;
	}
	public boolean isUserNotExist() {
		return userNotExist;
	}
	public void setUserNotExist(boolean userNotExist) {
		this.userNotExist = userNotExist;
	}
	public boolean isInvalidCredentials() {
		return invalidCredentials;
	}
	public void setInvalidCredentials(boolean invalidCredentials) {
		this.invalidCredentials = invalidCredentials;
	}
	
	
	

}

package login.projector.outputBeans;

import com.sessionBeans.UserProfile;

public class LoginProjectorOB {
	private boolean userNotExist;
	private boolean invalidCredentials;
	private boolean loginFailure;
	private UserProfile userProfile;

	private boolean mailSent;
	
	
	
	public boolean isMailSent() {
		return mailSent;
	}
	public void setMailSent(boolean mailSent) {
		this.mailSent = mailSent;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
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

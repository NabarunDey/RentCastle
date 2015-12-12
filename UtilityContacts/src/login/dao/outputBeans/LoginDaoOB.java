package login.dao.outputBeans;

import java.util.List;

import com.databaseBeans.UserLoginDBBean;

public class LoginDaoOB {
	
	private List<UserLoginDBBean> userLoginDBBeans;
	private boolean userExists;
	private boolean credentialMatch;

	public List<UserLoginDBBean> getUserLoginDBBeans() {
		return userLoginDBBeans;
	}

	public void setUserLoginDBBeans(List<UserLoginDBBean> userLoginDBBeans) {
		this.userLoginDBBeans = userLoginDBBeans;
	}
	

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

package login.dao.outputBeans;

import java.util.List;

import com.databaseBeans.UserLoginDBBean;

public class LoginDaoOB {
	
	private List<UserLoginDBBean> userLoginDBBeans;

	private String userNameEntered;
	private String passwordEntered;
	
	

	public String getUserNameEntered() {
		return userNameEntered;
	}

	public void setUserNameEntered(String userNameEntered) {
		this.userNameEntered = userNameEntered;
	}

	public String getPasswordEntered() {
		return passwordEntered;
	}

	public void setPasswordEntered(String passwordEntered) {
		this.passwordEntered = passwordEntered;
	}

	public List<UserLoginDBBean> getUserLoginDBBeans() {
		return userLoginDBBeans;
	}

	public void setUserLoginDBBeans(List<UserLoginDBBean> userLoginDBBeans) {
		this.userLoginDBBeans = userLoginDBBeans;
	}
	

}

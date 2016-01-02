package login.dao.outputBeans;

import java.util.List;

import com.databaseBeans.UserLoginDBBean;
import com.databaseBeans.UsersDBBean;

public class LoginDaoOB {
	
	private List<UserLoginDBBean> userLoginDBBeans;
	private UsersDBBean usersDBBean;

	private String userNameEntered;
	private String passwordEntered;
	
	
	

	public UsersDBBean getUsersDBBean() {
		return usersDBBean;
	}

	public void setUsersDBBean(UsersDBBean usersDBBean) {
		this.usersDBBean = usersDBBean;
	}

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

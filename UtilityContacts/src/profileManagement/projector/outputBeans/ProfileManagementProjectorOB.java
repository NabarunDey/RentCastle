package profileManagement.projector.outputBeans;

import com.databaseBeans.UserLoginDBBean;
import com.databaseBeans.UsersDBBean;

public class ProfileManagementProjectorOB {
	
	private boolean dataUpdated;
	private UsersDBBean usersDBBean;
	private UserLoginDBBean userLoginDBBean;
	
	
	public UserLoginDBBean getUserLoginDBBean() {
		return userLoginDBBean;
	}

	public void setUserLoginDBBean(UserLoginDBBean userLoginDBBean) {
		this.userLoginDBBean = userLoginDBBean;
	}

	public UsersDBBean getUsersDBBean() {
		return usersDBBean;
	}

	public void setUsersDBBean(UsersDBBean usersDBBean) {
		this.usersDBBean = usersDBBean;
	}

	public boolean isDataUpdated() {
		return dataUpdated;
	}

	public void setDataUpdated(boolean dataUpdated) {
		this.dataUpdated = dataUpdated;
	}
	
}

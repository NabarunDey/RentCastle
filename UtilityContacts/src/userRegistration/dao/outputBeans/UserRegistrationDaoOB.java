package userRegistration.dao.outputBeans;

import com.databaseBeans.UsersDBBean;

public class UserRegistrationDaoOB {
	
	private boolean userDetailsInserted;
	private UsersDBBean usersDBBean;
	
	
	public UsersDBBean getUsersDBBean() {
		return usersDBBean;
	}

	public void setUsersDBBean(UsersDBBean usersDBBean) {
		this.usersDBBean = usersDBBean;
	}

	public boolean isUserDetailsInserted() {
		return userDetailsInserted;
	}

	public void setUserDetailsInserted(boolean userDetailsInserted) {
		this.userDetailsInserted = userDetailsInserted;
	}

	
}

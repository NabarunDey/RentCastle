package profileManagement.projector.outputBeans;

import com.databaseBeans.UsersDBBean;

public class ProfileManagementProjectorOB {
	
	private boolean dataUpdated;
	private UsersDBBean usersDBBean;
	
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

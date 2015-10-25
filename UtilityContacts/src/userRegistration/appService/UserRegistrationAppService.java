package userRegistration.appService;

import userRegistration.dao.outputBeans.UserRegistrationDaoOB;

public class UserRegistrationAppService {
	
	public UserRegistrationDaoOB userRegistrationDaoOB;

	//public 
	
	public UserRegistrationDaoOB getUserRegistrationDaoOB() {
		return userRegistrationDaoOB;
	}

	public void setUserRegistrationDaoOB(UserRegistrationDaoOB userRegistrationDaoOB) {
		this.userRegistrationDaoOB = userRegistrationDaoOB;
	}
	

}

package userRegistration;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

public class UserRegistrationAppContext {

	private UserRegistrationAppServiceIB userRegistrationAppServiceIB;

	public UserRegistrationAppServiceIB getUserRegistrationAppServiceIB() {
		return userRegistrationAppServiceIB;
	}

	public void setUserRegistrationAppServiceIB(
			UserRegistrationAppServiceIB userRegistrationAppServiceIB) {
		this.userRegistrationAppServiceIB = userRegistrationAppServiceIB;
	}
	
	
}

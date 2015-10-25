package userRegistration.action;

import userRegistration.appService.UserRegistrationAppService;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

public class UserRegistrationAction {

	public UserRegistrationAppService userRegistrationAppService;
	
	public String execute()
	{
		UserRegistrationAppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();
		return "SUCCESS";
	}

	public UserRegistrationAppService getUserRegistrationAppService() {
		return userRegistrationAppService;
	}

	public void setUserRegistrationAppService(
			UserRegistrationAppService userRegistrationAppService) {
		this.userRegistrationAppService = userRegistrationAppService;
	}
	
}

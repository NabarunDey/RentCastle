package userRegistration.action;

import userRegistration.appService.UserRegistrationAppService;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

public class UserRegistrationAction {

	public UserRegistrationAppService userRegistrationAppService;
	
	public String userRegistrationInput()
	{
		UserRegistrationAppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();
		return "success";
	}
	
	public String userRegistraionConfirm()
	{
		
	}

	public UserRegistrationAppService getUserRegistrationAppService() {
		return userRegistrationAppService;
	}

	public void setUserRegistrationAppService(
			UserRegistrationAppService userRegistrationAppService) {
		this.userRegistrationAppService = userRegistrationAppService;
	}
	
}

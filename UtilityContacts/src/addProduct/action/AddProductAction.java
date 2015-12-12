package addProduct.action;

import userRegistration.appService.UserRegistrationAppService;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

public class AddProductAction {

	public UserRegistrationAppService userRegistrationAppService;
	
	public String execute()
	{
		Addp AppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();
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

package userRegistration.appService;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.UserRegistrationDao;
import userRegistration.projector.outputBeans.UserRegistrationProjectorOB;

public class UserRegistrationAppService {
	
	public UserRegistrationDao userRegistrationDao;

	
	public UserRegistrationProjectorOB addUser(UserRegistrationAppServiceIB userRegistrationAppServiceIB)
	{
		
	}


	public UserRegistrationDao getUserRegistrationDao() {
		return userRegistrationDao;
	}


	public void setUserRegistrationDao(UserRegistrationDao userRegistrationDao) {
		this.userRegistrationDao = userRegistrationDao;
	}

	
}

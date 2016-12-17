package userRegistration.projector;

import userRegistration.dao.outputBeans.UserRegistrationDaoOB;
import userRegistration.projector.outputBeans.UserRegistrationProjectorOB;

public class UserRegistrationProjector {
	
	public UserRegistrationProjectorOB addUser(UserRegistrationDaoOB userRegistrationDaoOB)
	{
		UserRegistrationProjectorOB userRegistrationProjectorOB = new UserRegistrationProjectorOB();
		return userRegistrationProjectorOB;
	}

}

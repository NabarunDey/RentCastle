package userRegistration.appService;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;
import userRegistration.projector.UserRegistrationProjector;
import userRegistration.projector.outputBeans.UserRegistrationProjectorOB;

import com.dao.UsersDao;
import com.databaseBeans.UsersDBBean;

	
public class UserRegistrationAppService {
	private UsersDao usersDao;
	private UserRegistrationProjector userRegistrationProjector;
	
	public UserRegistrationProjectorOB addUser(UserRegistrationAppServiceIB userRegistrationAppServiceIB)
	{
		UsersDBBean usersDBBean = usersDao.getUserDetails(userRegistrationAppServiceIB.getUsername());
		UserRegistrationDaoOB userRegistrationDaoOB= null;
		UserRegistrationProjectorOB registrationProjectorOB = null;
		
		if(null == usersDBBean)
		{
			userRegistrationDaoOB = usersDao.addUser(userRegistrationAppServiceIB);
			if( userRegistrationDaoOB.isContactInserted())
			{
				registrationProjectorOB= userRegistrationProjector.addUser(userRegistrationDaoOB);
			}
		}
		
		return registrationProjectorOB;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public UserRegistrationProjector getUserRegistrationProjector() {
		return userRegistrationProjector;
	}

	public void setUserRegistrationProjector(
			UserRegistrationProjector userRegistrationProjector) {
		this.userRegistrationProjector = userRegistrationProjector;
	}


	

	
}

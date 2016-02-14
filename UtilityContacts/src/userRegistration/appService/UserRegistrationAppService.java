package userRegistration.appService;

import login.dao.outputBeans.LoginDaoOB;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;
import userRegistration.projector.UserRegistrationProjector;
import userRegistration.projector.outputBeans.UserRegistrationProjectorOB;

import com.dao.LoginDao;
import com.dao.UsersDao;
import com.databaseBeans.UsersDBBean;

	
public class UserRegistrationAppService {
	private UsersDao usersDao;
	private LoginDao loginDao;
	private UserRegistrationProjector userRegistrationProjector;
	
	public UserRegistrationProjectorOB addUser(UserRegistrationAppServiceIB userRegistrationAppServiceIB)
	{
		UsersDBBean usersDBBean = usersDao.getUserDetails(userRegistrationAppServiceIB.getUsername());
		UserRegistrationDaoOB userRegistrationDaoOB= null;
		LoginDaoOB loginDaoOB= null;
		UserRegistrationProjectorOB registrationProjectorOB = null;
		
		if(null == usersDBBean)
		{
			loginDaoOB = loginDao.addUserLogin(userRegistrationAppServiceIB);
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

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	

	
}

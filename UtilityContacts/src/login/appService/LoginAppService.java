package login.appService;

import login.appService.inputBeans.LoginAppServiceIB;
import login.dao.outputBeans.LoginDaoOB;
import login.projector.LoginProjector;
import login.projector.outputBeans.LoginProjectorOB;

import com.dao.LoginDao;
import com.dao.UsersDao;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;


public class LoginAppService {
	
	LoginDao loginDao;
	UsersDao usersDao;
	LoginProjector loginProjector;
	UserProfile userProfile;
	
	public LoginProjectorOB login(LoginAppServiceIB loginAppServiceIB) {
		
		LoginDaoOB loginDaoOB =  loginDao.getByUsername(loginAppServiceIB.getUsername());
		loginDaoOB.setUserNameEntered(loginAppServiceIB.getUsername());
		loginDaoOB.setPasswordEntered(loginAppServiceIB.getPassword());
		LoginProjectorOB loginProjectorOB = loginProjector.validateCredentials(loginDaoOB);
		
		if(!loginProjectorOB.isInvalidCredentials())
		{
			UsersDBBean usersDBBean = usersDao.getUserDetails(loginAppServiceIB);
			userProfile.setFirstName(usersDBBean.getFirstname());
			userProfile.setUserName(usersDBBean.getUsername());
			userProfile.setUserType(usersDBBean.getUsertype());
		}
		else
		{
			
		}
		return loginProjectorOB;
	}


	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public LoginProjector getLoginProjector() {
		return loginProjector;
	}

	public void setLoginProjector(LoginProjector loginProjector) {
		this.loginProjector = loginProjector;
	}


	public UsersDao getUsersDao() {
		return usersDao;
	}


	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}	

	
	
}

package profileManagement.appService;

import profileManagement.appService.inputBeans.ProfileManagementAppServiceIB;
import profileManagement.dao.outputBeans.ProfileManagementDaoOB;
import profileManagement.projector.outputBeans.ProfileManagementProjectorOB;

import com.dao.LoginDao;
import com.dao.UsersDao;
import com.databaseBeans.UserLoginDBBean;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;

	
public class ProfileManagementAppService {
	private UsersDao usersDao;
	private LoginDao loginDao;
	UserProfile userProfile ;
	
	public ProfileManagementProjectorOB editUser(ProfileManagementAppServiceIB profileManagementAppServiceIB)
	{
		ProfileManagementDaoOB profileManagementDaoOB= null;
		ProfileManagementProjectorOB profileManagementProjectorOB = new ProfileManagementProjectorOB();
		profileManagementAppServiceIB.setUsername(userProfile.getUserName());
		profileManagementDaoOB = usersDao.editUser(profileManagementAppServiceIB);
		if( profileManagementDaoOB.isUserDetailsInserted())
		{
			userProfile.setFirstName(profileManagementAppServiceIB.getFirstname());
			userProfile.setUserName(profileManagementAppServiceIB.getUsername());
			profileManagementProjectorOB.setDataUpdated(true);
		}
		
		return profileManagementProjectorOB;
	}
	
	public ProfileManagementProjectorOB getUserData()
	{
		UsersDBBean usersDBBean = usersDao.getUserDetails(userProfile.getUserName());
		UserLoginDBBean userLoginDBBean = loginDao.getByUsername(userProfile.getUserName()).getUserLoginDBBean();
		ProfileManagementProjectorOB profileManagementProjectorOB =new ProfileManagementProjectorOB();
		profileManagementProjectorOB.setUsersDBBean(usersDBBean);
		profileManagementProjectorOB.setUserLoginDBBean(userLoginDBBean);

		return profileManagementProjectorOB;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}

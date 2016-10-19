package login.appService;

import org.apache.commons.lang3.StringUtils;

import login.appService.inputBeans.LoginAppServiceIB;
import login.dao.outputBeans.LoginDaoOB;
import login.projector.LoginProjector;
import login.projector.outputBeans.LoginProjectorOB;
import userRegistration.appService.UserRegistrationAppService;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

import com.dao.LoginDao;
import com.dao.UsersDao;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;
import com.util.FacebookHandler;
import com.util.GoogleHandler;
import com.util.MailHandler;


public class LoginAppService {

	LoginDao loginDao;
	UsersDao usersDao;
	LoginProjector loginProjector;
	UserProfile userProfile;
	UserRegistrationAppService userRegistrationAppService;

	public LoginProjectorOB login(LoginAppServiceIB loginAppServiceIB,String server) {

		LoginProjectorOB loginProjectorOB=null;
		UsersDBBean usersDBBean = null;
		if(StringUtils.isNotEmpty(loginAppServiceIB.getFbCode()))
		{
			UserRegistrationAppServiceIB userRegistrationAppServiceIB = FacebookHandler.getfbData(loginAppServiceIB.getFbCode(),server);
			LoginDaoOB loginDaoOB =  loginDao.getByUsername(userRegistrationAppServiceIB.getUsername());
			if(null== loginDaoOB.getUserLoginDBBean())
			{
				userRegistrationAppService.addUser(userRegistrationAppServiceIB);
			}
			loginProjectorOB =new LoginProjectorOB();
			loginAppServiceIB.setUsername(userRegistrationAppServiceIB.getUsername());
		}

		else if(StringUtils.isNotEmpty(loginAppServiceIB.getGoogleCode()))
		{
			UserRegistrationAppServiceIB userRegistrationAppServiceIB=  GoogleHandler.getGoogleData(loginAppServiceIB.getGoogleCode(), server);
			LoginDaoOB loginDaoOB =  loginDao.getByUsername(userRegistrationAppServiceIB.getUsername());
			if(null== loginDaoOB.getUserLoginDBBean())
			{
				userRegistrationAppService.addUser(userRegistrationAppServiceIB);
			}
			loginProjectorOB =new LoginProjectorOB();
			loginAppServiceIB.setUsername(userRegistrationAppServiceIB.getUsername());
		}

		else{
			LoginDaoOB loginDaoOB =  loginDao.getByUsername(loginAppServiceIB.getUsername());
			loginDaoOB.setUserNameEntered(loginAppServiceIB.getUsername());
			loginDaoOB.setPasswordEntered(loginAppServiceIB.getPassword());

			if(null==loginDaoOB.getUserLoginDBBean())
			{
				usersDBBean = usersDao.getUserDetailsByEmail(loginAppServiceIB.getUsername());
				if(null!= usersDBBean)
				{
					loginDaoOB =  loginDao.getByUsername(usersDBBean.getUsername());
					loginDaoOB.setUserNameEntered(usersDBBean.getUsername());
					loginDaoOB.setPasswordEntered(loginAppServiceIB.getPassword());

				}
			}
			loginProjectorOB = loginProjector.validateCredentials(loginDaoOB);
			if(null==loginDaoOB.getUserLoginDBBean())
			{
				loginProjectorOB.setUserNotExist(true);
			}
		}
		if(!loginProjectorOB.isInvalidCredentials())
		{
			if(null== usersDBBean)
				usersDBBean = usersDao.getUserDetails(loginAppServiceIB.getUsername());
			userProfile.setFirstName(usersDBBean.getFirstname());
			userProfile.setUserName(usersDBBean.getUsername());
			userProfile.setUserType(usersDBBean.getUsertype());
			userProfile.setPin(usersDBBean.getPinno());
			userProfile.setEmail(usersDBBean.getEmail());

			loginProjectorOB.setUserProfile(userProfile);
		}

		return loginProjectorOB;
	}

	public LoginProjectorOB retrievePassword(LoginAppServiceIB loginAppServiceIB)
	{
		LoginProjectorOB loginProjectorOB= new LoginProjectorOB();
		loginProjectorOB.setUserNotExist(true);
		LoginDaoOB loginDaoOB =  loginDao.getByUsername(loginAppServiceIB.getUsername());
		UsersDBBean usersDBBean=usersDao.getUserDetails(loginAppServiceIB.getUsername());
		
		if(null==loginDaoOB.getUserLoginDBBean())
		{
			usersDBBean = usersDao.getUserDetailsByEmail(loginAppServiceIB.getUsername());
			if(null!= usersDBBean)
			{
				loginDaoOB =  loginDao.getByUsername(usersDBBean.getUsername());
			}
		}
		
		if(null!= loginDaoOB && null!= loginDaoOB.getUserLoginDBBean() && StringUtils.isNotEmpty(loginDaoOB.getUserLoginDBBean().getUsername()))
		{
			loginProjectorOB.setUserNotExist(false);
			String password = loginDao.resetPassword(loginDaoOB.getUserLoginDBBean().getUsername());
			boolean result = MailHandler.passwordResetMail(usersDBBean.getEmail(), password);
			loginProjectorOB.setMailSent(result);
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


	public UserRegistrationAppService getUserRegistrationAppService() {
		return userRegistrationAppService;
	}


	public void setUserRegistrationAppService(
			UserRegistrationAppService userRegistrationAppService) {
		this.userRegistrationAppService = userRegistrationAppService;
	}	



}

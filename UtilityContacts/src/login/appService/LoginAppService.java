package login.appService;

import java.util.List;

import login.appService.inputBeans.LoginAppServiceIB;
import login.dao.LoginDao;
import login.dao.outputBeans.LoginDaoOB;
import login.projector.LoginProjector;
import login.projector.outputBeans.LoginProjectorOB;

import org.apache.commons.lang3.StringUtils;

import com.databaseBeans.UserLoginDBBean;


public class LoginAppService {
	
	private LoginDao loginDao;
	private LoginProjector loginProjector;
	
	
	public LoginProjectorOB login(LoginAppServiceIB loginAppServiceIB) {
		
		LoginDaoOB loginDaoOB =  loginDao.getAllUserLogin();

		List<UserLoginDBBean> userLoginDBBeans = loginDaoOB.getUserLoginDBBeans();

		if( null!= userLoginDBBeans && null != loginAppServiceIB 
				&& StringUtils.isNotEmpty(loginAppServiceIB.getUsername()) && StringUtils.isNotEmpty(loginAppServiceIB.getPassword()))
		{
			if(checkIfUserExists(userLoginDBBeans, loginAppServiceIB))
			{
				loginDaoOB.setUserExists(true);
				if(checkCredential(userLoginDBBeans, loginAppServiceIB))
				{
					loginDaoOB.setCredentialMatch(true);
				}
			}
		}
		
		LoginProjectorOB loginProjectorOB = loginProjector.getConfirmationScreen(loginDaoOB);
		return loginProjectorOB;
	}

	private boolean checkIfUserExists(List<UserLoginDBBean> userLoginDBBeans, LoginAppServiceIB loginAppServiceIB)
	{
		for(UserLoginDBBean userLoginDBBean : userLoginDBBeans)
		{
			if((loginAppServiceIB.getUsername()).equals(userLoginDBBean.getUsername()))
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkCredential(List<UserLoginDBBean> userLoginDBBeans, LoginAppServiceIB loginAppServiceIB)
	{
		for (UserLoginDBBean userLoginDBBean :userLoginDBBeans)
		{
			if(loginAppServiceIB.getUsername().equals(userLoginDBBean.getUsername())
					&& loginAppServiceIB.getPassword().equals(userLoginDBBean.getPassword()))
			{
				return true;
			}
		}
		return false;
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

	
}

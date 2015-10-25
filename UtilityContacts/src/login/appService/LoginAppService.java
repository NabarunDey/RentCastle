package login.appService;

import java.util.List;

import login.appService.inputBeans.LoginAppServiceIB;
import login.appService.outputBeans.LoginAppServiceOB;
import login.dao.LoginDao;
import login.dao.databaseBeans.UserLoginDBBean;

import org.apache.commons.lang3.StringUtils;


public class LoginAppService {
	
	public LoginDao loginDao;
	
	public LoginAppServiceOB login(LoginAppServiceIB loginAppServiceIB) {

		LoginAppServiceOB loginAppServiceOB = new LoginAppServiceOB();
		List<UserLoginDBBean> userLoginDBBeans =loginDao.getAllUserLogin();

		if( null!= userLoginDBBeans && null != loginAppServiceIB 
				&& StringUtils.isNotEmpty(loginAppServiceIB.getUsername()) && StringUtils.isNotEmpty(loginAppServiceIB.getPassword()))
		{
			if(checkIfUserExists(userLoginDBBeans, loginAppServiceIB))
			{
				loginAppServiceOB.setUserExists(true);
				if(checkCredential(userLoginDBBeans, loginAppServiceIB))
				{
					loginAppServiceOB.setCredentialMatch(true);
					
				}

			}
		}
		return loginAppServiceOB;
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

}

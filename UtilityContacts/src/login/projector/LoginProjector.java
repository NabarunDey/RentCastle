package login.projector;

import login.dao.outputBeans.LoginDaoOB;
import login.projector.outputBeans.LoginProjectorOB;

import org.apache.commons.lang3.StringUtils;

import com.databaseBeans.UserLoginDBBean;

public class LoginProjector {
	

	public LoginProjectorOB getInputScreen(LoginDaoOB loginDaoOB)
	{
		LoginProjectorOB loginProjectorOB =new LoginProjectorOB();
		return loginProjectorOB;
	}

	public LoginProjectorOB validateCredentials(LoginDaoOB loginDaoOB)
	{
		LoginProjectorOB loginProjectorOB =new LoginProjectorOB();
		loginProjectorOB.setInvalidCredentials(true);
		UserLoginDBBean userLoginDBBean = loginDaoOB.getUserLoginDBBean();

		if( null!= userLoginDBBean && null != loginDaoOB 
				&& StringUtils.isNotEmpty(loginDaoOB.getUserNameEntered()) && StringUtils.isNotEmpty(loginDaoOB.getPasswordEntered()))
		{

				if((loginDaoOB.getUserNameEntered()).equals(userLoginDBBean.getUsername()))
				{
					loginProjectorOB.setUserNotExist(false);
					if(!loginProjectorOB.isUserNotExist())
					{
						if(loginDaoOB.getPasswordEntered().equals(userLoginDBBean.getPassword()))
						{
							loginProjectorOB.setInvalidCredentials(false);;
						}
					}
				}
			}

		return loginProjectorOB;
	}
	
}

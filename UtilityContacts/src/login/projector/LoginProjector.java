package login.projector;

import java.util.List;

import login.dao.outputBeans.LoginDaoOB;
import login.projector.outputBeans.LoginProjectorOB;

import org.apache.commons.lang3.StringUtils;

import com.databaseBeans.UserLoginDBBean;
import com.sessionBeans.UserProfile;

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
		loginProjectorOB.setUserNotExist(true);
		List<UserLoginDBBean> userLoginDBBeans = loginDaoOB.getUserLoginDBBeans();

		if( null!= userLoginDBBeans && null != loginDaoOB 
				&& StringUtils.isNotEmpty(loginDaoOB.getUserNameEntered()) && StringUtils.isNotEmpty(loginDaoOB.getPasswordEntered()))
		{

			for(UserLoginDBBean userLoginDBBean : userLoginDBBeans)
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
						break;
					}
				}
			}
		}

		return loginProjectorOB;
	}
	
}

package login.projector;

import login.dao.outputBeans.LoginDaoOB;
import login.projector.outputBeans.LoginProjectorOB;

public class LoginProjector {
	
	public LoginProjectorOB getInputScreen(LoginDaoOB loginDaoOB)
	{
		LoginProjectorOB loginProjectorOB =new LoginProjectorOB();
		return loginProjectorOB;
	}
	
	public LoginProjectorOB getConfirmationScreen(LoginDaoOB loginDaoOB)
	{
		LoginProjectorOB loginProjectorOB =new LoginProjectorOB();
		return loginProjectorOB;
	}

}

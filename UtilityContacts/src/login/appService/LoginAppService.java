package login.appService;

import login.appService.inputBeans.LoginAppServiceIB;
import login.dao.outputBeans.LoginDaoOB;
import login.projector.LoginProjector;
import login.projector.outputBeans.LoginProjectorOB;

import com.dao.LoginDao;


public class LoginAppService {
	
	private LoginDao loginDao;
	private LoginProjector loginProjector;
	
	
	public LoginProjectorOB login(LoginAppServiceIB loginAppServiceIB) {
		
		LoginDaoOB loginDaoOB =  loginDao.getAllUserLogin();

		LoginProjectorOB loginProjectorOB = loginProjector.getConfirmationScreen(loginDaoOB);
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

	
}

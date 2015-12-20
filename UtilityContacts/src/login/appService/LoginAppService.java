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

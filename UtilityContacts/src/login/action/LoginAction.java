package login.action;

import login.appService.LoginAppService;
import login.appService.inputBeans.LoginAppServiceIB;

import com.appService.UserFunctionsAppService;
import com.appService.inputBean.UserFunctionsAppSrvcIB;



public class LoginAction {
	
	String username;
	String password;
	LoginAppService loginAppService; 
	
	
	public String loginFunction()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		loginAppServiceIB.setPassword(password);
		
		loginAppService.login(loginAppServiceIB);
		
		return "success";		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginAppService getLoginAppService() {
		return loginAppService;
	}

	public void setLoginAppService(LoginAppService loginAppService) {
		this.loginAppService = loginAppService;
	}
	
}

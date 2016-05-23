package login.action;

import com.opensymphony.xwork2.ActionSupport;

import login.LoginAppContext;
import login.appService.LoginAppService;
import login.appService.inputBeans.LoginAppServiceIB;
import login.projector.outputBeans.LoginProjectorOB;



public class LoginAction  extends ActionSupport {
	
	String username;
	String password;
	LoginAppService loginAppService; 
	LoginAppContext context;
	
	
	public String loginInput()
	{
		return "success";
	}
	
	public String loginFunction()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		loginAppServiceIB.setPassword(password);
		
		LoginProjectorOB loginProjectorOB = loginAppService.login(loginAppServiceIB);
		context.setLoginProjectorOB(loginProjectorOB);
		return ActionSupport.SUCCESS;		
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

	public LoginAppContext getContext() {
		return context;
	}

	public void setContext(LoginAppContext context) {
		this.context = context;
	}
	
}

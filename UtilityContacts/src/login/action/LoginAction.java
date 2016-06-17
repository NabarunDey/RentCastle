package login.action;

import javax.servlet.http.HttpServletRequest;

import login.LoginAppContext;
import login.appService.LoginAppService;
import login.appService.inputBeans.LoginAppServiceIB;
import login.projector.outputBeans.LoginProjectorOB;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction  extends ActionSupport  implements ServletRequestAware{
	
	String username;
	String password;
	LoginAppService loginAppService; 
	LoginAppContext context;
	private HttpServletRequest httpServletRequest;
	
	
	public String loginFunction()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		loginAppServiceIB.setPassword(password);
		
		LoginProjectorOB loginProjectorOB = loginAppService.login(loginAppServiceIB);
		context.setLoginProjectorOB(loginProjectorOB);
		return ActionSupport.SUCCESS;		
	}
	
	public String logoutFunction()
	{
		httpServletRequest.getSession().invalidate();
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

	public LoginAppContext getContext() {
		return context;
	}

	public void setContext(LoginAppContext context) {
		this.context = context;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		 this.httpServletRequest = arg0;
		
	}
	
}

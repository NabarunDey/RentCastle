package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.LoginAppContext;
import login.appService.LoginAppService;
import login.appService.inputBeans.LoginAppServiceIB;
import login.projector.outputBeans.LoginProjectorOB;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction  extends ActionSupport  implements ServletRequestAware{
	
	String username;
	String password;
	LoginAppService loginAppService; 
	LoginAppContext context;
	private HttpServletRequest httpServletRequest;
	String code;
	
	public String loginFunction()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		loginAppServiceIB.setPassword(password);
		loginAppServiceIB.setFbCode(code);
		String server=httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath();
		
		String refererUrl = httpServletRequest.getHeader("referer");
		
		LoginProjectorOB loginProjectorOB = loginAppService.login(loginAppServiceIB,server,false);
		loginProjectorOB.setRefererUrl(refererUrl);
		context.setLoginProjectorOB(loginProjectorOB);
		if(loginProjectorOB.isLoginFailure())
			return "fail";
		if(StringUtils.isNotEmpty(code))
		{
			return "fbLoginSuccess";
		}
		return ActionSupport.SUCCESS;		
	}
	
	public String loginFunctionGoogle()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		loginAppServiceIB.setPassword(password);
		loginAppServiceIB.setGoogleCode(code);
		String server=httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath();
		
		LoginProjectorOB loginProjectorOB = loginAppService.login(loginAppServiceIB,server,false);
		context.setLoginProjectorOB(loginProjectorOB);
		return ActionSupport.SUCCESS;		
	}
	
	public String logoutFunction()
	{
		httpServletRequest.getSession().invalidate();
		return "success";
	}

	public String forgotPasswordInput()
	{
		return "success";
	}
	
	public String forgotPasswordSubmit()
	{
		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();
		loginAppServiceIB.setUsername(username);
		LoginProjectorOB loginProjectorOB = loginAppService.retrievePassword(loginAppServiceIB);
		context.setLoginProjectorOB(loginProjectorOB);
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}

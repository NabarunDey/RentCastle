package loadIndex.action;

import login.LoginAppContext;
import login.appService.LoginAppService;



public class LoadIndexAction {
	
	String username;
	String password;
	LoginAppService loginAppService; 
	LoginAppContext context;
	
	
	public String loadIndex()
	{
		return "success";
	}
	
	public LoginAppContext getContext() {
		return context;
	}

	public void setContext(LoginAppContext context) {
		this.context = context;
	}
	
}

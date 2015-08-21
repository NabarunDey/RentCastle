package com.action;

import com.appService.UserFunctionsAppService;
import com.appService.inputBean.UserFunctionsAppSrvcIB;



public class LoginAction {
	
	String username;
	String password;
	UserFunctionsAppService userFunctionsAppService; 
	
	
	public String loginFunction()
	{
		UserFunctionsAppSrvcIB userFunctionsAppSrvcIB = new UserFunctionsAppSrvcIB();
		userFunctionsAppSrvcIB.setUsername(username);
		userFunctionsAppSrvcIB.setPassword(password);
		
		userFunctionsAppService.login(userFunctionsAppSrvcIB);
		
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

	public UserFunctionsAppService getUserFunctionsAppService() {
		return userFunctionsAppService;
	}

	public void setUserFunctionsAppService(
			UserFunctionsAppService userFunctionsAppService) {
		this.userFunctionsAppService = userFunctionsAppService;
	}

	
}

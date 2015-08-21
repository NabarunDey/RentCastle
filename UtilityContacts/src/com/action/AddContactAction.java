package com.action;

import com.appService.UserFunctionsAppService;
import com.appService.inputBean.UserFunctionsAppSrvcIB;



public class AddContactAction {
	

	String name;
	String type;
	String location;
	String city;
	String state;
	String mobile;
	
	UserFunctionsAppService userFunctionsAppService; 
	
	
	public String loginFunction()
	{
		UserFunctionsAppSrvcIB userFunctionsAppSrvcIB = new UserFunctionsAppSrvcIB();
		/*userFunctionsAppSrvcIB.setUsername(username);
		userFunctionsAppSrvcIB.setPassword(password);*/
		
		userFunctionsAppService.login(userFunctionsAppSrvcIB);
		
		return "success";		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public UserFunctionsAppService getUserFunctionsAppService() {
		return userFunctionsAppService;
	}


	public void setUserFunctionsAppService(
			UserFunctionsAppService userFunctionsAppService) {
		this.userFunctionsAppService = userFunctionsAppService;
	}

	
}

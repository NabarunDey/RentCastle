package com.action;

import com.appService.ContactFunctionsAppService;
import com.appService.inputBean.ContactFunctionsAppSrvcIB;
import com.appService.outputBean.ContactFunctionsAppSrvcOB;



public class AddContactAction {
	

	String name;
	String type;
	String location;
	String city;
	String state;
	String mobile;
	
	ContactFunctionsAppService contactFunctionsAppService; 
	
	
	public String execute()
	{
		ContactFunctionsAppSrvcIB contactFunctionsAppSrvcIB = new  ContactFunctionsAppSrvcIB();
		contactFunctionsAppSrvcIB.setName(name);
		contactFunctionsAppSrvcIB.setCity(city);
		contactFunctionsAppSrvcIB.setLocation(location);
		contactFunctionsAppSrvcIB.setMobile(mobile);
		contactFunctionsAppSrvcIB.setState(state);
		contactFunctionsAppSrvcIB.setType(type);
		
		ContactFunctionsAppSrvcOB contactFunctionsAppSrvcOB= contactFunctionsAppService.addContact(contactFunctionsAppSrvcIB);
		
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


	public ContactFunctionsAppService getContactFunctionsAppService() {
		return contactFunctionsAppService;
	}


	public void setContactFunctionsAppService(
			ContactFunctionsAppService contactFunctionsAppService) {
		this.contactFunctionsAppService = contactFunctionsAppService;
	}

}

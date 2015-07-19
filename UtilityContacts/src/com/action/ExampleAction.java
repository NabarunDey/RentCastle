package com.action;


import com.dao.ExampleDao;

public class ExampleAction {
	
	ExampleDao exampleDao;
	String message;
	String firstName;
	String lastName;

	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExampleDao getExampleDao() {
		return exampleDao;
	}

	public void setExampleDao(ExampleDao exampleDao) {
		this.exampleDao = exampleDao;
	}
	
	public String exampleFunctionAction()
	{
		message=exampleDao.exampleFunctionDao();
		return "success";
	}
}

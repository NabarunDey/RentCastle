package com.structures.userTypes;

public enum UserType {

	VENDOR("Vendor"),
	CUSTOMER("Customer"),
	SERVICEPROVIDER("ServiceProvider"),
	ADMIN("Admin");

	private String text;

	private UserType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	
}

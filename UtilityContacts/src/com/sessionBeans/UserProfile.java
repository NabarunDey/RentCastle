package com.sessionBeans;

import com.structures.userTypes.UserType;

public class UserProfile {
	
	String firstName;
	UserType userType;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	

}

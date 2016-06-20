package com.sessionBeans;

import com.structures.userTypes.UserType;

public class UserProfile {
	
	private String firstName;
	private String userName;
	private UserType userType;
	private String numberOfItemsInCart;
	
	
	public String getNumberOfItemsInCart() {
		return numberOfItemsInCart;
	}
	public void setNumberOfItemsInCart(String numberOfItemsInCart) {
		this.numberOfItemsInCart = numberOfItemsInCart;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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

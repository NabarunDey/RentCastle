package com.sessionBeans;

import com.structures.userTypes.UserType;

public class UserProfile {
	
	private String firstName;
	private String userName;
	private UserType userType;
	private String numberOfItemsInCart;
	private String pin;
	private String email;
	private String mobile;
	private String password;
	private String mobiledevice;
	
	public String getMobiledevice() {
		return mobiledevice;
	}
	public void setMobiledevice(String mobiledevice) {
		this.mobiledevice = mobiledevice;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
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

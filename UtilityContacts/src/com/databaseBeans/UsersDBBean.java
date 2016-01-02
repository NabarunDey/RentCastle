package com.databaseBeans;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.structures.userTypes.UserType;

public class UsersDBBean {

	String username;
	String firstname;
	String lastname;
	String sex;
	UserType usertype;
	String address;
	String city;
	String state;
	String pinno;
	String phoneno;
	String mobileno1;
	String mobileno2;
	String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public UserType getUsertype() {
		return usertype;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPinno() {
		return pinno;
	}
	public void setPinno(String pinno) {
		this.pinno = pinno;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getMobileno1() {
		return mobileno1;
	}
	public void setMobileno1(String mobileno1) {
		this.mobileno1 = mobileno1;
	}
	public String getMobileno2() {
		return mobileno2;
	}
	public void setMobileno2(String mobileno2) {
		this.mobileno2 = mobileno2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
}

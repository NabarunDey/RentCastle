package com.appService.outputBean;

import java.util.ArrayList;

import com.databaseBeans.ContactsDBBean;

public class ContactFunctionsAppSrvcOB {
	
	String returnState;
	String messege;
	ArrayList<ContactsDBBean> contactList;
	
	
	public String getReturnState() {
		return returnState;
	}
	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public ArrayList<ContactsDBBean> getContactList() {
		return contactList;
	}
	public void setContactList(ArrayList<ContactsDBBean> contactList) {
		this.contactList = contactList;
	}
	
	

}

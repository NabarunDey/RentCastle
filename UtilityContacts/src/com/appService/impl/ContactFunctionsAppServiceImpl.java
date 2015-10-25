package com.appService.impl;

import java.awt.List;

import com.appService.ContactFunctionsAppService;
import com.appService.inputBean.ContactFunctionsAppSrvcIB;
import com.appService.outputBean.ContactFunctionsAppSrvcOB;
import com.dao.ContactFunctionsDao;
import com.dao.inputBean.ContactFunctionsDaoIB;
import com.dao.outputBean.ContactFunctionsDaoOB;
import com.util.CommonUtility;

public class ContactFunctionsAppServiceImpl implements ContactFunctionsAppService {
	
	ContactFunctionsDao contactFunctionsDao;

	@Override
	public ContactFunctionsAppSrvcOB addContact(
			ContactFunctionsAppSrvcIB contactFunctionsAppSrvcIB) {

		ContactFunctionsDaoIB contactFunctionsDaoIB =new ContactFunctionsDaoIB();
		CommonUtility.copyBean(contactFunctionsAppSrvcIB, contactFunctionsDaoIB);
		ContactFunctionsDaoOB contactFunctionsDaoOB = contactFunctionsDao.addContact(contactFunctionsDaoIB);
		ContactFunctionsAppSrvcOB contactFunctionsAppSrvcOB =new ContactFunctionsAppSrvcOB();
		
		return contactFunctionsAppSrvcOB;
	}
	

	@Override
	public ContactFunctionsAppSrvcOB viewAllContact() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public ContactFunctionsDao getContactFunctionsDao() {
		return contactFunctionsDao;
	}

	public void setContactFunctionsDao(ContactFunctionsDao contactFunctionsDao) {
		this.contactFunctionsDao = contactFunctionsDao;
	}





}

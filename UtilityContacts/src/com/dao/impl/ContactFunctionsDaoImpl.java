package com.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.ContactFunctionsDao;
import com.dao.inputBean.ContactFunctionsDaoIB;
import com.dao.outputBean.ContactFunctionsDaoOB;
import com.databaseBeans.ContactsDBBean;
import com.databaseBeans.UserLoginDBBean;
import com.util.CommonUtility;

public class ContactFunctionsDaoImpl implements ContactFunctionsDao {

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	public void saveContacts(ContactsDBBean e){  
	    template.save(e);  
	}  
	public void updateContacts(ContactsDBBean e){  
	    template.update(e);  
	}  
	public void deleteContacts(ContactsDBBean e){  
	    template.delete(e);  
	}  
	public ContactsDBBean getById(int id){  
		ContactsDBBean e=(ContactsDBBean)template.get(ContactsDBBean.class,id);  
	    return e;  
	}  
	
	
	@Override
	public ContactFunctionsDaoOB addContact(
			ContactFunctionsDaoIB contactFunctionsDaoIB) {

		ContactsDBBean contactsDBBean = new  ContactsDBBean();
		CommonUtility.copyBean(contactFunctionsDaoIB, contactsDBBean);
		
		
		saveContacts(contactsDBBean);
		ContactFunctionsDaoOB contactFunctionsDaoOB =new ContactFunctionsDaoOB();
		contactFunctionsDaoOB.setContactInserted(true);
		return contactFunctionsDaoOB;
	}

}

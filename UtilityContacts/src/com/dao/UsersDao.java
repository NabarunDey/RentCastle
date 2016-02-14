package com.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;

import com.databaseBeans.UsersDBBean;
import com.util.CommonUtility;

public class UsersDao {

	HibernateTemplate template;  
	public void saveUser(UsersDBBean usersDBBean){  
		template.save(usersDBBean);  
	}  
	public void updateUser(UsersDBBean usersDBBean){  
		template.update(usersDBBean);  
	}  
	public void deleteUser(UsersDBBean usersDBBean){  	
		template.delete(usersDBBean);  
	}  


	public UsersDBBean getUserDetails(String userName)
	{
		UsersDBBean usersDBBean = null;
		try{
			usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,userName);
		}catch(Exception exception)
		{

		}
		return usersDBBean;
	}

	public UserRegistrationDaoOB addUser(
			UserRegistrationAppServiceIB userRegistrationAppServiceIB) {

		UsersDBBean usersDBBean = new  UsersDBBean();
		CommonUtility.copyBean(userRegistrationAppServiceIB, usersDBBean);
		saveUser(usersDBBean);
		UserRegistrationDaoOB userRegistrationDaoOB =new UserRegistrationDaoOB();
		userRegistrationDaoOB.setContactInserted(true);
		return userRegistrationDaoOB;
	}



	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}



}

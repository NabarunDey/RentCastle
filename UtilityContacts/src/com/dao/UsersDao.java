package com.dao;

import login.appService.inputBeans.LoginAppServiceIB;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.databaseBeans.UsersDBBean;

public class UsersDao {

	HibernateTemplate template;  
	
	public UsersDBBean getUserDetails(LoginAppServiceIB loginAppServiceIB)
	{
		UsersDBBean usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,loginAppServiceIB.getUsername());
		
		return usersDBBean;
	}
	
	public UsersDBBean getById(int id){  
		UsersDBBean e=(UsersDBBean)template.get(UsersDBBean.class,id);  
	    return e;  
	}  

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
	
}

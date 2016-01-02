package com.dao;

import java.util.List;

import login.appService.inputBeans.LoginAppServiceIB;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.databaseBeans.UserLoginDBBean;
import com.databaseBeans.UsersDBBean;

public class UsersDao {

	HibernateTemplate template;  
	
	public UsersDBBean getUserDetails(LoginAppServiceIB loginAppServiceIB)
	{
		String sqlQuery= "from com.databaseBeans.UsersDBBean" ;//where username = ?";
		Object[] queryParam = {loginAppServiceIB.getUsername()};
		List<UsersDBBean> usersList= (List<UsersDBBean>) template.loadAll(UsersDBBean.class);//), loginAppServiceIB.getUsername());
		
		if(null!= usersList && usersList.size() ==1)
		{
			return usersList.get(0);
		}
		return null;
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

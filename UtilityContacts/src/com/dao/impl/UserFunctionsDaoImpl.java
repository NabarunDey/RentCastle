package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserFunctionsDao;
import com.databaseBeans.UserLoginDBBean;

public class UserFunctionsDaoImpl implements UserFunctionsDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	public void saveUserLogin(UserLoginDBBean e){  
	    template.save(e);  
	}  
	public void updateUserLogin(UserLoginDBBean e){  
	    template.update(e);  
	}  
	public void deleteUserLogin(UserLoginDBBean e){  
	    template.delete(e);  
	}  
	public UserLoginDBBean getById(int id){  
		UserLoginDBBean e=(UserLoginDBBean)template.get(UserLoginDBBean.class,id);  
	    return e;  
	}  

	
	public List<UserLoginDBBean> getAllUserLogin(){  
	    List<UserLoginDBBean> list; 
	    list=template.loadAll(UserLoginDBBean.class);  
	    return list;  
	}  

}

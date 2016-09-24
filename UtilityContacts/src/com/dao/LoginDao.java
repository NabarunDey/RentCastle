package com.dao;

import login.dao.outputBeans.LoginDaoOB;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

import com.databaseBeans.UserLoginDBBean;
import com.util.CommonUtility;

@Transactional
public class LoginDao {
	
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
	public LoginDaoOB getByUsername(String username){  
		
		UserLoginDBBean userLoginDBBean= null;
		try{
			userLoginDBBean = (UserLoginDBBean)template.get(UserLoginDBBean.class,username);  
		}catch(Exception exception)
		{
			
		}
		LoginDaoOB loginDaoOB =new  LoginDaoOB();
		loginDaoOB.setUserLoginDBBean(userLoginDBBean);
	    return loginDaoOB;  
	}  

	public LoginDaoOB addUserLogin(UserRegistrationAppServiceIB userRegistrationAppServiceIB)
	{
		LoginDaoOB loginDaoOB = new LoginDaoOB();
		UserLoginDBBean userLoginDBBean = new UserLoginDBBean();
		CommonUtility.copyBean(userRegistrationAppServiceIB, userLoginDBBean);
		saveUserLogin(userLoginDBBean);
		return loginDaoOB;
	}
	
	/*public LoginDaoOB getAllUserLogin(){  
		LoginDaoOB loginDaoOB =new LoginDaoOB();
	    List<UserLoginDBBean> list; 
	    list=template.loadAll(UserLoginDBBean.class);  
	    loginDaoOB.setUserLoginDBBeans(list);
	    return loginDaoOB;  
	}  */


}

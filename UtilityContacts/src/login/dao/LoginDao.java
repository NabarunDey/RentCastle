package login.dao;

import java.util.List;

import login.dao.databaseBeans.UserLoginDBBean;

import org.springframework.orm.hibernate3.HibernateTemplate;

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

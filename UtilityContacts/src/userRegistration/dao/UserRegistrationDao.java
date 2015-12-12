package userRegistration.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;

import com.databaseBeans.UsersDBBean;
import com.util.CommonUtility;

public class UserRegistrationDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	public void saveContacts(UsersDBBean usersDBBean){  
	    template.save(usersDBBean);  
	}  
	public void updateContacts(UsersDBBean usersDBBean){  
	    template.update(usersDBBean);  
	}  
	public void deleteContacts(UsersDBBean usersDBBean){  
	    template.delete(usersDBBean);  
	}  
		
	
	public UserRegistrationDaoOB addUser(
			UserRegistrationAppServiceIB userRegistrationAppServiceIB) {

		UsersDBBean usersDBBean = new  UsersDBBean();
		CommonUtility.copyBean(userRegistrationAppServiceIB, usersDBBean);
		
		
		saveContacts(usersDBBean);
		UserRegistrationDaoOB userRegistrationDaoOB =new UserRegistrationDaoOB();
		userRegistrationDaoOB.setContactInserted(true);
		return userRegistrationDaoOB;
	}

}

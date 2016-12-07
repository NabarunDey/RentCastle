package com.validators;

import org.springframework.context.ApplicationContext;

import com.dao.UsersDao;
import com.databaseBeans.UsersDBBean;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import com.util.ApplicationContextProvider;

public class UsernameValidator extends FieldValidatorSupport  {

	public void validate(Object object) throws ValidationException {

		String username = (String)this.getFieldValue("username", object);

		ApplicationContextProvider applicationContextProvider = new ApplicationContextProvider();
		ApplicationContext applicationContext =applicationContextProvider.getApplicationContext();
		UsersDao usersDao =(UsersDao) applicationContext.getBean("usersDao");
		UsersDBBean usersDBBean = usersDao.getUserDetailsByEmail(username);
		
		if (null!=usersDBBean) {
			addFieldError("username", object);
		}
	}
}

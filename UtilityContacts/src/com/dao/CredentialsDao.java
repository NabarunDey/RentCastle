package com.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.CredentialsDBBean;

@Transactional
public class CredentialsDao {

	static HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template1) {
		template = template1;
	}
	
	
	public static String getValue(String key)
	{
		CredentialsDBBean credentialsDBBean= template.get(CredentialsDBBean.class, key);
		String value="";
		if(null != credentialsDBBean)
			value= credentialsDBBean.getValue();
		return value;
	}
	

}

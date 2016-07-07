package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.AddressDBBean;

@Transactional
public class AddressDao {

	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
	public List<AddressDBBean> getAddressForUser(String userName)
	{
		List<AddressDBBean> addressDBBeans = null;
		return addressDBBeans;
	}
	
	

}

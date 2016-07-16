package com.dao;

import java.util.List;

import order.appService.inputBeans.Address;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(AddressDBBean.class)
				.add(Restrictions.like("username", userName));
		addressDBBeans = criteria.list();
		return addressDBBeans;
	}
	
	public void addAddress( Address address, String username)
	{
		AddressDBBean addressDBBean = new AddressDBBean(); 
		addressDBBean.setAddress(address.getAddress());
		addressDBBean.setCity(address.getCity());
		addressDBBean.setPin(address.getPin());
		addressDBBean.setState(address.getState());
		addressDBBean.setTitle(address.getTitle());
		addressDBBean.setUsername(username);
		template.save(addressDBBean);
	}
	
	

}

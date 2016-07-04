package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import order.appService.inputBeans.OrderAppServiceIB;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.OrdersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.OrderStatus;

@Transactional
public class OrdersDao {

	UserProfile userProfile ;
	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<OrdersDBBean> addOrder(List<OrderAppServiceIB> orderAppServiceIBs)
	{
		List<OrdersDBBean> ordersDBBeans = new ArrayList<OrdersDBBean>(); 
		for(OrderAppServiceIB orderAppServiceIB : orderAppServiceIBs)
		{
			OrdersDBBean ordersDBBean = new OrdersDBBean();
			ordersDBBean.setProductid(orderAppServiceIB.getProductid());
			ordersDBBean.setRentid(orderAppServiceIB.getRentid());
			ordersDBBean.setOrderstatus(OrderStatus.INITIATED.toString());
			String dateTime = Calendar.getInstance().getTime().toString();
			ordersDBBean.setDatetime(dateTime);
			ordersDBBean.setUsername(userProfile.getUserName());
			ordersDBBeans.add(ordersDBBean);
			template.save(ordersDBBean);
			
		}
		return ordersDBBeans;
	}
	
	public List<OrdersDBBean> getOrdersForUser()
	{
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(OrdersDBBean.class)
				.add(Restrictions.like("username", userProfile.getUserName()));
		List<OrdersDBBean> ordersDBBeans = criteria.list();
		return ordersDBBeans;
	}
	
	

}

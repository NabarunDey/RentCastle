package com.dao;

import java.util.ArrayList;
import java.util.List;

import order.appService.inputBeans.OrderAppServiceIB;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.OrdersDBBean;

import cart.projector.outputBeans.CartItem;

@Transactional
public class OrdersDao {

	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public List<OrdersDBBean> addOrder(List<OrderAppServiceIB> orderAppServiceIBs)
	{
		List<OrdersDBBean> ordersDBBeans = new ArrayList<OrdersDBBean>(); 
		return ordersDBBeans;
	}

}

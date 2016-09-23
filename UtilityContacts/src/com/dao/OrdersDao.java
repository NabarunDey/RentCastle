package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import order.appService.inputBeans.Address;
import order.appService.inputBeans.OrderAppServiceIB;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.OrdersDBBean;
import com.structures.status.OrderStatus;

@Transactional
public class OrdersDao {

	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public List<OrdersDBBean> addOrder(List<OrderAppServiceIB> orderAppServiceIBs,String userName,Address address)
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
			ordersDBBean.setUsername(userName);
			ordersDBBean.setAddress(address.getAddress()+","+address.getCity()+","+address.getState());
			ordersDBBean.setPin(address.getPin());
			ordersDBBeans.add(ordersDBBean);
			template.save(ordersDBBean);
			
		}
		return ordersDBBeans;
	}
	
	public List<OrdersDBBean> getOrdersForUser(String userName)
	{
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(OrdersDBBean.class)
				.add(Restrictions.like("username", userName));
		List<OrdersDBBean> ordersDBBeans = criteria.list();
		return ordersDBBeans;
	}
	
	public List<OrdersDBBean> getOrdersForVendor(ArrayList<Integer> productIds )
	{
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(OrdersDBBean.class)
				.add(Restrictions.in("productid", productIds));
		List<OrdersDBBean> ordersDBBeans = criteria.list();
		return ordersDBBeans;
	}
	
	public List<OrdersDBBean> getOrdersForAdmin()
	{
		List<OrdersDBBean> ordersDBBeans = template.loadAll(OrdersDBBean.class);
		return ordersDBBeans;
	}
	
	public void changeOrderStatus(String orderId, OrderStatus orderStatus)
	{
		OrdersDBBean ordersDBBean = template.get(OrdersDBBean.class, Integer.valueOf(orderId));
		ordersDBBean.setOrderstatus(orderStatus.toString());
		template.update(ordersDBBean);
	}
	
	public Map<Integer,Integer> getMostOrderedProducts()
	{
		Map<Integer,Integer> mostOrderredProductsMap= new LinkedHashMap<Integer,Integer>();
		List<OrdersDBBean> ordersDBBeans = template.loadAll(OrdersDBBean.class);
		
		for(OrdersDBBean ordersDBBean:ordersDBBeans)
		{
			int count = mostOrderredProductsMap.get(ordersDBBean.getProductid());
			mostOrderredProductsMap.put(ordersDBBean.getProductid(),count);
		}
		
		TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
		for (Map.Entry entry : mostOrderredProductsMap.entrySet()) {
		    sortedMap.put((Integer) entry.getValue(), (Integer)entry.getKey());
		}
		
		return sortedMap;
	}

}

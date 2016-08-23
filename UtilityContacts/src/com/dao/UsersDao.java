package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;
import cart.appService.inputBeans.CartAppServiceIB;
import cart.dao.outputBeans.CartDaoOB;

import com.databaseBeans.UsersDBBean;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;

public class UsersDao {

	HibernateTemplate template;  
	public void saveUser(UsersDBBean usersDBBean){  
		template.save(usersDBBean);  
	}  
	public void updateUser(UsersDBBean usersDBBean){  
		template.update(usersDBBean);  
	}  
	public void deleteUser(UsersDBBean usersDBBean){  	
		template.delete(usersDBBean);  
	}  


	public UsersDBBean getUserDetails(String userName)
	{
		UsersDBBean usersDBBean = null;
		try{
			usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,userName);
		}catch(Exception exception)
		{
			System.out.println("Error in fetchin UserDBBean");

		}
		return usersDBBean;
	}

	public UserRegistrationDaoOB addUser(
			UserRegistrationAppServiceIB userRegistrationAppServiceIB) {

		UsersDBBean usersDBBean = new  UsersDBBean();
		CommonUtility.copyBean(userRegistrationAppServiceIB, usersDBBean);
		if(null == usersDBBean.getUsertype())
		{
			usersDBBean.setUsertype(UserType.CUSTOMER);
		}
		saveUser(usersDBBean);
		UserRegistrationDaoOB userRegistrationDaoOB =new UserRegistrationDaoOB();
		userRegistrationDaoOB.setUserDetailsInserted(true);
		return userRegistrationDaoOB;
	}

	public CartDaoOB addToCart(CartAppServiceIB cartAppServiceIB)
	{
		CartDaoOB cartDaoOB = new CartDaoOB();
		UsersDBBean usersDBBean = null;
		usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,cartAppServiceIB.getUserProfile().getUserName());
		String cart= "";
		String oldcart=usersDBBean.getCart()!=null?usersDBBean.getCart():"";
		cart=cart+oldcart+cartAppServiceIB.getProductId()+"-"
				+cartAppServiceIB.getRentOfferId()+"|";
		usersDBBean.setCart(cart);
		template.update(usersDBBean);
		int noOfItems= org.springframework.util.StringUtils.countOccurrencesOf(usersDBBean.getCart(), "\\|");
		cartDaoOB.setNumberOfItemsInCart(noOfItems);
		return cartDaoOB;
	}
	

	public List<String> getProductRentIdsFromUserCart(String userName)
	{
		List<String> productIds = new ArrayList<String>();
		UsersDBBean usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,userName);
		if(!StringUtils.isEmpty(usersDBBean.getCart()))
		{
			ArrayList<String> cartList = new ArrayList<String>(); 
			Collections.addAll(cartList,StringUtils.split(usersDBBean.getCart(), "\\|"));

			for(String cart : cartList)
			{
				productIds.add(cart);
			}
		}
		return productIds;
	}

	public void removeFromCart(String userName, String productId,String rentId)
	{
		UsersDBBean usersDBBean= (UsersDBBean) template.get(UsersDBBean.class,userName);
		if(!StringUtils.isEmpty(usersDBBean.getCart()))
		{
			ArrayList<String> cartList = new ArrayList<String>(); 
			Collections.addAll(cartList,StringUtils.split(usersDBBean.getCart(), "\\|"));
				String cartString = "";
			boolean removed = false;
			for(String cart : cartList)
			{
				if(!cart.equals(productId+'-'+rentId) || removed)
				{
					cartString = cartString+cart+"|";
				}
				else
				{
					removed=true;
				}
			}
			usersDBBean.setCart(cartString);
			template.update(usersDBBean);
		}
	}
	
	public void emptyCart(String userName)
	{
		UsersDBBean usersDBBean = template.get(UsersDBBean.class,userName);
		usersDBBean.setCart("");
		template.update(usersDBBean);
	}
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}



}

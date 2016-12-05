package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import profileManagement.appService.inputBeans.ProfileManagementAppServiceIB;
import profileManagement.dao.outputBeans.ProfileManagementDaoOB;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.dao.outputBeans.UserRegistrationDaoOB;
import cart.appService.inputBeans.CartAppServiceIB;
import cart.dao.outputBeans.CartDaoOB;

import com.databaseBeans.UsersDBBean;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;
import com.util.MailHandler;

@Transactional
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

	public List<UsersDBBean> getMultipleUserDetails(List<String> userNames)
	{
		List<UsersDBBean> usersDBBeans = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(UsersDBBean.class)
					.add(Restrictions.in("username", userNames));
			usersDBBeans = criteria.list();		
		}catch(Exception exception)
		{
			System.out.println("Error in fetchin UserDBBean");

		}
		return usersDBBeans;
	}

	public UsersDBBean getUserDetailsByEmail(String email)
	{
		UsersDBBean usersDBBean = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(UsersDBBean.class)
					.add(Restrictions.like("email", email));
			List<UsersDBBean> usersDBBeans = criteria.list();
			if(null!= usersDBBeans && usersDBBeans.size()>=1)
			{
				usersDBBean = usersDBBeans.get(0);
			}
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
		if(usersDBBean.getUsertype().equals(UserType.ADMIN))
		{
			usersDBBean.setUsertype(UserType.CUSTOMER);
		}

		if(usersDBBean.getUsername().contains("@")&& usersDBBean.getUsername().contains("."))
		{
			usersDBBean.setEmail(usersDBBean.getUsername());
		}

		saveUser(usersDBBean);
		MailHandler.welcomeMail(usersDBBean.getEmail());
		UserRegistrationDaoOB userRegistrationDaoOB =new UserRegistrationDaoOB();
		userRegistrationDaoOB.setUserDetailsInserted(true);
		userRegistrationDaoOB.setUsersDBBean(usersDBBean);
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


	public ProfileManagementDaoOB editUser(
			ProfileManagementAppServiceIB profileManagementAppServiceIB) {

		UsersDBBean usersDBBean = template.get(UsersDBBean.class,profileManagementAppServiceIB.getUsername());
		ProfileManagementDaoOB profileManagementDaoOB =new ProfileManagementDaoOB();

		try{
			CommonUtility.copyBean(profileManagementAppServiceIB, usersDBBean);
			if(null == usersDBBean.getUsertype())
			{
				usersDBBean.setUsertype(UserType.CUSTOMER);
			}
			if(usersDBBean.getUsertype().equals(UserType.ADMIN))
			{
				usersDBBean.setUsertype(UserType.CUSTOMER);
			}
			template.update(usersDBBean);
			profileManagementDaoOB.setUserDetailsInserted(true);
		}catch(Exception e)
		{

		}
		return profileManagementDaoOB;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}



}

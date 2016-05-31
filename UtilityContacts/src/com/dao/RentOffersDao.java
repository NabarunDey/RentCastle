package com.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import addProduct.appService.inputBeans.AddRentOfferAppServiceIB;
import addProduct.dao.outputBeans.AddRentOfferDaoOB;

import com.databaseBeans.RentOffersDBBean;
import com.util.CommonUtility;

public class RentOffersDao {
	
	HibernateTemplate template;  
	
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  

		
	
	public AddRentOfferDaoOB addRentOffer(
			AddRentOfferAppServiceIB addRentOfferAppServiceIB) {

		RentOffersDBBean rentOffersDBBean  = new  RentOffersDBBean();
		CommonUtility.copyBean(addRentOfferAppServiceIB, rentOffersDBBean);
		
		boolean success = true;
		try{
		template.save(rentOffersDBBean);
		}catch (Exception exception)
		{
			success= false;
		}
		AddRentOfferDaoOB addRentOfferDaoOB =new AddRentOfferDaoOB();
		addRentOfferDaoOB.setSuccess(success);
		return addRentOfferDaoOB;
	}

}

package com.dao;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import addProduct.appService.inputBeans.AddRentOffersAppServiceIB;
import addProduct.dao.outputBeans.AddRentOfferDaoOB;

import com.databaseBeans.RentOffersDBBean;
import com.util.CommonUtility;

public class RentOffersDao {

	HibernateTemplate template;  


	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  



	public AddRentOfferDaoOB addRentOffer(
			AddRentOffersAppServiceIB addRentOfferAppServiceIB) {

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
	@Transactional
	public List<RentOffersDBBean> getAllRentOffersForProduct(int productId){  
		List<RentOffersDBBean> list; 
		RentOffersDBBean rentOffersDBBean = new RentOffersDBBean();
		rentOffersDBBean.setProductid(productId);

		list =(List<RentOffersDBBean>) template.getSessionFactory().getCurrentSession().createCriteria(RentOffersDBBean.class)
										.add(Example.create(rentOffersDBBean)).list();
		return list;  
	}  
}

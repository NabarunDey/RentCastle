package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

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

	public List<RentOffersDBBean> getAllRentOffersForProduct(int productId){  
		List<RentOffersDBBean> list; 
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(RentOffersDBBean.class);
		criteria.add(Restrictions.eq("productid", productId));
		list = (List<RentOffersDBBean>)template.findByCriteria((DetachedCriteria)criteria);
		//list=template.loadAll(RentOffersDBBean.class);  
		return list;  
	}  
}

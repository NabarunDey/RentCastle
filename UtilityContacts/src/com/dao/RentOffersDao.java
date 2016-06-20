package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import addProduct.appService.inputBeans.AddRentOffersAppServiceIB;
import addProduct.dao.outputBeans.AddRentOfferDaoOB;

import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;

@Transactional
public class RentOffersDao {

	HibernateTemplate template;  


	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  



	public AddRentOfferDaoOB addRentOffer(
			AddRentOffersAppServiceIB addRentOfferAppServiceIB) {

		RentOffersDBBean rentOffersDBBean  = new  RentOffersDBBean();
		String[] periodUnit = addRentOfferAppServiceIB.getPeriodunit().split(",");
		String[] periodValue = addRentOfferAppServiceIB.getPeriodvalue().split(",");
		String[] rentAmount = addRentOfferAppServiceIB.getAmount().split(",");
		rentOffersDBBean.setProductid(addRentOfferAppServiceIB.getProductid());
		boolean success = true;
		int count =0;
		try{
			while(count<periodUnit.length)
			{
				rentOffersDBBean.setPeriodunit(periodUnit[count]);
				rentOffersDBBean.setPeriodvalue(periodValue[count]);
				rentOffersDBBean.setAmount(rentAmount[count]);
				count++;
				template.save(rentOffersDBBean);
			}
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
		RentOffersDBBean rentOffersDBBean = new RentOffersDBBean();
		rentOffersDBBean.setProductid(productId);

		list =(List<RentOffersDBBean>) template.getSessionFactory().getCurrentSession().createCriteria(RentOffersDBBean.class)
				.add(Example.create(rentOffersDBBean)).list();
		return list;  
	}  

	public Map<String,RentOffersDBBean> getMinimumRents(List<ProductsDBBean> productsDBBeans)
	{
		Map<String,RentOffersDBBean> rentMap = new HashMap<String, RentOffersDBBean>();
		List<Integer> productIds = new ArrayList<Integer>();
		for(ProductsDBBean productsDBBean : productsDBBeans)
		{
			productIds.add(productsDBBean.getProductid());
		}
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(RentOffersDBBean.class)
				.add(Restrictions.in("productid", productIds));
		List<RentOffersDBBean> rentOffersDBBeans = criteria.list();

		for(RentOffersDBBean rentOffersDBBean : rentOffersDBBeans)
		{
			if(rentMap.containsKey(String.valueOf(rentOffersDBBean.getProductid()))
					&& Integer.parseInt(rentMap.get(String.valueOf(rentOffersDBBean.getProductid())).getAmount()) 
					< Integer.parseInt(rentOffersDBBean.getAmount()))
			{
				continue;
			}
			rentMap.put(String.valueOf(rentOffersDBBean.getProductid()), rentOffersDBBean);
		}

		return rentMap;
	}
	public void deleteRentOffer(String productId)
	{
		String hql = "delete from com.databaseBeans.RentOffersDBBean where productid= :productid";
		template.getSessionFactory().getCurrentSession().createQuery(hql).setInteger("productid", Integer.parseInt(productId)).executeUpdate();
	}
	
	public List<RentOffersDBBean> getRentOffersByIds(List<String> rentIds)
	{
		List<RentOffersDBBean> rentOffersDBBean = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(RentOffersDBBean.class)
				.add(Restrictions.in("productId", rentIds));
		rentOffersDBBean=criteria.list();
		return rentOffersDBBean;
	}

}

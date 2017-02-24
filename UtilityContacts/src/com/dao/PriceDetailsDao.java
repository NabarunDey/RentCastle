package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import productManagement.appService.inputBeans.ProductManagementAppServiceIB;
import search.appService.inputBeans.SearchProductAppServiceIB;
import addPlaces.appService.inputBeans.AddFacilitiesAppServiceIB;

import com.databaseBeans.PriceDetailsDBBean;
import com.databaseBeans.PlacesDBBean;
import com.databaseBeans.PriceDetailsDBBean;
import com.databaseBeans.ProductsDBBean;
import com.structures.status.ProductStatus;
import com.util.CommonUtility;

@Transactional
public class PriceDetailsDao {

	HibernateTemplate template;  


	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  



	public PriceDetailsDBBean addPrice() {

		PriceDetailsDBBean priceDetailsDBBean = new  PriceDetailsDBBean();
		template.save(priceDetailsDBBean);
		return priceDetailsDBBean;
	}
	
	public PriceDetailsDBBean getPrice(int priceId)
	{
		PriceDetailsDBBean priceDetailsDBBean = null;
		priceDetailsDBBean = template.get(PriceDetailsDBBean.class, priceId);
		return priceDetailsDBBean;
	}
	
	public void updatePrice(int priceId, String priceDetails)
	{
		PriceDetailsDBBean priceDetailsDBBean = null;
		priceDetailsDBBean = template.get(PriceDetailsDBBean.class, priceId);
		if(StringUtils.isNotEmpty(priceDetailsDBBean.getPriceDetails()))
		{
			priceDetailsDBBean.setPriceDetails(priceDetailsDBBean.getPriceDetails().concat(priceDetails+"|"));
		}
		else
		{
			priceDetailsDBBean.setPriceDetails(priceDetails+"|");

		}
	}
}

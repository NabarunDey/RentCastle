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

import com.databaseBeans.FacilitiesDBBean;
import com.databaseBeans.PlacesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.structures.status.ProductStatus;
import com.util.CommonUtility;

@Transactional
public class FacilitiesDao {

	HibernateTemplate template;  

	boolean indexed = false;

	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  



	public FacilitiesDBBean addFacilities() {

		FacilitiesDBBean facilitiesDBBean = new  FacilitiesDBBean();
		template.save(facilitiesDBBean);
		return facilitiesDBBean;
	}
	
	public FacilitiesDBBean getFacilities(int failitiesId)
	{
		FacilitiesDBBean facilitiesDBBean = null;
		facilitiesDBBean = template.get(FacilitiesDBBean.class, failitiesId);
		return facilitiesDBBean;
	}
	
	public void updateFacilities(int failitiesId, String description)
	{
		FacilitiesDBBean facilitiesDBBean = null;
		facilitiesDBBean = template.get(FacilitiesDBBean.class, failitiesId);
		if(StringUtils.isNotEmpty(facilitiesDBBean.getFacilitiesDescription()))
		{
			facilitiesDBBean.setFacilitiesDescription(facilitiesDBBean.getFacilitiesDescription().concat(description));
		}
		else
		{
			facilitiesDBBean.setFacilitiesDescription(description);

		}
	}
	
	public void replaceFacilities(int failitiesId, String description)
	{
		FacilitiesDBBean facilitiesDBBean = null;
		facilitiesDBBean = template.get(FacilitiesDBBean.class, failitiesId);
		if(StringUtils.isNotEmpty(facilitiesDBBean.getFacilitiesDescription()))
		{
			facilitiesDBBean.setFacilitiesDescription(description);
			template.update(facilitiesDBBean);
		}
	}
}

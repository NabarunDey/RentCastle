package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import placeManagement.appService.inputBeans.SearchPlaceCriteria;
import addPlaces.appService.inputBeans.AddPlacesAppServiceIB;

import com.databaseBeans.PlacesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.structures.place.PlaceQuality;
import com.structures.status.ProductStatus;
import com.util.CommonUtility;

@Transactional
public class PlacesDao {

	HibernateTemplate template;  

	boolean indexed = false;

	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  



	public PlacesDBBean addPlaces(
			AddPlacesAppServiceIB addPlacesAppServiceIB) {

		PlacesDBBean placesDBBean = new  PlacesDBBean();
		CommonUtility.copyBean(addPlacesAppServiceIB, placesDBBean);
		placesDBBean.setApprovalStatus(ProductStatus.PENDING.toString());
		placesDBBean.setQuality(PlaceQuality.Economy.toString());
		template.save(placesDBBean);
		return placesDBBean;
	}

	public PlacesDBBean getPlaceDetails(int placeId)
	{
		PlacesDBBean placesDBBean = null;
		try{
			placesDBBean= (PlacesDBBean) template.get(PlacesDBBean.class,placeId);
		}catch(Exception exception)
		{
			System.out.println("Error in fetchin PlacesDBBean");

		}
		return placesDBBean;
	}

	public List<PlacesDBBean> getPlacesForVendor(String userName)
	{
		List<PlacesDBBean> placesDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PlacesDBBean.class)
				.add(Restrictions.like("username", userName));
		placesDBBeans = criteria.list();

		return placesDBBeans;
	}
	
	public List<PlacesDBBean> getPlacesByCriteria(SearchPlaceCriteria searchPlaceCriteria)
	{
		List<PlacesDBBean> placesDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PlacesDBBean.class);

		Criterion completeCondition = null;
		Disjunction disjunction = Restrictions.disjunction();

		if(StringUtils.isNotEmpty(searchPlaceCriteria.getPlaceType()))
			disjunction.add(Restrictions.like("placetype", "%"+searchPlaceCriteria.getPlaceType()+"%"));
		if(StringUtils.isNotEmpty(searchPlaceCriteria.getQuality()))
			disjunction.add(Restrictions.like("quality", "%"+searchPlaceCriteria.getQuality()+"%"));

		completeCondition = disjunction;
		criteria.add(completeCondition);
		
		placesDBBeans = criteria.list();
		return placesDBBeans;
	}
	

}

package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import placeManagement.appService.inputBeans.SearchPlaceCriteria;
import addPlaces.appService.inputBeans.AddPlacesAppServiceIB;

import com.databaseBeans.PlacesDBBean;
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
	
	public PlacesDBBean editPlace(
			AddPlacesAppServiceIB addPlacesAppServiceIB) {

		PlacesDBBean placesDBBean = (PlacesDBBean) template.get(PlacesDBBean.class,addPlacesAppServiceIB.getPlaceid());
		CommonUtility.copyBean(addPlacesAppServiceIB, placesDBBean);
		placesDBBean.setApprovalStatus(ProductStatus.PENDING.toString());
		template.update(placesDBBean);
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

	public List<PlacesDBBean> searchByPlaceText(String searchString)
	{
		List<PlacesDBBean> placesDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PlacesDBBean.class);

		if(StringUtils.isNotEmpty(searchString))
		{
			String[] querryParts  = searchString.split("[^.\\w]");
			Disjunction disjunction = Restrictions.disjunction();

			for(String part : querryParts)
			{
				disjunction.add(Restrictions.like("placename", "%"+part.trim()+"%"));
				disjunction.add(Restrictions.like("description", "%"+part.trim()+"%")); 
				disjunction.add(Restrictions.like("placetype", "%"+part.trim()+"%"));
				disjunction.add(Restrictions.like("address", "%"+part.trim()+"%"));
			}

			Criterion completeCondition=disjunction;
			criteria.add(completeCondition);
		}
		placesDBBeans = criteria.list();

		return placesDBBeans;
	}

	public List<PlacesDBBean> getPlacesByCriteria(SearchPlaceCriteria searchPlaceCriteria)
	{
		List<PlacesDBBean> placesDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PlacesDBBean.class);

		Criterion completeCondition = null;
		Conjunction conjunction = Restrictions.conjunction();

		if(StringUtils.isNotEmpty(searchPlaceCriteria.getPlaceType()))
			conjunction.add(Restrictions.like("placetype", "%"+searchPlaceCriteria.getPlaceType()+"%"));
		if(StringUtils.isNotEmpty(searchPlaceCriteria.getQuality()))
			conjunction.add(Restrictions.like("quality", "%"+searchPlaceCriteria.getQuality()+"%"));

		completeCondition = conjunction;
		criteria.add(completeCondition);

		placesDBBeans = criteria.list();
		return placesDBBeans;
	}
	
	public void changeApprovalStatus(int placeid, String approvalStatus)
	{
		PlacesDBBean placesDBBean= (PlacesDBBean) template.get(PlacesDBBean.class,placeid);
		placesDBBean.setApprovalStatus(approvalStatus);
		template.update(placesDBBean);
	}


}

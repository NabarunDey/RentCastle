package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.DynamicContentDBBean;
import com.databaseBeans.ProductsDBBean;

@Transactional
public class DynamicContentDao {

	static HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template1) {
		template = template1;
	}
	
	
	public static String getValue(String key)
	{
		DynamicContentDBBean dynamicContentDBBean= template.get(DynamicContentDBBean.class, key);
		String value="";
		if(null != dynamicContentDBBean)
			value= dynamicContentDBBean.getValue();
		return value;
	}
	
	public List<DynamicContentDBBean> getDynamicContent(List<String> dynamicContentIds)
	{
		
		List<DynamicContentDBBean> dynamicContentDBBean = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(DynamicContentDBBean.class)
					.add(Restrictions.in("element", dynamicContentIds));
			dynamicContentDBBean=criteria.list();
		}catch(Exception e)
		{
			System.out.println("Error in getting AdsSection");
		}
		return dynamicContentDBBean;
		
	}

}

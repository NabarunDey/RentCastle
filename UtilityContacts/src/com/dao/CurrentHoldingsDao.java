package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.CurrentHoldingsDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;

import currentHoldings.appService.inputBeans.CurrentHoldingsAppServiceIB;

@Transactional
public class CurrentHoldingsDao {

	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	
	public void addCurrentHolding( CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB)
	{
		CurrentHoldingsDBBean currentHoldingsDBBean = new CurrentHoldingsDBBean();
		CommonUtility.copyBean(currentHoldingsAppServiceIB, currentHoldingsDBBean);
		template.save(currentHoldingsDBBean);
	}
	
	public CurrentHoldingsDBBean modiFyCurrentHoldingStatus(CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB, UserProfile userProfile)
	{
		CurrentHoldingsDBBean currentHoldingsDBBean = null;
		try{
			currentHoldingsDBBean = template.get(CurrentHoldingsDBBean.class, Integer.parseInt(currentHoldingsAppServiceIB.getCurrentHoldinsId()));
			if((StringUtils.isNotEmpty(userProfile.getUserName())&& userProfile.getUserName().equals(currentHoldingsDBBean.getUsername()))
					|| userProfile.getUserType().equals(UserType.ADMIN) )
			{
				currentHoldingsDBBean.setStatus(currentHoldingsAppServiceIB.getStatus());
				template.update(currentHoldingsDBBean);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBean;
	}
	
	public List<CurrentHoldingsDBBean> getMyCurrentHoldingsCustomer(String username)
	{
		List<CurrentHoldingsDBBean> currentHoldingsDBBeans = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(CurrentHoldingsDBBean.class)
					.add(Restrictions.like("username", username));
			currentHoldingsDBBeans = criteria.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBeans;
	}
	
}

package com.dao;

import org.apache.commons.lang3.StringUtils;
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
	
	public CurrentHoldingsDBBean modiFyCurrentHolding(CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB, UserProfile userProfile)
	{
		CurrentHoldingsDBBean currentHoldingsDBBean = null;
		try{
			currentHoldingsDBBean = template.get(CurrentHoldingsDBBean.class, Integer.parseInt(currentHoldingsAppServiceIB.getCurrentHoldinsId()));
			if((StringUtils.isNotEmpty(userProfile.getUserName())&& userProfile.getUserName().equals(currentHoldingsDBBean.getUsername()))
					|| userProfile.getUserType().equals(UserType.ADMIN) )
			{
				CommonUtility.copyBean(currentHoldingsAppServiceIB, currentHoldingsDBBean);
				template.update(currentHoldingsDBBean);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBean;
	}
	
}

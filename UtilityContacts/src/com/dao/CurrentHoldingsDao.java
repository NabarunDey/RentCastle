package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.databaseBeans.CurrentHoldingsDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.CurrentHoldingStatus;
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
		currentHoldingsDBBean.setAutorenew(false); 
		template.save(currentHoldingsDBBean);
	}

	public CurrentHoldingsDBBean modiFyCurrentHoldingStatus(CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB, UserProfile userProfile, boolean systemCall)
	{
		CurrentHoldingsDBBean currentHoldingsDBBean = null;
		try{
			currentHoldingsDBBean = template.get(CurrentHoldingsDBBean.class, Integer.parseInt(currentHoldingsAppServiceIB.getCurrentHoldinsId()));
			if(null!= userProfile && StringUtils.isNotEmpty(userProfile.getUserName())&& userProfile.getUserName().equals(currentHoldingsDBBean.getUsername())
					|| userProfile.getUserType().equals(UserType.ADMIN)
					|| systemCall)
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
	
	public List<CurrentHoldingsDBBean> getMyCurrentHoldingsVendor(List<Integer> productIds)
	{
		List<CurrentHoldingsDBBean> currentHoldingsDBBeans = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(CurrentHoldingsDBBean.class)
					.add(Restrictions.in("productid", productIds));
			currentHoldingsDBBeans = criteria.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBeans;
	}

	public List<CurrentHoldingsDBBean> getAllCurrentHoldingsToBeRenewed()
	{
		List<CurrentHoldingsDBBean> currentHoldingsDBBeans = null;
		try{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(CurrentHoldingsDBBean.class);
			Criterion completeCondition = null;
			Disjunction disjunction = Restrictions.disjunction();

			disjunction.add(Restrictions.like("status",CurrentHoldingStatus.ONGOING.toString()));
			disjunction.add(Restrictions.like("status",CurrentHoldingStatus.UPCOMING.toString()));

			completeCondition = disjunction;
			criteria.add(completeCondition);
			currentHoldingsDBBeans = criteria.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBeans;
	}

	public void setStatusAsUpcoming(List<Integer> holdingIds)
	{
		try{
			Session session = template.getSessionFactory().getCurrentSession();
			//session.getTransaction().begin();
			Query query = session.createSQLQuery("update currentholdings set status = :newStatus" + " where holdingid in (:holdingIds)");
			query.setParameter("newStatus", CurrentHoldingStatus.UPCOMING.toString());
			String x=  StringUtils.join(holdingIds,',');
			query.setParameter("holdingIds",x);
			int result = query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public CurrentHoldingsDBBean getCurrentHolding(String holdingId)
	{
		CurrentHoldingsDBBean currentHoldingsDBBean = null;
		try{
			currentHoldingsDBBean = template.get(CurrentHoldingsDBBean.class, Integer.parseInt(holdingId));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return currentHoldingsDBBean;
	}

	public void renewCurrentHolding(CurrentHoldingsDBBean currentHoldingsDBBean)
	{
		try{
			template.update(currentHoldingsDBBean);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setAutoRenewStatus(CurrentHoldingsDBBean currentHoldingsDBBean)
	{
		try{
			template.update(currentHoldingsDBBean);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

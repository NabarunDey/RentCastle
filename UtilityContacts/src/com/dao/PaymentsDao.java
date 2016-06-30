package com.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import order.appService.inputBeans.OrderAppServiceIB;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import payment.appService.inputBeans.PaymentAppServiceIB;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.ProductsDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.OrderStatus;

@Transactional
public class PaymentsDao {

	UserProfile userProfile ;
	HibernateTemplate template;  
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public PaymentsDBBean addPayment(PaymentAppServiceIB paymentAppServiceIB) {
		PaymentsDBBean paymentsDBBean = new PaymentsDBBean();
		paymentsDBBean.setAmount(paymentAppServiceIB.getAmount());
		paymentsDBBean.setFromusername(paymentAppServiceIB.getFromusername());
		paymentsDBBean.setOrderid(paymentAppServiceIB.getOrderid());
		paymentsDBBean.setTousername(paymentAppServiceIB.getTousername());
		String dateTime= Calendar.getInstance().getTime().toString();
		paymentsDBBean.setDatetime(dateTime);
		
		template.save(paymentsDBBean);
		return paymentsDBBean;
	}
	
	public List<PaymentsDBBean> getPaymentsForUser()
	{
		List<PaymentsDBBean> paymentsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PaymentsDBBean.class);
		Criterion completeCondition = null;
		Conjunction conjunction = Restrictions.conjunction();

		conjunction.add(Restrictions.like("fromusername", "%"+userProfile.getUserName()+"%"));
		conjunction.add(Restrictions.like("tousername", "%"+userProfile.getUserName()+"%"));

		completeCondition = conjunction;
		criteria.add(completeCondition);
		paymentsDBBeans = criteria.list();
		return paymentsDBBeans;
	}

}

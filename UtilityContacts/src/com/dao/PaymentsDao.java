package com.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import payment.appService.inputBeans.PaymentAppServiceIB;

import com.databaseBeans.PaymentsDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.PaymentStatus;
import com.structures.userTypes.UserType;

@Transactional
public class PaymentsDao {

	HibernateTemplate template;  

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void addPayment(List<PaymentAppServiceIB> paymentAppServiceIBs) {
		for(PaymentAppServiceIB paymentAppServiceIB :paymentAppServiceIBs)
		{
			PaymentsDBBean paymentsDBBean = new PaymentsDBBean();
			paymentsDBBean.setSecuritymoney(paymentAppServiceIB.getSecuritymoney());
			paymentsDBBean.setRentamount(paymentAppServiceIB.getRentamount());
			paymentsDBBean.setPaymentStatus(PaymentStatus.PENDING.toString());
			paymentsDBBean.setFromusername(paymentAppServiceIB.getFromusername());
			paymentsDBBean.setOrderid(paymentAppServiceIB.getOrderid());
			paymentsDBBean.setTousername(paymentAppServiceIB.getTousername());
			String dateTime= Calendar.getInstance().getTime().toString();
			paymentsDBBean.setDatetime(dateTime);

			template.save(paymentsDBBean);
		}
	}

	public List<PaymentsDBBean> getPaymentsForUser(String userName)
	{
		List<PaymentsDBBean> paymentsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PaymentsDBBean.class);
		Criterion completeCondition = null;
		Conjunction conjunction = Restrictions.conjunction();

		conjunction.add(Restrictions.like("fromusername", "%"+userName+"%"));
		conjunction.add(Restrictions.like("tousername", "%"+userName+"%"));

		completeCondition = conjunction;
		criteria.add(completeCondition);
		paymentsDBBeans = criteria.list();
		return paymentsDBBeans;
	}

	public List<PaymentsDBBean> getPaymentsForAdmin(UserProfile userProfile)
	{
		List<PaymentsDBBean> paymentsDBBeans = null;
		if(userProfile.getUserType().equals(UserType.ADMIN))
		{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PaymentsDBBean.class);
			paymentsDBBeans = criteria.list();
		}
		return paymentsDBBeans;
	}

	public void changePaymentStatus(PaymentAppServiceIB paymentAppServiceIB, UserProfile userProfile)
	{
		if(userProfile.getUserType().equals(UserType.ADMIN))
		{
			PaymentsDBBean paymentsDBBean = new PaymentsDBBean();
			paymentsDBBean = template.get(PaymentsDBBean.class, paymentAppServiceIB.getPaymentid());
			paymentsDBBean.setPaymentStatus(paymentAppServiceIB.getPaymentStatus());
			template.update(paymentsDBBean);
		}
	}
	
	public List<PaymentsDBBean> getPaymentsForOrder(PaymentAppServiceIB paymentAppServiceIB, String userName)
	{
		List<PaymentsDBBean> paymentsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(PaymentsDBBean.class);
		Criterion completeCondition = null;
		Conjunction conjunction = Restrictions.conjunction();

		conjunction.add(Restrictions.like("fromusername", "%"+userName+"%"));
		conjunction.add(Restrictions.like("tousername", "%"+userName+"%"));
		
		Disjunction disjunction =  Restrictions.disjunction();
		disjunction.add(Restrictions.like("orderid", paymentAppServiceIB.getOrderid()));
		disjunction.add(conjunction);
		
		completeCondition = disjunction;
		criteria.add(completeCondition);
		paymentsDBBeans = criteria.list();
		return paymentsDBBeans;
	}

}

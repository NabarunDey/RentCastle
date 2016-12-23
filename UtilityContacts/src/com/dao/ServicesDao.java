package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import services.appService.inputBeans.ServicesAppServiceIB;

import com.databaseBeans.ServicesDBBean;
import com.structures.status.ServiceStatus;

@Transactional
public class ServicesDao {

	HibernateTemplate template;  

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


	public List<ServicesDBBean> getServicesForProvider(String userName)
	{
		List<ServicesDBBean> servicesDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ServicesDBBean.class)
				.add(Restrictions.like("username", userName));
		servicesDBBeans = criteria.list();
		return servicesDBBeans;
	}

	public void addService(ServicesAppServiceIB servicesAppServiceIB, String username)
	{
		ServicesDBBean servicesDBBean = new ServicesDBBean();
		servicesDBBean.setAddress(servicesAppServiceIB.getAddress());
		servicesDBBean.setApprovalStatus(ServiceStatus.PENDING.toString());
		servicesDBBean.setCity(servicesAppServiceIB.getCity());
		servicesDBBean.setDescription(servicesAppServiceIB.getDescription());
		servicesDBBean.setMobile1(servicesAppServiceIB.getMobile1());
		servicesDBBean.setMobile2(servicesAppServiceIB.getMobile2());
		servicesDBBean.setPin(servicesAppServiceIB.getPin());
		servicesDBBean.setTitle(servicesAppServiceIB.getTitle());
		servicesDBBean.setUsername(username);
		servicesDBBean.setServicetype(servicesAppServiceIB.getServicetype());
		servicesDBBean.setRentcastlecut("0");
		template.save(servicesDBBean);
	}

	public List<ServicesDBBean> getServicesForAdmin()
	{
		List<ServicesDBBean> servicesDBBeans = null;
		servicesDBBeans = template.loadAll(ServicesDBBean.class);
		return servicesDBBeans;
	}

	public boolean changeServiceApprovalStatus(String serviceId, String status)
	{
		boolean result=false;
		try{
			ServicesDBBean servicesDBBean = (ServicesDBBean)template.get(ServicesDBBean.class, Integer.parseInt(serviceId));
			servicesDBBean.setApprovalStatus(status);
			template.update(servicesDBBean);
			result= true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}


}

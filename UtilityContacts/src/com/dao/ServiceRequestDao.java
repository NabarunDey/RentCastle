package com.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import services.appService.inputBeans.ServicesAppServiceIB;

import com.databaseBeans.ServiceRequestDBBean;
import com.structures.status.ServiceRequestStatus;

@Transactional
public class ServiceRequestDao {

	HibernateTemplate template;  

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public ServiceRequestDBBean addServiceRequest(ServicesAppServiceIB servicesAppServiceIB, String username)
	{
		ServiceRequestDBBean serviceRequestDBBean = new ServiceRequestDBBean();
		serviceRequestDBBean.setAddress(servicesAppServiceIB.getAddress());
		serviceRequestDBBean.setStatus(ServiceRequestStatus.INITIATED.toString());
		serviceRequestDBBean.setCity(servicesAppServiceIB.getCity());
		serviceRequestDBBean.setDescription(servicesAppServiceIB.getDescription());
		serviceRequestDBBean.setCustomermobile(servicesAppServiceIB.getCustomerMobile());
		serviceRequestDBBean.setPin(servicesAppServiceIB.getPin());
		serviceRequestDBBean.setCustomerusername(username);
		serviceRequestDBBean.setServicetype(servicesAppServiceIB.getServicetype());
		serviceRequestDBBean.setRentcastlecut("0");
		try{
			template.save(serviceRequestDBBean);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return serviceRequestDBBean;
	}
	
	public List<ServiceRequestDBBean> getServiceRequestAdmin()
	{
		List<ServiceRequestDBBean> serviceRequestDBBeans = null;
		try{
			serviceRequestDBBeans = template.loadAll(ServiceRequestDBBean.class);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return serviceRequestDBBeans;
	}
	
	public void changeServiceRequestStatus(String id, String status)
	{
		try{
			ServiceRequestDBBean serviceRequestDBBean = template.get(ServiceRequestDBBean.class, Integer.parseInt(id));
			serviceRequestDBBean.setStatus(status);
			template.update(serviceRequestDBBean);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}

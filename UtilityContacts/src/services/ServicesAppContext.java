package services;

import java.util.List;

import com.databaseBeans.ServicesDBBean;


public class ServicesAppContext {
	
	private List<ServicesDBBean> servicesDBBeans;

	public List<ServicesDBBean> getServicesDBBeans() {
		return servicesDBBeans;
	}

	public void setServicesDBBeans(List<ServicesDBBean> servicesDBBeans) {
		this.servicesDBBeans = servicesDBBeans;
	}
}

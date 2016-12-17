package services;

import java.util.List;

import com.databaseBeans.ServicesDBBean;


public class ServicesAppContext {
	
	private List<ServicesDBBean> servicesDBBeans;
	private boolean serviceAdded;
	private String serviceReqId;
	
	public String getServiceReqId() {
		return serviceReqId;
	}

	public void setServiceReqId(String serviceReqId) {
		this.serviceReqId = serviceReqId;
	}

	public boolean isServiceAdded() {
		return serviceAdded;
	}

	public void setServiceAdded(boolean serviceAdded) {
		this.serviceAdded = serviceAdded;
	}

	public List<ServicesDBBean> getServicesDBBeans() {
		return servicesDBBeans;
	}

	public void setServicesDBBeans(List<ServicesDBBean> servicesDBBeans) {
		this.servicesDBBeans = servicesDBBeans;
	}
}

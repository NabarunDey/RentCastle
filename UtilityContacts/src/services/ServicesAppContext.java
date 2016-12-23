package services;

import java.util.List;

import com.databaseBeans.ServiceRequestDBBean;
import com.databaseBeans.ServicesDBBean;


public class ServicesAppContext {
	
	private List<ServicesDBBean> servicesDBBeans;
	private List<ServiceRequestDBBean> serviceRequestDBBeans;
	private boolean serviceAdded;
	private String serviceReqId;
	private boolean approvalStatusChanged;
	
	
	public List<ServiceRequestDBBean> getServiceRequestDBBeans() {
		return serviceRequestDBBeans;
	}

	public void setServiceRequestDBBeans(
			List<ServiceRequestDBBean> serviceRequestDBBeans) {
		this.serviceRequestDBBeans = serviceRequestDBBeans;
	}

	public boolean isApprovalStatusChanged() {
		return approvalStatusChanged;
	}

	public void setApprovalStatusChanged(boolean approvalStatusChanged) {
		this.approvalStatusChanged = approvalStatusChanged;
	}

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

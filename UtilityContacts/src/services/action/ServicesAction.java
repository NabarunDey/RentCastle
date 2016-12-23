package services.action;

import java.util.List;

import com.databaseBeans.ServiceRequestDBBean;
import com.databaseBeans.ServicesDBBean;
import com.opensymphony.xwork2.ActionSupport;

import services.ServicesAppContext;
import services.appService.ServicesAppService;
import services.appService.inputBeans.ServicesAppServiceIB;



public class ServicesAction  extends ActionSupport {

	ServicesAppService servicesAppService;
	ServicesAppContext context;

	private String title;
	private String mobile1;
	private String mobile2;
	private String address;
	private String description;
	private String city;
	private String pin;
	private String servicetype;
	private String customerMobile;
	private String serviceId;
	private String approvalStatus;
	private String serviceRequestId;
	private String serviceRequestStatus;


	public String addServiceInput()
	{
		return "success";
	}


	public String addServiceSubmit()
	{
		context.setServiceAdded(false);

		ServicesAppServiceIB servicesAppServiceIB = new ServicesAppServiceIB();
		servicesAppServiceIB.setAddress(address);
		servicesAppServiceIB.setCity(city);
		servicesAppServiceIB.setDescription(description);
		servicesAppServiceIB.setMobile1(mobile1);
		servicesAppServiceIB.setMobile2(mobile2);
		servicesAppServiceIB.setPin(pin);
		servicesAppServiceIB.setTitle(title);
		servicesAppServiceIB.setServicetype(servicetype);

		List<ServicesDBBean> servicesDBBeans = servicesAppService.addService(servicesAppServiceIB);
		context.setServicesDBBeans(servicesDBBeans);
		context.setServiceAdded(true);
		return "success";
	}

	public String serviceRequestInput()
	{
		return "success";
	}

	public String serviceRequestSubmit()
	{
		ServicesAppServiceIB servicesAppServiceIB = new ServicesAppServiceIB();
		servicesAppServiceIB.setAddress(address);
		servicesAppServiceIB.setCity(city);
		servicesAppServiceIB.setDescription(description);
		servicesAppServiceIB.setCustomerMobile(customerMobile);
		servicesAppServiceIB.setPin(pin);
		servicesAppServiceIB.setServicetype(servicetype);

		ServiceRequestDBBean serviceRequestDBBean = servicesAppService.addServiceReqest(servicesAppServiceIB);
		context.setServiceReqId(String.valueOf(serviceRequestDBBean.getServicerequestid()));
		return "success";
	}


	public String getServicesForProvider()
	{
		List<ServicesDBBean> servicesDBBeans = servicesAppService.getServicesForProvider();
		context.setServicesDBBeans(servicesDBBeans);
		return "success";
	}
	
	public String changeServiceProviderStatus()
	{
		boolean result= servicesAppService.changeApprovalSatus(serviceId, approvalStatus);
		context.setApprovalStatusChanged(result);
		return "success";
	}
	

	public String getServicesForAdmin()
	{
		context.setServiceAdded(false);
		List<ServicesDBBean> servicesDBBeans = servicesAppService.getServicesForAdmin();
		context.setServicesDBBeans(servicesDBBeans);
		return "success";
	}

	public String changeServiceRequestStatus()
	{
		servicesAppService.changeServiceRequestStatus(serviceRequestId, serviceRequestStatus);
		return "success";
	}
	

	public String getServiceRequestForAdmin()
	{
		context.setServiceAdded(false);
		List<ServiceRequestDBBean> serviceRequestDBBeans = servicesAppService.getServiceRequestsAdmin();
		context.setServiceRequestDBBeans(serviceRequestDBBeans);
		return "success";
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public ServicesAppService getServicesAppService() {
		return servicesAppService;
	}

	public void setServicesAppService(ServicesAppService servicesAppService) {
		this.servicesAppService = servicesAppService;
	}

	public ServicesAppContext getContext() {
		return context;
	}

	public void setContext(ServicesAppContext context) {
		this.context = context;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}


	public String getCustomerMobile() {
		return customerMobile;
	}


	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}


	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}


	public String getApprovalStatus() {
		return approvalStatus;
	}


	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}


	public String getServiceRequestId() {
		return serviceRequestId;
	}


	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}


	public String getServiceRequestStatus() {
		return serviceRequestStatus;
	}


	public void setServiceRequestStatus(String serviceRequestStatus) {
		this.serviceRequestStatus = serviceRequestStatus;
	}
	
	

}

package services.action;

import java.util.List;

import com.databaseBeans.ServicesDBBean;

import services.ServicesAppContext;
import services.appService.ServicesAppService;
import services.appService.inputBeans.ServicesAppServiceIB;



public class ServicesAction {
	
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
	
	public String addService()
	{
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
		return "success";
	}
	
	public String getServicesForProvider()
	{
		List<ServicesDBBean> servicesDBBeans = servicesAppService.getServicesForProvider();
		context.setServicesDBBeans(servicesDBBeans);
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
	
}

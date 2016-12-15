package com.databaseBeans;

public class ServiceRequestDBBean {

	private int servicereqestid;
	private int serviceid;
	private String customerusername;
	private String customermobile;
	private String providerrusername;
	private String address;
	private String description;
	private String city;
	private String pin;
	private String status;
	private String rentcastlecut;

	public String getRentcastlecut() {
		return rentcastlecut;
	}
	public void setRentcastlecut(String rentcastlecut) {
		this.rentcastlecut = rentcastlecut;
	}
	public int getServicereqestid() {
		return servicereqestid;
	}
	public void setServicereqestid(int servicereqestid) {
		this.servicereqestid = servicereqestid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getProviderrusername() {
		return providerrusername;
	}
	public void setProviderrusername(String providerrusername) {
		this.providerrusername = providerrusername;
	}
	public String getCustomermobile() {
		return customermobile;
	}
	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
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

}

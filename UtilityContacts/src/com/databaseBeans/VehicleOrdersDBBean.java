package com.databaseBeans;



public class VehicleOrdersDBBean {

	private int orderid;
	private int vehicleid;
	private int rentid;
	private String username;
	private String dateofrequirement;
	private String dateofbooking;
	private String orderstatus;
	private String address;
	private String pin;

	public String getDateofrequirement() {
		return dateofrequirement;
	}
	public void setDateofrequirement(String dateofrequirement) {
		this.dateofrequirement = dateofrequirement;
	}
	public String getDateofbooking() {
		return dateofbooking;
	}
	public void setDateofbooking(String dateofbooking) {
		this.dateofbooking = dateofbooking;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getRentid() {
		return rentid;
	}
	public void setRentid(int rentid) {
		this.rentid = rentid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

}

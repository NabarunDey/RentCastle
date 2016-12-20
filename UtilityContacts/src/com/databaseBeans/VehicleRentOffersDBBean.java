package com.databaseBeans;


public class VehicleRentOffersDBBean {

	private int rentid;
	private int vehicleid;
	private String periodunit;
	private String periodvalue;
	private String amount;
	
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getPeriodunit() {
		return periodunit;
	}
	public void setPeriodunit(String periodunit) {
		this.periodunit = periodunit;
	}
	public String getPeriodvalue() {
		return periodvalue;
	}
	public void setPeriodvalue(String periodvalue) {
		this.periodvalue = periodvalue;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getRentid() {
		return rentid;
	}
	public void setRentid(int rentId) {
		this.rentid = rentId;
	}
	
	
}

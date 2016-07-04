package com.databaseBeans;



public class PaymentsDBBean {

	private int paymentid;	
	private int orderid;
	private String fromusername;
	private String tousername;
	private String datetime;
	private String amount;
	private String paymentStatus;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getFromusername() {
		return fromusername;
	}
	public void setFromusername(String fromusername) {
		this.fromusername = fromusername;
	}
	public String getTousername() {
		return tousername;
	}
	public void setTousername(String tousername) {
		this.tousername = tousername;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
}

package com.databaseBeans;



public class PaymentsDBBean {

	private int paymentid;	
	private int orderid;
	private String fromusername;
	private String tousername;
	private String datetime;
	private String rentamount;
	private String securitymoney;
	private String paymentStatus;
	private String deliveryCharge;
	private String comments;
	private boolean toUserPaid;
	private boolean fromUserPaid;
	
	public boolean isToUserPaid() {
		return toUserPaid;
	}
	public void setToUserPaid(boolean toUserPaid) {
		this.toUserPaid = toUserPaid;
	}
	public boolean isFromUserPaid() {
		return fromUserPaid;
	}
	public void setFromUserPaid(boolean fromUserPaid) {
		this.fromUserPaid = fromUserPaid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public String getRentamount() {
		return rentamount;
	}
	public void setRentamount(String rentamount) {
		this.rentamount = rentamount;
	}
	public String getSecuritymoney() {
		return securitymoney;
	}
	public void setSecuritymoney(String securitymoney) {
		this.securitymoney = securitymoney;
	}
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
}

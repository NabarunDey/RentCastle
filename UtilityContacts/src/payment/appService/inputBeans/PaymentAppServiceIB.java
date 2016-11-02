package payment.appService.inputBeans;




public class PaymentAppServiceIB {
	
	private int paymentid;
	private int orderid;
	private String fromusername;
	private String tousername;
	private String rentamount;
	private String paymentStatus;
	private String deliveryCharge;
	private String securitymoney;
	
	
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
}

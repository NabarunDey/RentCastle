package payment.action;

import payment.PaymentAppContext;
import payment.appService.PaymentAppService;
import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;




public class PaymentAction   {
	
	PaymentAppService paymentAppService;
	PaymentAppContext context;
	
	String paymentid;
	String paymentstatus;
	
	String orderid;
	String fromusername;
	String tousername;
	String amount;
	
	public String addPayment()
	{
		PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
		paymentAppServiceIB.setAmount(amount);
		paymentAppServiceIB.setFromusername(fromusername);
		paymentAppServiceIB.setOrderid(Integer.parseInt(orderid));
		paymentAppServiceIB.setTousername(tousername);
		PaymentProjectorOB paymentProjectorOB = paymentAppService.addPayment(paymentAppServiceIB);
		context.setPaymentProjectorOB(paymentProjectorOB);
		return "success";
	}
	
	public String getPaymentsForUser()
	{ 
		PaymentProjectorOB paymentProjectorOB = paymentAppService.getPaymentsForUser();
		context.setPaymentProjectorOB(paymentProjectorOB);
		return "success";
	}
	
	public String getPaymentsAdmin()
	{
		PaymentProjectorOB paymentProjectorOB = paymentAppService.getPaymentsAdmin();
		context.setPaymentProjectorOB(paymentProjectorOB);
		return "success";
	}
	
	public String changePaymentStatus()
	{
		PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
		paymentAppServiceIB.setPaymentid(Integer.parseInt(paymentid));
		paymentAppServiceIB.setPaymentStatus(paymentstatus);
		paymentAppService.changePaymentStatus(paymentAppServiceIB);
		return "success";
	}

	public PaymentAppService getPaymentAppService() {
		return paymentAppService;
	}

	public void setPaymentAppService(PaymentAppService paymentAppService) {
		this.paymentAppService = paymentAppService;
	}

	public PaymentAppContext getContext() {
		return context;
	}

	public void setContext(PaymentAppContext context) {
		this.context = context;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}

package payment.action;

import payment.PaymentAppContext;
import payment.appService.PaymentAppService;
import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;




public class PaymentAction   {
	
	PaymentAppService paymentAppService;
	PaymentAppContext context;
	
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
		return "success";
	}
	
}

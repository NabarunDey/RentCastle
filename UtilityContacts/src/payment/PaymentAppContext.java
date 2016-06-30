package payment;

import payment.projector.outputBeans.PaymentProjectorOB;





public class PaymentAppContext {
	
	private PaymentProjectorOB paymentProjectorOB;

	public PaymentProjectorOB getPaymentProjectorOB() {
		return paymentProjectorOB;
	}

	public void setPaymentProjectorOB(PaymentProjectorOB paymentProjectorOB) {
		this.paymentProjectorOB = paymentProjectorOB;
	}
	
	
}

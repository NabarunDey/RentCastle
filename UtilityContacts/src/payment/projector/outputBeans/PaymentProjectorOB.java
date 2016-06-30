package payment.projector.outputBeans;

import java.util.List;

import com.databaseBeans.PaymentsDBBean;





public class PaymentProjectorOB {
	
	private PaymentsDBBean paymentsDBBean;
	private List<PaymentsDBBean> paymentsDBBeans;

	
	public List<PaymentsDBBean> getPaymentsDBBeans() {
		return paymentsDBBeans;
	}

	public void setPaymentsDBBeans(List<PaymentsDBBean> paymentsDBBeans) {
		this.paymentsDBBeans = paymentsDBBeans;
	}

	public PaymentsDBBean getPaymentsDBBean() {
		return paymentsDBBean;
	}

	public void setPaymentsDBBean(PaymentsDBBean paymentsDBBean) {
		this.paymentsDBBean = paymentsDBBean;
	}
	
	
	
}

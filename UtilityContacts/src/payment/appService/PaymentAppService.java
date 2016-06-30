package payment.appService;

import java.util.List;

import com.dao.PaymentsDao;
import com.databaseBeans.PaymentsDBBean;

import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;




/**
 * @author nd29794
 *
 */
public class PaymentAppService {
	
	PaymentsDao paymentsDao;
	
	
	public PaymentProjectorOB addPayment(PaymentAppServiceIB paymentAppServiceIB)
	{
		PaymentsDBBean paymentsDBBean = paymentsDao.addPayment(paymentAppServiceIB);
		PaymentProjectorOB paymentProjectorOB = new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBean(paymentsDBBean);
		return paymentProjectorOB;
	}
	
	public PaymentProjectorOB getPaymentsForUser()
	{
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForUser();
		PaymentProjectorOB paymentProjectorOB = new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}
	
}

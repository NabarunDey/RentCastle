package payment.appService;

import java.util.List;

import com.dao.PaymentsDao;
import com.databaseBeans.PaymentsDBBean;
import com.sessionBeans.UserProfile;

import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;




/**
 * @author nd29794
 *
 */
public class PaymentAppService {
	
	PaymentsDao paymentsDao;
	UserProfile userProfile;
	
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
	
	public PaymentProjectorOB getPaymentsAdmin()
	{
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForUser();
		PaymentProjectorOB paymentProjectorOB = new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}
	
	public void changePaymentStatus(PaymentAppServiceIB paymentAppServiceIB)
	{
		paymentsDao.changePaymentStatus(paymentAppServiceIB);
	}
	
	public PaymentProjectorOB getPaymentsForOrder(PaymentAppServiceIB paymentAppServiceIB)
	{
		paymentAppServiceIB.setFromusername(userProfile.getUserName());
		paymentAppServiceIB.setTousername(userProfile.getUserName());
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForOrder(paymentAppServiceIB);
		PaymentProjectorOB paymentProjectorOB =new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}

	public PaymentsDao getPaymentsDao() {
		return paymentsDao;
	}

	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}

package payment.appService;

import java.util.ArrayList;
import java.util.List;

import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;

import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.databaseBeans.PaymentsDBBean;
import com.sessionBeans.UserProfile;




/**
 * @author nd29794
 *
 */
public class PaymentAppService {
	
	PaymentsDao paymentsDao;
	UserProfile userProfile;
	ProductsDao productsDao;
	
	public void addPayment(PaymentAppServiceIB paymentAppServiceIB)
	{
		List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>();
		paymentAppServiceIBs.add(paymentAppServiceIB);
		paymentsDao.addPayment(paymentAppServiceIBs);
	}
	
	public PaymentProjectorOB getPaymentsForUser()
	{
		List<PaymentsDBBean> paymentsDBBeans = null;
	    paymentsDBBeans= paymentsDao.getPaymentsForUser(userProfile.getUserName());
		PaymentProjectorOB paymentProjectorOB = new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}
	
	
	public PaymentProjectorOB getPaymentsAdmin()
	{
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForAdmin(userProfile);
		PaymentProjectorOB paymentProjectorOB = new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}
	
	public void changePaymentStatus(PaymentAppServiceIB paymentAppServiceIB)
	{
		paymentsDao.changePaymentStatus(paymentAppServiceIB,userProfile);
	}
	
	public PaymentProjectorOB getPaymentsForOrder(PaymentAppServiceIB paymentAppServiceIB)
	{
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

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}
	
}

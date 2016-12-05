package payment.appService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import payment.appService.inputBeans.PaymentAppServiceIB;
import payment.projector.outputBeans.PaymentProjectorOB;

import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.dao.UsersDao;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.PaymentStatus;
import com.util.CommonUtility;
import com.util.MailHandler;




/**
 * @author nd29794
 *
 */
public class PaymentAppService {

	PaymentsDao paymentsDao;
	UserProfile userProfile;
	ProductsDao productsDao;
	UsersDao usersDao;

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
		PaymentsDBBean paymentsDBBean = paymentsDao.changePaymentStatus(paymentAppServiceIB,userProfile);
		if(paymentsDBBean.getPaymentStatus().equals(PaymentStatus.COMPLETED.toString()))
			sendPaymentNotificationsForComplete(paymentsDBBean);
	}

	public PaymentProjectorOB getPaymentsForOrder(PaymentAppServiceIB paymentAppServiceIB)
	{
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForOrder(paymentAppServiceIB);
		PaymentProjectorOB paymentProjectorOB =new PaymentProjectorOB();
		paymentProjectorOB.setPaymentsDBBeans(paymentsDBBeans);
		return paymentProjectorOB;
	}

	private void sendPaymentNotificationsForComplete(final PaymentsDBBean paymentsDBBean)
	{
		Runnable myrunnable = new Runnable() {
			public void run() {
				List<String> usernames = new ArrayList<String>();
				if(!usernames.contains(paymentsDBBean.getFromusername()))
				{
					usernames.add(paymentsDBBean.getFromusername());
				}
				if(!usernames.contains(paymentsDBBean.getTousername()))
				{
					usernames.add(paymentsDBBean.getTousername());
				}

				if(usernames.size()>0)
				{
					List<UsersDBBean> usersDBBeans = usersDao.getMultipleUserDetails(usernames);
					Map<String, UsersDBBean> usermap = CommonUtility.getUsersmap(usersDBBeans);

					MailHandler.paymentCompleted(paymentsDBBean, usermap.get(paymentsDBBean.getTousername()));
					MailHandler.paymentCompleted(paymentsDBBean, usermap.get(paymentsDBBean.getFromusername()));
				}
			}
		};
		new Thread(myrunnable).start();
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

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}

package currentHoldings.appService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import payment.appService.inputBeans.PaymentAppServiceIB;

import com.dao.CurrentHoldingsDao;
import com.dao.OrdersDao;
import com.dao.PaymentsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.CurrentHoldingsDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.CurrentHoldingStatus;
import com.structures.status.PaymentStatus;
import com.util.CommonUtility;

import currentHoldings.appService.inputBeans.CurrentHoldingsAppServiceIB;


/**
 * @author nd29794
 *
 */
public class CurrentHoldingsAppService {
	
	RentOffersDao rentOffersDao;
	CurrentHoldingsDao currentHoldingsDao;
	UserProfile userProfile;
	PaymentsDao paymentsDao;
	OrdersDao ordersDao;

	public void addCurrentHolding(OrdersDBBean ordersDBBean)
	{
		CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB = new CurrentHoldingsAppServiceIB();
		currentHoldingsAppServiceIB.setOrderid(ordersDBBean.getOrderid());
		currentHoldingsAppServiceIB.setProductid(ordersDBBean.getProductid());
		currentHoldingsAppServiceIB.setRentOfferid(ordersDBBean.getRentid());
		currentHoldingsAppServiceIB.setStatus(CurrentHoldingStatus.ONGOING.toString());
		currentHoldingsAppServiceIB.setItemreceiveddate(Calendar.getInstance().getTime().toString());
		currentHoldingsAppServiceIB.setUsername(ordersDBBean.getUsername());
		RentOffersDBBean rentOffersDBBean = rentOffersDao.getRentOffersById(ordersDBBean.getRentid());
		Date todayDate= Calendar.getInstance().getTime();
		Date expiryDate = CommonUtility.addDate(todayDate, rentOffersDBBean.getPeriodunit(), rentOffersDBBean.getPeriodvalue());
		currentHoldingsAppServiceIB.setRentexpirydate(expiryDate.toString());
		
		currentHoldingsDao.addCurrentHolding(currentHoldingsAppServiceIB);
	}
	
	public void endCurrentHolding(String currentHoldingId)
	{
		CurrentHoldingsAppServiceIB currentHoldingsAppServiceIB = new CurrentHoldingsAppServiceIB();
		currentHoldingsAppServiceIB.setCurrentHoldinsId(currentHoldingId);
		currentHoldingsAppServiceIB.setStatus(CurrentHoldingStatus.ENDREQUESTED.toString());
		CurrentHoldingsDBBean currentHoldingsDBBean =  currentHoldingsDao.modiFyCurrentHolding(currentHoldingsAppServiceIB,userProfile);
		
		OrdersDBBean ordersDBBean =  ordersDao.getOrder(currentHoldingsDBBean.getOrderid());
		PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
		paymentAppServiceIB.setOrderid(ordersDBBean.getOrderid());
		List<PaymentsDBBean> paymentsDBBeans = paymentsDao.getPaymentsForOrder(paymentAppServiceIB);
		
		for(PaymentsDBBean paymentsDBBean : paymentsDBBeans)
		{
			if(StringUtils.isNotEmpty(paymentsDBBean.getSecuritymoney())&& !paymentsDBBean.getSecuritymoney().equals("0"))
			{
				PaymentAppServiceIB paymentAppServiceIB2 = new PaymentAppServiceIB();
				paymentAppServiceIB2.setFromusername(paymentsDBBean.getTousername());
				paymentAppServiceIB2.setOrderid(currentHoldingsDBBean.getOrderid());
				paymentAppServiceIB2.setPaymentStatus(PaymentStatus.PENDING.toString());
				paymentAppServiceIB2.setSecuritymoney(paymentsDBBean.getSecuritymoney());
				paymentAppServiceIB2.setTousername(paymentsDBBean.getFromusername());
				
				List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>();
				paymentAppServiceIBs.add(paymentAppServiceIB2);
				paymentsDao.addPayment(paymentAppServiceIBs);
			}
		}
		
	}

	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}

	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}

	public CurrentHoldingsDao getCurrentHoldingsDao() {
		return currentHoldingsDao;
	}

	public void setCurrentHoldingsDao(CurrentHoldingsDao currentHoldingsDao) {
		this.currentHoldingsDao = currentHoldingsDao;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
}

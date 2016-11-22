package currentHoldings.appService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import payment.appService.inputBeans.PaymentAppServiceIB;

import com.dao.CurrentHoldingsDao;
import com.dao.ImagesDao;
import com.dao.OrdersDao;
import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.CurrentHoldingsDBBean;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.CurrentHoldingStatus;
import com.structures.status.PaymentStatus;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;

import currentHoldings.appService.inputBeans.CurrentHoldingsAppServiceIB;
import currentHoldings.projector.CurrentHoldingsProjector;
import currentHoldings.projector.input.CurrentHoldingsProjectorIB;
import currentHoldings.projector.outputBeans.CurrentHoldingsProjectorOB;


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
	ProductsDao productsDao;
	CurrentHoldingsProjector currentHoldingsProjector;
	ImagesDao imagesDao;

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
		CurrentHoldingsDBBean currentHoldingsDBBean =  currentHoldingsDao.modiFyCurrentHoldingStatus(currentHoldingsAppServiceIB,userProfile);
		
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
	
	public List<CurrentHoldingsProjectorOB> viewMyCurrentHoldingsCustomer()
	{
		List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs= null;
		if(null!= userProfile && userProfile.getUserType().equals(UserType.CUSTOMER))
		{
			List<Integer> productIds = new ArrayList<Integer>();
			List<Integer> rentIds = new ArrayList<Integer>();
			List<Integer> orderIds = new ArrayList<Integer>();
			List<CurrentHoldingsDBBean> currentHoldingsDBBeans = currentHoldingsDao.getMyCurrentHoldingsCustomer(userProfile.getUserName());

			if(null!=currentHoldingsDBBeans && currentHoldingsDBBeans.size()>0)
			{
				for(CurrentHoldingsDBBean currentHoldingsDBBean : currentHoldingsDBBeans)
				{
					productIds.add(currentHoldingsDBBean.getProductid());
					rentIds.add(currentHoldingsDBBean.getRentOfferid());
					orderIds.add(currentHoldingsDBBean.getOrderid());
				}
			}
			List<ProductsDBBean> productsDBBeans = productsDao.getProductListByIdsInteger(productIds);
			List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao.getRentOffersByIdsInteger(rentIds);
			List<OrdersDBBean> ordersDBBeans = ordersDao.getOrders(orderIds);

			Map<String, ProductsDBBean> productsMap = CommonUtility.getProductMap(productsDBBeans);
			Map<String, RentOffersDBBean> rentMap = CommonUtility.getRentMap(rentOffersDBBeans);
			Map<String, OrdersDBBean> orderMap = CommonUtility.getOrdersMap(ordersDBBeans);
			Map<String, ImagesDBBean> productImageMap = imagesDao.getPrimaryImageOfProduct(productsDBBeans);

			CurrentHoldingsProjectorIB currentHoldingsProjectorIB = new CurrentHoldingsProjectorIB();
			currentHoldingsProjectorIB.setCurrentHoldingsDBBeans(currentHoldingsDBBeans);
			currentHoldingsProjectorIB.setOrdersMap(orderMap);
			currentHoldingsProjectorIB.setProductsMap(productsMap);
			currentHoldingsProjectorIB.setRentMap(rentMap);
			currentHoldingsProjectorIB.setProductImagesMap(productImageMap);
			

			currentHoldingsProjectorOBs= currentHoldingsProjector.getMyCurrentHoldingsProjector(currentHoldingsProjectorIB);
		}
		return currentHoldingsProjectorOBs;
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

	public PaymentsDao getPaymentsDao() {
		return paymentsDao;
	}

	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	public CurrentHoldingsProjector getCurrentHoldingsProjector() {
		return currentHoldingsProjector;
	}

	public void setCurrentHoldingsProjector(
			CurrentHoldingsProjector currentHoldingsProjector) {
		this.currentHoldingsProjector = currentHoldingsProjector;
	}

	public ImagesDao getImagesDao() {
		return imagesDao;
	}

	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}
	
}

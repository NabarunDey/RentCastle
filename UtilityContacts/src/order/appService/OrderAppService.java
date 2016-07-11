package order.appService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import order.appService.inputBeans.OrderAppServiceIB;
import order.dao.outputBeans.OrderDaoOB;
import order.projector.OrderProjector;
import order.projector.outputBeans.OrderProjectorOB;
import payment.appService.inputBeans.PaymentAppServiceIB;
import cart.appService.CartAppService;
import cart.projector.outputBeans.CartItem;
import cart.projector.outputBeans.CartProjectorOB;

import com.dao.OrdersDao;
import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;



/**
 * @author nd29794
 *
 */
public class OrderAppService {

	CartAppService cartAppService;
	OrderProjector orderProjector;
	UserProfile userProfile;
	OrdersDao ordersDao;
	ProductsDao productsDao;
	RentOffersDao rentOffersDao;
	PaymentsDao paymentsDao;
	
	public OrderProjectorOB getCartOrderInput()
	{	
		CartProjectorOB cartProjectorOB = cartAppService.viewCart();
		OrderDaoOB orderDaoOB = new  OrderDaoOB();
		orderDaoOB.setCartItems(cartProjectorOB.getCartItems());
		OrderProjectorOB orderProjectorOB = orderProjector.getOrderInput(orderDaoOB);
		return orderProjectorOB;
	}
	
	public void checkIfDeliveryAvailable(String pin,String state,String city, OrderProjectorOB orderProjectorOB)
	{
		for(CartItem cartItem : orderProjectorOB.getCartItems())
		{
			boolean deliveryAvailable = false;
			if(cartItem.getProductState().equals(state)&& cartItem.getProductCity().equals(city))
			{
				if(cartItem.getProductPin().equals("All"))
				{
					deliveryAvailable=true;
				}
				else
				{
					String[] pins = cartItem.getProductPin().split(",");
					List<String> pinList = Arrays.asList(pins);
					if(pinList.contains("pin"));
					{
						deliveryAvailable=true;
					}
				}
			}
			cartItem.setDeliveryAvailable(deliveryAvailable);
		}
	}
	
	public OrderProjectorOB placeCartOrder(List<CartItem> cartItems)
	{
		List<OrderAppServiceIB> orderAppServiceIBs = new ArrayList<OrderAppServiceIB>();
		for(CartItem cartItem : cartItems)
		{
			OrderAppServiceIB orderAppServiceIB = new OrderAppServiceIB();
			orderAppServiceIB.setProductid(cartItem.getProductId());
			orderAppServiceIB.setRentid(cartItem.getRentId());
			orderAppServiceIB.setUsername(userProfile.getUserName());
			orderAppServiceIBs.add(orderAppServiceIB);
		}
		List<OrdersDBBean> ordersDBBeans = ordersDao.addOrder(orderAppServiceIBs,userProfile.getUserName());
		
		Iterator<CartItem> cartIterator = cartItems.iterator();
		Iterator<OrdersDBBean> orderIterator = ordersDBBeans.iterator();
		List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>();
		while(cartIterator.hasNext() && orderIterator.hasNext())
		{
			CartItem cartItem = cartIterator.next();
			OrdersDBBean ordersDBBean = orderIterator.next();
			PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
			paymentAppServiceIB.setFromusername(userProfile.getUserName());
			paymentAppServiceIB.setOrderid(ordersDBBean.getOrderid());
			paymentAppServiceIB.setRentamount(cartItem.getRentAmount());
			paymentAppServiceIB.setSecuritymoney(cartItem.getSecurityMoney());
			paymentAppServiceIB.setTousername("rentme");
			paymentAppServiceIBs.add(paymentAppServiceIB);
		}
		paymentsDao.addPayment(paymentAppServiceIBs);
		cartAppService.emptyCart(); 
		OrderProjectorOB orderProjectorOB = orderProjector.confirmOrder(ordersDBBeans);
		return orderProjectorOB;
	}
	
	
	public OrderProjectorOB viewOrders()
	{
		List<OrdersDBBean> ordersDBBeans = ordersDao.getOrdersForUser(userProfile.getUserName());
		
		List<Integer> productIds = new ArrayList<Integer>();
		List<Integer> rentOfferIds = new ArrayList<Integer>();
		for(OrdersDBBean ordersDBBean : ordersDBBeans)
		{
			productIds.add(ordersDBBean.getProductid());
			rentOfferIds.add(ordersDBBean.getRentid());
		}
		List<ProductsDBBean> productsDBBeans = productsDao.getProductListByIdsInteger(productIds);
		List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao.getRentOffersByIdsInteger(rentOfferIds);
		
		OrderProjectorOB orderProjectorOB = orderProjector.viewOrders(ordersDBBeans, productsDBBeans, rentOffersDBBeans);
		return orderProjectorOB;
	}

	public CartAppService getCartAppService() {
		return cartAppService;
	}

	public void setCartAppService(CartAppService cartAppService) {
		this.cartAppService = cartAppService;
	}

	public OrderProjector getOrderProjector() {
		return orderProjector;
	}

	public void setOrderProjector(OrderProjector orderProjector) {
		this.orderProjector = orderProjector;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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

	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}

	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}

	public PaymentsDao getPaymentsDao() {
		return paymentsDao;
	}

	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}
	
	
	
}

package order.appService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import order.appService.inputBeans.Address;
import order.appService.inputBeans.OrderAppServiceIB;
import order.dao.outputBeans.OrderDaoOB;
import order.projector.OrderProjector;
import order.projector.outputBeans.OrderProjectorOB;
import payment.appService.inputBeans.PaymentAppServiceIB;
import cart.appService.CartAppService;
import cart.projector.outputBeans.CartItem;
import cart.projector.outputBeans.CartProjectorOB;

import com.dao.AddressDao;
import com.dao.OrdersDao;
import com.dao.PaymentsDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.dao.UsersDao;
import com.databaseBeans.AddressDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.status.OrderStatus;
import com.structures.userTypes.UserType;
import com.util.MailHandler;

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
	AddressDao addressDao;
	UsersDao usersDao;

	public OrderProjectorOB getCartOrderInput() {
		CartProjectorOB cartProjectorOB = cartAppService.viewCart();
		OrderDaoOB orderDaoOB = new OrderDaoOB();
		orderDaoOB.setCartItems(cartProjectorOB.getCartItems());
		OrderProjectorOB orderProjectorOB = orderProjector
				.getOrderInput(orderDaoOB);
		AddressDBBean addressDBBean = addressDao
				.getAddressForUser(userProfile.getUserName());
		orderProjectorOB.setAddressDBBean(addressDBBean);
		return orderProjectorOB;
	}

	public void checkIfDeliveryAvailable(Address address,
			OrderProjectorOB orderProjectorOB) {
		for (CartItem cartItem : orderProjectorOB.getCartItems()) {
			boolean deliveryAvailable = false;
			if (cartItem.getProductState().equals(address.getState())
					&& cartItem.getProductCity().equals(address.getCity())) {
				if (cartItem.getProductPin().equals("All")) {
					deliveryAvailable = true;
				} else {
					String[] pins = cartItem.getProductPin().split("\\|");
					List<String> pinList = Arrays.asList(pins);
					if (pinList.contains(address.getPin())) {
						deliveryAvailable = true;
					}
				}
			}
			cartItem.setDeliveryAvailable(deliveryAvailable);
		}
	}

	public OrderProjectorOB placeCartOrder(List<CartItem> cartItems,
			Address address) {
		List<OrderAppServiceIB> orderAppServiceIBs = new ArrayList<OrderAppServiceIB>();
		for (CartItem cartItem : cartItems) {
			OrderAppServiceIB orderAppServiceIB = new OrderAppServiceIB();
			orderAppServiceIB.setProductid(cartItem.getProductId());
			orderAppServiceIB.setRentid(cartItem.getRentId());
			orderAppServiceIB.setUsername(userProfile.getUserName());
			orderAppServiceIBs.add(orderAppServiceIB);
		}
		List<OrdersDBBean> ordersDBBeans = ordersDao.addOrder(
				orderAppServiceIBs, userProfile.getUserName(), address);
		if (StringUtils.isEmpty(address.getAddressId()) || "0".equals(address.getAddressId()) ) {
			addressDao.addAddress(address, userProfile.getUserName());
		}
		else {
			addressDao.updateAddress(address, userProfile.getUserName());
		}

		Iterator<CartItem> cartIterator = cartItems.iterator();
		Iterator<OrdersDBBean> orderIterator = ordersDBBeans.iterator();
		List<PaymentAppServiceIB> paymentAppServiceIBs = new ArrayList<PaymentAppServiceIB>();
		while (cartIterator.hasNext() && orderIterator.hasNext()) {
			CartItem cartItem = cartIterator.next();
			OrdersDBBean ordersDBBean = orderIterator.next();
			PaymentAppServiceIB paymentAppServiceIB = new PaymentAppServiceIB();
			paymentAppServiceIB.setFromusername(userProfile.getUserName());
			paymentAppServiceIB.setOrderid(ordersDBBean.getOrderid());
			paymentAppServiceIB.setRentamount(cartItem.getRentAmount());
			paymentAppServiceIB.setSecuritymoney(cartItem.getSecurityMoney());
			ProductsDBBean productsDBBean =productsDao.getProductDetails(ordersDBBean.getProductid());
			UsersDBBean usersDBBean = usersDao.getUserDetails(productsDBBean.getUsername());
			MailHandler.orderConfirmationMailVendor(productsDBBean,ordersDBBean,usersDBBean.getEmail());
			MailHandler.orderConfirmationMailCustomer(productsDBBean,ordersDBBean,userProfile);

			paymentAppServiceIB.setTousername(productsDBBean.getUsername());
			paymentAppServiceIBs.add(paymentAppServiceIB);
		}
		paymentsDao.addPayment(paymentAppServiceIBs);
		cartAppService.emptyCart();
		OrderProjectorOB orderProjectorOB = orderProjector
				.confirmOrder(ordersDBBeans);
		return orderProjectorOB;
	}

	public OrderProjectorOB viewOrders(boolean isAdmin) {
		OrderProjectorOB orderProjectorOB = null;
		List<OrdersDBBean> ordersDBBeans = null;
		if (isAdmin) {
			ordersDBBeans = ordersDao.getOrdersForAdmin();
		} else {
			ordersDBBeans = ordersDao.getOrdersForUser(userProfile
					.getUserName());
		}
		if (null != ordersDBBeans && ordersDBBeans.size() >= 1) {
			List<Integer> productIds = new ArrayList<Integer>();
			List<Integer> rentOfferIds = new ArrayList<Integer>();
			for (OrdersDBBean ordersDBBean : ordersDBBeans) {
				productIds.add(ordersDBBean.getProductid());
				rentOfferIds.add(ordersDBBean.getRentid());
			}
			List<ProductsDBBean> productsDBBeans = productsDao
					.getProductListByIdsInteger(productIds);
			List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao
					.getRentOffersByIdsInteger(rentOfferIds);

			orderProjectorOB = orderProjector.viewOrders(ordersDBBeans,
					productsDBBeans, rentOffersDBBeans);
		}
		return orderProjectorOB;
	}

	public OrderProjectorOB getOrdersForVendor() {
		OrderProjectorOB orderProjectorOB = null;
		List<OrdersDBBean> ordersDBBeans = null;

		if (userProfile.getUserType().equals(UserType.VENDOR)) {
			List<ProductsDBBean> productsDBBeans = productsDao
					.searchByVendor(userProfile.getUserName());
			ArrayList<Integer> productIds = new ArrayList<Integer>();
			for (ProductsDBBean productsDBBean : productsDBBeans) {
				productIds.add(productsDBBean.getProductid());
			}
			if (productIds.size() >= 1) {
				ordersDBBeans = ordersDao.getOrdersForVendor(productIds);
				if (null != ordersDBBeans && ordersDBBeans.size() >= 1) {
					List<Integer> rentOfferIds = new ArrayList<Integer>();
					for (OrdersDBBean ordersDBBean : ordersDBBeans) {
						productIds.add(ordersDBBean.getProductid());
						rentOfferIds.add(ordersDBBean.getRentid());
					}
					List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao
							.getRentOffersByIdsInteger(rentOfferIds);

					orderProjectorOB = orderProjector.viewOrders(ordersDBBeans,
							productsDBBeans, rentOffersDBBeans);
				}
			}
		}
		return orderProjectorOB;
	}

	public OrderProjectorOB getOrdersForAdmin() {
		OrderProjectorOB orderProjectorOB = null;
		if (userProfile.getUserType().equals(UserType.ADMIN)) {
			orderProjectorOB = viewOrders(true);
		}
		return orderProjectorOB;
	}

	public void changeOrderStatus(OrderAppServiceIB orderAppServiceIB) {
		ordersDao.changeOrderStatus(orderAppServiceIB.getOrderId(),
				OrderStatus.valueOf(orderAppServiceIB.getOrderStatus()));
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

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	

}

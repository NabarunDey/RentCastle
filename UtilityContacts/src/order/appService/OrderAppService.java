package order.appService;

import java.util.ArrayList;
import java.util.List;

import order.appService.inputBeans.OrderAppServiceIB;
import order.dao.outputBeans.OrderDaoOB;
import order.projector.OrderProjector;
import order.projector.outputBeans.OrderProjectorOB;
import cart.appService.CartAppService;
import cart.projector.outputBeans.CartItem;
import cart.projector.outputBeans.CartProjectorOB;

import com.dao.OrdersDao;
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
	
	public OrderProjectorOB getCartOrderInput()
	{	
		CartProjectorOB cartProjectorOB = cartAppService.viewCart();
		OrderDaoOB orderDaoOB = new  OrderDaoOB();
		orderDaoOB.setCartItems(cartProjectorOB.getCartItems());
		OrderProjectorOB orderProjectorOB = orderProjector.getOrderInput(orderDaoOB);
		return orderProjectorOB;
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
		return new OrderProjectorOB();
	}
	
	public OrderProjectorOB viewOrders()
	{
		List<OrdersDBBean> ordersDBBeans = ordersDao.getOrdersForUser();
		
		List<Integer> productIds = new ArrayList<Integer>();
		List<Integer> rentOfferIds = new ArrayList<Integer>();
		for(OrdersDBBean ordersDBBean : ordersDBBeans)
		{
			productIds.add(ordersDBBean.getProductid());
			rentOfferIds.add(ordersDBBean.getRentid());
		}
		List<ProductsDBBean> productsDBBeans = productsDao.getProductListByIdsInteger(productIds);
		List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao.getRentOffersByIdsInteger(rentOfferIds);
		
		OrderProjectorOB orderProjectorOB = orderProjector.viewCart(ordersDBBeans, productsDBBeans, rentOffersDBBeans);
		return orderProjectorOB;
	}
}

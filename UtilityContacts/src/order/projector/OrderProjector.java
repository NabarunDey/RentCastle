package order.projector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import order.dao.outputBeans.OrderDaoOB;
import order.projector.outputBeans.OrderItem;
import order.projector.outputBeans.OrderProjectorOB;
import cart.projector.outputBeans.CartItem;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.util.CommonUtility;




public class OrderProjector {
	
	public OrderProjectorOB getOrderInput(OrderDaoOB orderDaoOB)
	{
		OrderProjectorOB orderProjectorOB = new OrderProjectorOB();
		orderProjectorOB.setCartItems(orderDaoOB.getCartItems());
		int total= 0;
		for(CartItem cartItem : orderDaoOB.getCartItems())
		{
			int itemTotal = Integer.parseInt(cartItem.getSecurityMoney()) + Integer.parseInt(cartItem.getRentAmount().trim())+  Integer.parseInt(cartItem.getDeliveryCharge().trim()) ; 
			total = total + itemTotal;
			cartItem.setItemTotal(String.valueOf(itemTotal));
		}
			
		orderProjectorOB.setTotal(String.valueOf(total));
		return orderProjectorOB;
	}
	
	public OrderProjectorOB confirmOrder(List<OrdersDBBean> ordersDBBeans)
	{
		OrderProjectorOB orderProjectorOB = new OrderProjectorOB();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(OrdersDBBean ordersDBBean : ordersDBBeans)
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setOrdersDBBean(ordersDBBean);
			orderItems.add(orderItem);
		}
		orderProjectorOB.setOrderItems(orderItems);
		return orderProjectorOB;
	}
	
	public OrderProjectorOB viewOrders(List<OrdersDBBean> ordersDBBeans,List<ProductsDBBean> productsDBBeans,
									List<RentOffersDBBean> rentOffersDBBeans )
	{
		OrderProjectorOB orderProjectorOB = new OrderProjectorOB();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		Map<String, ProductsDBBean> productMap = CommonUtility.getProductMap(productsDBBeans);
		Map<String, RentOffersDBBean> rentMap = CommonUtility.getRentMap(rentOffersDBBeans);
		
		for(OrdersDBBean ordersDBBean : ordersDBBeans)
		{
			ProductsDBBean productsDBBean = productMap.get(String.valueOf(ordersDBBean.getProductid()));
			RentOffersDBBean rentOffersDBBean = rentMap.get(String.valueOf(ordersDBBean.getRentid()));
			OrderItem orderItem = new OrderItem();
			orderItem.setOrdersDBBean(ordersDBBean);
			orderItem.setProductsDBBean(productsDBBean);
			orderItem.setRentOffersDBBean(rentOffersDBBean);
			
			orderItems.add(orderItem);
		}
		orderProjectorOB.setOrderItems(orderItems);
		
		return orderProjectorOB;
	}

}

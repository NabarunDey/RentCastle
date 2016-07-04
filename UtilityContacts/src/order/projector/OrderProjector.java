package order.projector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;

import cart.projector.outputBeans.CartItem;
import order.dao.outputBeans.OrderDaoOB;
import order.projector.outputBeans.OrderItem;
import order.projector.outputBeans.OrderProjectorOB;




public class OrderProjector {
	
	public OrderProjectorOB getOrderInput(OrderDaoOB orderDaoOB)
	{
		OrderProjectorOB orderProjectorOB = new OrderProjectorOB();
		orderProjectorOB.setCartItems(orderDaoOB.getCartItems());
		int total= 0;
		for(CartItem cartItem : orderDaoOB.getCartItems())
		{
			total = total + Integer.parseInt(cartItem.getSecurityMoney()) + Integer.parseInt(cartItem.getRentAmount());
		}
			
		orderProjectorOB.setTotal(orderProjectorOB.toString());
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
		Iterator aIterator = ordersDBBeans.iterator();
		Iterator bIterator = productsDBBeans.iterator();
		Iterator cIterator = rentOffersDBBeans.iterator();
		
		while (aIterator.hasNext() && bIterator.hasNext() && cIterator.hasNext())
		{
			OrdersDBBean ordersDBBean = (OrdersDBBean)aIterator.next();
			ProductsDBBean productsDBBean = (ProductsDBBean)bIterator.next();
			RentOffersDBBean rentOffersDBBean = (RentOffersDBBean)cIterator.next();
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

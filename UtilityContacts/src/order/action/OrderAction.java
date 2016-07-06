package order.action;

import java.util.List;

import cart.CartAppContext;
import cart.projector.outputBeans.CartItem;
import order.OrderAppContext;
import order.appService.OrderAppService;
import order.projector.outputBeans.OrderProjectorOB;



public class OrderAction   {
	
	OrderAppService orderAppService;
	OrderAppContext context;
	CartAppContext cartAppContext;
	
	public String getCartOrderInput()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.getCartOrderInput();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String placeCartOrder()
	{
		List<CartItem> cartItems = cartAppContext.getCartProjectorOB().getCartItems();
		OrderProjectorOB orderProjectorOB = orderAppService.placeCartOrder(cartItems);
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String viewOrders()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.viewOrders();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}

	public OrderAppService getOrderAppService() {
		return orderAppService;
	}

	public void setOrderAppService(OrderAppService orderAppService) {
		this.orderAppService = orderAppService;
	}

	public OrderAppContext getContext() {
		return context;
	}

	public void setContext(OrderAppContext context) {
		this.context = context;
	}

	public CartAppContext getCartAppContext() {
		return cartAppContext;
	}

	public void setCartAppContext(CartAppContext cartAppContext) {
		this.cartAppContext = cartAppContext;
	}
	
	

}

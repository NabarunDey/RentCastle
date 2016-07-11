package order.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cart.CartAppContext;
import cart.projector.outputBeans.CartItem;
import order.OrderAppContext;
import order.appService.OrderAppService;
import order.projector.outputBeans.OrderProjectorOB;



public class OrderAction extends ActionSupport    {
	
	OrderAppService orderAppService;
	OrderAppContext context;
	CartAppContext cartAppContext;
	String deliveryPin;
	String state;
	String city;
	
	public String getCartOrderInput()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.getCartOrderInput();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String checkIfDeliveryAvailable()
	{
		orderAppService.checkIfDeliveryAvailable(deliveryPin, state, city,	context.getOrderProjectorOB());
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

	public String getDeliveryPin() {
		return deliveryPin;
	}

	public void setDeliveryPin(String deliveryPin) {
		this.deliveryPin = deliveryPin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

package order.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cart.CartAppContext;
import cart.projector.outputBeans.CartItem;
import order.OrderAppContext;
import order.appService.OrderAppService;
import order.appService.inputBeans.Address;
import order.appService.inputBeans.OrderAppServiceIB;
import order.projector.outputBeans.OrderProjectorOB;



public class OrderAction extends ActionSupport    {
	
	OrderAppService orderAppService;
	OrderAppContext context;
	CartAppContext cartAppContext;
	String pin;
	String state;
	String city;
	String address;
	String addressId;
	String title;
	String orderId;
	String orderStatus;
	
	public String getCartOrderInput()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.getCartOrderInput();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String checkIfDeliveryAvailable()
	{
		Address address = new Address();
		address.setAddressId(addressId);
		address.setTitle(title);
		address.setCity(city);
		address.setPin(pin);
		address.setAddress(this.address);
		address.setState(state);
		context.setAddress(address);
		orderAppService.checkIfDeliveryAvailable(address,context.getOrderProjectorOB());
		return "success";
	}
	
	public String placeCartOrder()
	{
		List<CartItem> cartItems = cartAppContext.getCartProjectorOB().getCartItems();
		OrderProjectorOB orderProjectorOB = orderAppService.placeCartOrder(cartItems,context.getAddress());
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String viewOrders()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.viewOrders(false);
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}
	
	public String getOrdersForAdmin()
	{
		OrderProjectorOB orderProjectorOB =orderAppService.getOrdersForAdmin();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}

	public String changeOrderSatus()
	{
		OrderAppServiceIB orderAppServiceIB = new OrderAppServiceIB();
		orderAppServiceIB.setOrderId(orderId);
		orderAppServiceIB.setOrderStatus(orderStatus);
		orderAppService.changeOrderStatus(orderAppServiceIB);
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}

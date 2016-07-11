package order.projector.outputBeans;

import java.util.List;

import cart.projector.outputBeans.CartItem;

import com.databaseBeans.AddressDBBean;


public class OrderProjectorOB {
	
	private List<CartItem> cartItems;
	private String total;
	private List<OrderItem> orderItems;
	private List<AddressDBBean> addressDBBeans;
	
	public List<AddressDBBean> getAddressDBBeans() {
		return addressDBBeans;
	}
	public void setAddressDBBeans(List<AddressDBBean> addressDBBeans) {
		this.addressDBBeans = addressDBBeans;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}

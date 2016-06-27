package order.projector.outputBeans;

import java.util.List;

import cart.projector.outputBeans.CartItem;




public class OrderProjectorOB {
	
	private List<CartItem> cartItems;
	private String total;
	
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

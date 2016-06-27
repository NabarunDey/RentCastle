package order.dao.outputBeans;

import java.util.List;

import cart.projector.outputBeans.CartItem;




public class OrderDaoOB {
	
	private List<CartItem> cartItems;

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
}

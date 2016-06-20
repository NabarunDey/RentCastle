package cart;

import cart.projector.outputBeans.CartProjectorOB;



public class CartAppContext {
	
	private CartProjectorOB cartProjectorOB;

	public CartProjectorOB getCartProjectorOB() {
		return cartProjectorOB;
	}

	public void setCartProjectorOB(CartProjectorOB cartProjectorOB) {
		this.cartProjectorOB = cartProjectorOB;
	}
}

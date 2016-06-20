package cart.projector;

import cart.dao.outputBeans.CartDaoOB;
import cart.projector.outputBeans.CartProjectorOB;



public class CartProjector {

	public CartProjectorOB addToCart(CartDaoOB cartDaoOB)
	{
		CartProjectorOB cartProjectorOB = new CartProjectorOB();
		cartProjectorOB.setProductAlreadyInCart(cartDaoOB.isProductAlreadyInCart());
		cartProjectorOB.setNumberOfItemsInCart("("+cartDaoOB.getNumberOfItemsInCart()+")");
		return cartProjectorOB;
	}
}

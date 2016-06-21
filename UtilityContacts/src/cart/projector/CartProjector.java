package cart.projector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cart.dao.outputBeans.CartDaoOB;
import cart.projector.outputBeans.CartItem;
import cart.projector.outputBeans.CartProjectorOB;

import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class CartProjector {

	public CartProjectorOB addToCart(CartDaoOB cartDaoOB)
	{
		CartProjectorOB cartProjectorOB = new CartProjectorOB();
		cartProjectorOB.setProductAlreadyInCart(cartDaoOB.isProductAlreadyInCart());
		cartProjectorOB.setNumberOfItemsInCart("("+cartDaoOB.getNumberOfItemsInCart()+")");
		return cartProjectorOB;
	}

	public CartProjectorOB viewCart(CartDaoOB cartDaoOB)
	{
		CartProjectorOB cartProjectorOB = new CartProjectorOB();
		List<CartItem> cartItems = new ArrayList<CartItem>();

		Iterator aIterator = cartDaoOB.getProductsDBBeans().iterator();
		Iterator bIterator = cartDaoOB.getRentOffersDBBeans().iterator();
		while (aIterator.hasNext() && bIterator.hasNext())
		{
			ProductsDBBean productsDBBean = (ProductsDBBean)aIterator.next();
			RentOffersDBBean rentOffersDBBean = (RentOffersDBBean)bIterator.next();

			CartItem cartItem = new CartItem();
			cartItem.setProductId(productsDBBean.getProductid());
			cartItem.setProductName(productsDBBean.getProductname());
			cartItem.setRentAmount(rentOffersDBBean.getAmount());
			cartItem.setPeriodValue(rentOffersDBBean.getPeriodvalue());
			cartItem.setPeriodUnit(rentOffersDBBean.getPeriodunit());
			cartItem.setSecurityMoney(productsDBBean.getSecuritymoney());
			cartItem.setImageUrl(cartDaoOB.getImageMap().get(String.valueOf(productsDBBean.getProductid())).getImagepath());
			cartItem.setProductCity(productsDBBean.getProductcity());
			cartItem.setProductState(productsDBBean.getProductstate());
			cartItem.setProductLocation(productsDBBean.getProductlocation());
			cartItem.setProductType(productsDBBean.getProducttype());
			cartItem.setProductSubtype(productsDBBean.getSubproducttype());
			cartItems.add(cartItem);
		}
		cartProjectorOB.setCartItems(cartItems);
		return cartProjectorOB;
	}
}

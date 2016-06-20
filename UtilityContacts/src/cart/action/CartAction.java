package cart.action;

import cart.CartAppContext;
import cart.appService.CartAppService;
import cart.appService.inputBeans.CartAppServiceIB;
import cart.projector.outputBeans.CartProjectorOB;

import com.opensymphony.xwork2.ActionSupport;


public class CartAction  extends ActionSupport {
	
	String productId;
	String rentOfferId;
	CartAppContext context;
	CartAppService cartAppService;

	public String addToCart()
	{
		CartAppServiceIB cartAppServiceIB = new CartAppServiceIB();
		cartAppServiceIB.setProductId(productId);
		cartAppServiceIB.setRentOfferId(rentOfferId);
		CartProjectorOB cartProjectorOB = cartAppService.addToCart(cartAppServiceIB);
		context.setCartProjectorOB(cartProjectorOB);
		return "success";
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public CartAppContext getContext() {
		return context;
	}

	public void setContext(CartAppContext context) {
		this.context = context;
	}

	public CartAppService getCartAppService() {
		return cartAppService;
	}

	public void setCartAppService(CartAppService cartAppService) {
		this.cartAppService = cartAppService;
	}

	public String getRentOfferId() {
		return rentOfferId;
	}

	public void setRentOfferId(String rentOfferId) {
		this.rentOfferId = rentOfferId;
	}

}

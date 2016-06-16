package addToCart.action;

import addToCart.AddToCartAppContext;
import addToCart.appService.AddToCartAppService;


public class AddToCartAction {
	
	String productId;
	AddToCartAppContext context;
	AddToCartAppService addToCartAppService;

	public String addToCart()
	{
		return "success";
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public AddToCartAppContext getContext() {
		return context;
	}

	public void setContext(AddToCartAppContext context) {
		this.context = context;
	}

	public AddToCartAppService getAddToCartAppService() {
		return addToCartAppService;
	}

	public void setAddToCartAppService(AddToCartAppService addToCartAppService) {
		this.addToCartAppService = addToCartAppService;
	}


}

package cart.projector.outputBeans;



public class CartProjectorOB {

	boolean productAlreadyInCart;
	private String numberOfItemsInCart;

	public String getNumberOfItemsInCart() {
		return numberOfItemsInCart;
	}
	public void setNumberOfItemsInCart(String numberOfItemsInCart) {
		this.numberOfItemsInCart = numberOfItemsInCart;
	} 

	public boolean isProductAlreadyInCart() {
		return productAlreadyInCart;
	}

	public void setProductAlreadyInCart(boolean productAlreadyInCart) {
		this.productAlreadyInCart = productAlreadyInCart;
	}
}

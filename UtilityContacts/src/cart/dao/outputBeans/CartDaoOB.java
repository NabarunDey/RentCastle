package cart.dao.outputBeans;



public class CartDaoOB {
	
	private boolean productAlreadyInCart;
	private int numberOfItemsInCart;
	
	public int getNumberOfItemsInCart() {
		return numberOfItemsInCart;
	}

	public void setNumberOfItemsInCart(int numberOfItemsInCart) {
		this.numberOfItemsInCart = numberOfItemsInCart;
	}

	public boolean isProductAlreadyInCart() {
		return productAlreadyInCart;
	}

	public void setProductAlreadyInCart(boolean productAlreadyInCart) {
		this.productAlreadyInCart = productAlreadyInCart;
	}
}

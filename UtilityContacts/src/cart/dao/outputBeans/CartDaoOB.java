package cart.dao.outputBeans;

import java.util.List;
import java.util.Map;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class CartDaoOB {
	
	private boolean productAlreadyInCart;
	private int numberOfItemsInCart;
	
	private List<ProductsDBBean> productsDBBeans;
	private List<RentOffersDBBean> rentOffersDBBeans;
	private Map<String,ImagesDBBean> imageMap;
	
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

	public List<ProductsDBBean> getProductsDBBeans() {
		return productsDBBeans;
	}

	public void setProductsDBBeans(List<ProductsDBBean> productsDBBeans) {
		this.productsDBBeans = productsDBBeans;
	}

	public List<RentOffersDBBean> getRentOffersDBBeans() {
		return rentOffersDBBeans;
	}

	public void setRentOffersDBBeans(List<RentOffersDBBean> rentOffersDBBeans) {
		this.rentOffersDBBeans = rentOffersDBBeans;
	}

	public Map<String, ImagesDBBean> getImageMap() {
		return imageMap;
	}

	public void setImageMap(Map<String, ImagesDBBean> imageMap) {
		this.imageMap = imageMap;
	}
	
}

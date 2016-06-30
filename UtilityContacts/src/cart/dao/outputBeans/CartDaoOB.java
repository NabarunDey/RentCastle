package cart.dao.outputBeans;

import java.util.List;
import java.util.Map;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class CartDaoOB {
	
	private boolean productAlreadyInCart;
	private int numberOfItemsInCart;
	
	private Map<String,ProductsDBBean> productMap;
	private Map<String,RentOffersDBBean> rentMap;
	private Map<String,ImagesDBBean> imageMap;
	private List<String> productRentIds;
	
	
	public List<String> getProductRentIds() {
		return productRentIds;
	}

	public void setProductRentIds(List<String> productRentIds) {
		this.productRentIds = productRentIds;
	}

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

	public Map<String, ProductsDBBean> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, ProductsDBBean> productMap) {
		this.productMap = productMap;
	}

	public Map<String, RentOffersDBBean> getRentMap() {
		return rentMap;
	}

	public void setRentMap(Map<String, RentOffersDBBean> rentMap) {
		this.rentMap = rentMap;
	}

	public Map<String, ImagesDBBean> getImageMap() {
		return imageMap;
	}

	public void setImageMap(Map<String, ImagesDBBean> imageMap) {
		this.imageMap = imageMap;
	}
	
}

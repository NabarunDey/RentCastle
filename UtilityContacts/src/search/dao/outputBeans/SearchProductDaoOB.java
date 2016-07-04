package search.dao.outputBeans;

import java.util.List;
import java.util.Map;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;


public class SearchProductDaoOB {

	private List<ProductsDBBean> productsDBBeans;
	private Map<String, RentOffersDBBean> rentMap;
	private Map<String, ImagesDBBean> imageMap;
	private boolean vendor;

	public boolean isVendor() {
		return vendor;
	}
	public void setVendor(boolean vendor) {
		this.vendor = vendor;
	}
	public List<ProductsDBBean> getProductsDBBeans() {
		return productsDBBeans;
	}
	public void setProductsDBBeans(List<ProductsDBBean> productsDBBeans) {
		this.productsDBBeans = productsDBBeans;
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

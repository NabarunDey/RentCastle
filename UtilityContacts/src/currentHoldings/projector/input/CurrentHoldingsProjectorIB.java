package currentHoldings.projector.input;

import java.util.List;
import java.util.Map;

import com.databaseBeans.CurrentHoldingsDBBean;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;

public class CurrentHoldingsProjectorIB {
	
	private Map<String, ProductsDBBean> productsMap;
	private Map<String, RentOffersDBBean> rentMap;
	private Map<String, OrdersDBBean> ordersMap;
	private List<CurrentHoldingsDBBean> currentHoldingsDBBeans;
	private Map<String, ImagesDBBean> productImagesMap;
	
	
	public Map<String, ImagesDBBean> getProductImagesMap() {
		return productImagesMap;
	}
	public void setProductImagesMap(Map<String, ImagesDBBean> productImagesMap) {
		this.productImagesMap = productImagesMap;
	}
	public Map<String, ProductsDBBean> getProductsMap() {
		return productsMap;
	}
	public void setProductsMap(Map<String, ProductsDBBean> productsMap) {
		this.productsMap = productsMap;
	}
	public Map<String, RentOffersDBBean> getRentMap() {
		return rentMap;
	}
	public void setRentMap(Map<String, RentOffersDBBean> rentMap) {
		this.rentMap = rentMap;
	}
	public Map<String, OrdersDBBean> getOrdersMap() {
		return ordersMap;
	}
	public void setOrdersMap(Map<String, OrdersDBBean> ordersMap) {
		this.ordersMap = ordersMap;
	}
	public List<CurrentHoldingsDBBean> getCurrentHoldingsDBBeans() {
		return currentHoldingsDBBeans;
	}
	public void setCurrentHoldingsDBBeans(
			List<CurrentHoldingsDBBean> currentHoldingsDBBeans) {
		this.currentHoldingsDBBeans = currentHoldingsDBBeans;
	}
	
}

package viewProduct.projector.outputBeans;

import java.util.List;
import java.util.Map;

import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;


public class ViewProductProjectorOB {
	
	private List<String> productImagesList;
	private ProductsDBBean productsDBBean;
	private List<RentOffersDBBean> rentOffersDBBeans;
	private Map<String, List<String>> productTypeMap;

	
	public Map<String, List<String>> getProductTypeMap() {
		return productTypeMap;
	}
	public void setProductTypeMap(Map<String, List<String>> productTypeMap) {
		this.productTypeMap = productTypeMap;
	}
	public List<String> getProductImagesList() {
		return productImagesList;
	}
	public void setProductImagesList(List<String> productImagesList) {
		this.productImagesList = productImagesList;
	}
	public ProductsDBBean getProductsDBBean() {
		return productsDBBean;
	}
	public void setProductsDBBean(ProductsDBBean productsDBBean) {
		this.productsDBBean = productsDBBean;
	}
	public List<RentOffersDBBean> getRentOffersDBBeans() {
		return rentOffersDBBeans;
	}
	public void setRentOffersDBBeans(List<RentOffersDBBean> rentOffersDBBeans) {
		this.rentOffersDBBeans = rentOffersDBBeans;
	}
	
	

}

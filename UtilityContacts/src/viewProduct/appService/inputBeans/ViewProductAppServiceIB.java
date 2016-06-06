package viewProduct.appService.inputBeans;

import java.util.List;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;

public class ViewProductAppServiceIB {

	private int productId;
	private ProductsDBBean productsDBBean;
	private List<RentOffersDBBean> rentOffersDBBeans;
	private List<ImagesDBBean> imagesDBBeans;
	

	public List<ImagesDBBean> getImagesDBBeans() {
		return imagesDBBeans;
	}

	public void setImagesDBBeans(List<ImagesDBBean> imagesDBBeans) {
		this.imagesDBBeans = imagesDBBeans;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	
	

	
}

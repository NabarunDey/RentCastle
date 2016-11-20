package currentHoldings.projector.outputBeans;

import com.databaseBeans.CurrentHoldingsDBBean;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class CurrentHoldingsProjectorOB {

	private ProductsDBBean productsDBBean;
	private RentOffersDBBean rentOffersDBBean;
	private OrdersDBBean ordersDBBean;
	private CurrentHoldingsDBBean currentHoldingsDBBean;
	private ImagesDBBean imagesDBBean;
	
	
	public ImagesDBBean getImagesDBBean() {
		return imagesDBBean;
	}
	public void setImagesDBBean(ImagesDBBean imagesDBBean) {
		this.imagesDBBean = imagesDBBean;
	}
	public CurrentHoldingsDBBean getCurrentHoldingsDBBean() {
		return currentHoldingsDBBean;
	}
	public void setCurrentHoldingsDBBean(CurrentHoldingsDBBean currentHoldingsDBBean) {
		this.currentHoldingsDBBean = currentHoldingsDBBean;
	}
	public OrdersDBBean getOrdersDBBean() {
		return ordersDBBean;
	}
	public void setOrdersDBBean(OrdersDBBean ordersDBBean) {
		this.ordersDBBean = ordersDBBean;
	}
	public ProductsDBBean getProductsDBBean() {
		return productsDBBean;
	}
	public void setProductsDBBean(ProductsDBBean productsDBBean) {
		this.productsDBBean = productsDBBean;
	}
	public RentOffersDBBean getRentOffersDBBean() {
		return rentOffersDBBean;
	}
	public void setRentOffersDBBean(RentOffersDBBean rentOffersDBBean) {
		this.rentOffersDBBean = rentOffersDBBean;
	}
	
	
	
}

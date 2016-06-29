package order.projector.outputBeans;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class OrderItem {

	private ProductsDBBean productsDBBean;
	private RentOffersDBBean rentOffersDBBean;
	private OrdersDBBean ordersDBBean;
	
	
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

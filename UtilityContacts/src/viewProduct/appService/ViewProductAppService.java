package viewProduct.appService;

import java.util.List;

import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.ViewProductProjector;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



public class ViewProductAppService {
	
	ProductsDao productsDao;
	RentOffersDao rentOffersDao;
	ViewProductProjector viewProductProjector;
	
	public ViewProductProjectorOB viewProduct(ViewProductAppServiceIB viewProductAppServiceIB) {
		
		ProductsDBBean productsDBBean = productsDao.getProductDetails(viewProductAppServiceIB.getProductId());
		List<RentOffersDBBean> rentOffersDBBeans =rentOffersDao.getAllRentOffersForProduct(viewProductAppServiceIB.getProductId());
		viewProductAppServiceIB.setProductsDBBean(productsDBBean);
		viewProductAppServiceIB.setRentOffersDBBeans(rentOffersDBBeans);
		ViewProductProjectorOB viewProductProjectorOB = viewProductProjector.viewProduct(viewProductAppServiceIB);
		return viewProductProjectorOB;
		
	}

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}

	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}

	public ViewProductProjector getViewProductProjector() {
		return viewProductProjector;
	}

	public void setViewProductProjector(ViewProductProjector viewProductProjector) {
		this.viewProductProjector = viewProductProjector;
	}
	
	
	
}

package viewProductByVendor.appService;

import com.dao.ProductsDao;
import com.sessionBeans.UserProfile;

import viewProductByVendor.projector.ViewProductByVendorProjector;


/**
 * @author nd29794
 *
 */
public class ViewProductByVendorAppService {
	
	ViewProductByVendorProjector viewProductByVendorProjector;
	ProductsDao productsDao;
	UserProfile userProfile;
	
	public ViewProductByVendorProjector getViewProductByVendorProjector() {
		return viewProductByVendorProjector;
	}
	public void setViewProductByVendorProjector(
			ViewProductByVendorProjector viewProductByVendorProjector) {
		this.viewProductByVendorProjector = viewProductByVendorProjector;
	}
	public ProductsDao getProductsDao() {
		return productsDao;
	}
	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
}

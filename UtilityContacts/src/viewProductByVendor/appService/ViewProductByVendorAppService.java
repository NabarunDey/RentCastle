package viewProductByVendor.appService;

import java.util.List;
import java.util.Map;

import search.dao.outputBeans.SearchProductDaoOB;
import search.projector.SearchProductProjector;
import search.projector.outputBeans.SearchProductProjectorOB;
import viewProductByVendor.appService.inputBeans.ViewProductByVendorAppServiceIB;

import com.dao.ImagesDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;


/**
 * @author nd29794
 *
 */
public class ViewProductByVendorAppService {

	ProductsDao productsDao;
	UserProfile userProfile;
	RentOffersDao rentOffersDao;
	ImagesDao imagesDao;
	SearchProductProjector searchProductProjector;

	
	public List<SearchProductProjectorOB> getProductListByVendor()
	{
		SearchProductDaoOB searchProductDaoOB = new SearchProductDaoOB();
		List<SearchProductProjectorOB> searchProductProjectorOBs= null;
		List<ProductsDBBean> productsDBBeans = productsDao.searchByVendor(userProfile.getUserName());
		if(null!=productsDBBeans && productsDBBeans.size()>=1)
		{
			searchProductDaoOB.setProductsDBBeans(productsDBBeans);
			Map<String,RentOffersDBBean> rentMap = rentOffersDao.getMinimumRents(productsDBBeans);
			searchProductDaoOB.setRentMap(rentMap);
			Map<String, ImagesDBBean> imageMap= imagesDao.getPrimaryImageOfProduct(productsDBBeans);
			searchProductDaoOB.setImageMap(imageMap);
			searchProductProjectorOBs= searchProductProjector.getSearchList(searchProductDaoOB);
		}
		return searchProductProjectorOBs;

	}
	
	public List<SearchProductProjectorOB> deleteProduct(ViewProductByVendorAppServiceIB viewProductByVendorAppServiceIB)
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = viewProductByVendorAppServiceIB.getSearchProductProjectorOBs();
		for(SearchProductProjectorOB searchProductProjectorOB : searchProductProjectorOBs)
		{
			if(viewProductByVendorAppServiceIB.getProductId().equals(String.valueOf(searchProductProjectorOB.getProductId()))
					&& searchProductProjectorOB.getUserName().equals(userProfile.getUserName()))
			{
				productsDao.deleteProduct(viewProductByVendorAppServiceIB.getProductId());
				searchProductProjectorOBs.remove(searchProductProjectorOB);
				break;
			}
		}
		return searchProductProjectorOBs;

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
	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}
	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}
	public ImagesDao getImagesDao() {
		return imagesDao;
	}
	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}

	public SearchProductProjector getSearchProductProjector() {
		return searchProductProjector;
	}

	public void setSearchProductProjector(
			SearchProductProjector searchProductProjector) {
		this.searchProductProjector = searchProductProjector;
	}




}

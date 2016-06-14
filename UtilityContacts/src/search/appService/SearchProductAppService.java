package search.appService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import search.appService.inputBeans.SearchProductAppServiceIB;
import search.dao.outputBeans.SearchProductDaoOB;
import search.projector.SearchProductProjector;
import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.ViewProductProjector;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.dao.ImagesDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



/**
 * @author nd29794
 *
 */
public class SearchProductAppService {
	
	ProductsDao productsDao;
	RentOffersDao rentOffersDao;
	ImagesDao imagesDao;
	SearchProductProjector searchProductProjector;
	
	public List<SearchProductProjectorOB> getSearchResult(SearchProductAppServiceIB searchProductAppServiceIB)
	{
		SearchProductDaoOB searchProductDaoOB = new SearchProductDaoOB();
		List<ProductsDBBean> productsDBBeans = productsDao.searchByProductName(searchProductAppServiceIB.getSearchString());
		searchProductDaoOB.setProductsDBBeans(productsDBBeans);
		Map<String,RentOffersDBBean> rentMap = rentOffersDao.getMinimumRents(productsDBBeans);
		searchProductDaoOB.setRentMap(rentMap);
		Map<String, ImagesDBBean> imageMap= imagesDao.getPrimaryImageOfProduct(productsDBBeans);
		searchProductDaoOB.setImageMap(imageMap);
		List<SearchProductProjectorOB> searchProductProjectorOBs= searchProductProjector.getSearchList(searchProductDaoOB);
		return searchProductProjectorOBs;
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

	public SearchProductProjector getSearchProductProjector() {
		return searchProductProjector;
	}


	public void setSearchProductProjector(
			SearchProductProjector searchProductProjector) {
		this.searchProductProjector = searchProductProjector;
	}


	public ImagesDao getImagesDao() {
		return imagesDao;
	}

	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}
	
	
	
}

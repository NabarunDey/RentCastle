package productManagement.appService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import productManagement.appService.inputBeans.ProductManagementAppServiceIB;
import search.dao.outputBeans.SearchProductDaoOB;
import search.projector.SearchProductProjector;
import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.appService.ViewProductAppService;
import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;
import addProduct.appService.inputBeans.AddRentOffersAppServiceIB;

import com.dao.ImagesDao;
import com.dao.OrdersDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;


/**
 * @author nd29794
 *
 */
public class ProductManagementAppService {

	ProductsDao productsDao;
	UserProfile userProfile;
	RentOffersDao rentOffersDao;
	ImagesDao imagesDao;
	SearchProductProjector searchProductProjector;
	ViewProductAppService viewProductAppService;
	OrdersDao ordersDao;

	
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
			searchProductDaoOB.setVendor(true);
			searchProductProjectorOBs= searchProductProjector.getSearchList(searchProductDaoOB);
		}
		return searchProductProjectorOBs;

	}
	
	public List<SearchProductProjectorOB> deleteProduct(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = productManagementAppServiceIB.getSearchProductProjectorOBs();
		for(SearchProductProjectorOB searchProductProjectorOB : searchProductProjectorOBs)
		{
			if(productManagementAppServiceIB.getProductId().equals(String.valueOf(searchProductProjectorOB.getProductId()))
					&& (searchProductProjectorOB.getUserName().equals(userProfile.getUserName()) || userProfile.getUserType().equals(UserType.ADMIN)))
			{
				ProductsDBBean productsDBBean = productsDao.deleteProduct(productManagementAppServiceIB.getProductId());
				rentOffersDao.deleteRentOffer(productManagementAppServiceIB.getProductId());
				List<String> imageIds = new ArrayList<String>();
				for(String imageId : productsDBBean.getImages().split("\\|"))
				{
					imageIds.add(imageId);
				}
				imagesDao.deleteImagesList(imageIds);
				searchProductProjectorOBs.remove(searchProductProjectorOB);
				break;
			}
		}
		return searchProductProjectorOBs;

	}

	public ViewProductProjectorOB editProductInput(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		ViewProductProjectorOB viewProductProjectorOB =null;
		List<SearchProductProjectorOB> searchProductProjectorOBs = productManagementAppServiceIB.getSearchProductProjectorOBs();
		for(SearchProductProjectorOB searchProductProjectorOB : searchProductProjectorOBs)
		{
			if(productManagementAppServiceIB.getProductId().equals(String.valueOf(searchProductProjectorOB.getProductId()))
					&& searchProductProjectorOB.getUserName().equals(userProfile.getUserName()))
			{
				ViewProductAppServiceIB viewProductAppServiceIB = new ViewProductAppServiceIB();
				viewProductAppServiceIB.setProductId(Integer.valueOf(productManagementAppServiceIB.getProductId()));
				viewProductProjectorOB=viewProductAppService.viewProduct(viewProductAppServiceIB);
				break;
			}
		}
		return viewProductProjectorOB;

	}
	public void editProductSubmit(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		List<String> imageIds = new ArrayList<String>();
		if(StringUtils.isNotEmpty(productManagementAppServiceIB.getOldImages()))
		{
			for(String imageId : productManagementAppServiceIB.getOldImages().split("\\|"))
			{
				imageIds.add(imageId);
			}
		}
		productManagementAppServiceIB.setImageIdsList(imageIds);
		productManagementAppServiceIB.setUsername(userProfile.getUserName());
		productsDao.editProduct(productManagementAppServiceIB);
	}
	
	public void editRentOfferSubmit(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		rentOffersDao.deleteRentOffer(productManagementAppServiceIB.getProductId());
		AddRentOffersAppServiceIB addRentOffersAppServiceIB = new AddRentOffersAppServiceIB();
		CommonUtility.copyBean(productManagementAppServiceIB, addRentOffersAppServiceIB);
		addRentOffersAppServiceIB.setProductid(Integer.parseInt(productManagementAppServiceIB.getProductId()));
		rentOffersDao.addRentOffer(addRentOffersAppServiceIB);
	}

	public List<SearchProductProjectorOB> viewPendingProducts()
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = null;
		if(userProfile.getUserType().equals(UserType.ADMIN))
		{
			SearchProductDaoOB searchProductDaoOB = new SearchProductDaoOB();
			List<ProductsDBBean> productsDBBeans = productsDao.viewPendingProducts();
			if(null!=productsDBBeans && productsDBBeans.size()>=1)
			{
				searchProductDaoOB.setProductsDBBeans(productsDBBeans);
				Map<String,RentOffersDBBean> rentMap = rentOffersDao.getMinimumRents(productsDBBeans);
				searchProductDaoOB.setRentMap(rentMap);
				Map<String, ImagesDBBean> imageMap= imagesDao.getPrimaryImageOfProduct(productsDBBeans);
				searchProductDaoOB.setImageMap(imageMap);
				searchProductDaoOB.setVendor(true);
				searchProductProjectorOBs= searchProductProjector.getSearchList(searchProductDaoOB);
			}
		}
		return searchProductProjectorOBs;
	}
	
	public void changeApprovalStatus(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		productsDao.changeApprovalStatus(productManagementAppServiceIB.getProductId(), productManagementAppServiceIB.getApprovalStatus());
	}
	
	public List<SearchProductProjectorOB> getFeaturedProducts()
	{
		List<ProductsDBBean> productsDBBeans = new ArrayList<ProductsDBBean>();
		Map<Integer,Integer> sortedMap= ordersDao.getMostOrderedProducts();
		
		int max=0;
		List<Integer> mostOrderedIds = null;
		if(null != sortedMap && sortedMap.size()>=1)
		{
			max = sortedMap.size();
			mostOrderedIds =new ArrayList<Integer>(sortedMap.keySet());
			List<ProductsDBBean> mostOrderredProducts = productsDao.getProductListByIdsInteger(mostOrderedIds);
			productsDBBeans.addAll(mostOrderredProducts);
		}
		
		if(max<4)
		{
			List<ProductsDBBean> firstNProducts = productsDao.getProductListSortedById(4-max,mostOrderedIds );
			productsDBBeans.addAll(firstNProducts);
		}
		
		List<SearchProductProjectorOB> searchProductProjectorOBs = null;
		SearchProductDaoOB searchProductDaoOB = new SearchProductDaoOB();
		if(null!= productsDBBeans && productsDBBeans.size()>=1)
		{
			searchProductDaoOB.setProductsDBBeans(productsDBBeans);
			Map<String, ImagesDBBean> imageMap= imagesDao.getPrimaryImageOfProduct(productsDBBeans);
			searchProductDaoOB.setImageMap(imageMap);
			searchProductProjectorOBs= searchProductProjector.getFeaturedProduct(searchProductDaoOB);
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

	public ViewProductAppService getViewProductAppService() {
		return viewProductAppService;
	}

	public void setViewProductAppService(ViewProductAppService viewProductAppService) {
		this.viewProductAppService = viewProductAppService;
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
}

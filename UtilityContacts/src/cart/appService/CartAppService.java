package cart.appService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cart.appService.inputBeans.CartAppServiceIB;
import cart.dao.outputBeans.CartDaoOB;
import cart.projector.CartProjector;
import cart.projector.outputBeans.CartProjectorOB;

import com.dao.ImagesDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.dao.UsersDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;
import com.sessionBeans.UserProfile;
import com.util.CommonUtility;


/**
 * @author nd29794
 *
 */
public class CartAppService {
	
	UsersDao usersDao;
	UserProfile userProfile;
	CartProjector cartProjector;
	ProductsDao productsDao;
	RentOffersDao rentOffersDao;
	ImagesDao imagesDao;
	
	public CartProjectorOB addToCart(CartAppServiceIB cartAppServiceIB)
	
	{
		cartAppServiceIB.setUserProfile(userProfile);
		CartDaoOB cartDaoOB = usersDao.addToCart(cartAppServiceIB);
		CartProjectorOB cartProjectorOB = cartProjector.addToCart(cartDaoOB);
		return cartProjectorOB;
	}
	
	public CartProjectorOB viewCart()
	{
		List<String> productRentIds = usersDao.getProductRentIdsFromUserCart(userProfile.getUserName());
		List<String> productIds = new ArrayList<String>();
		List<String> rentIds = new ArrayList<String>();
		CartProjectorOB cartProjectorOB = new CartProjectorOB();
		int noOfItems = 0; 
		if(null!= productRentIds && productRentIds.size()>=1)
		{
			for(String productRentId : productRentIds)
			{
				String extractedProductId = productRentId.substring(0, productRentId.indexOf("-"));
				String extractedRenttId = productRentId.substring(productRentId.indexOf("-")+1);
				productIds.add(extractedProductId);
				rentIds.add(extractedRenttId);
				noOfItems++;
			}
			List<ProductsDBBean> productsDBBeans = productsDao.getProductListByIdsString(productIds);
			Map<String, ProductsDBBean> productMap = CommonUtility.getProductMap(productsDBBeans);
			List<RentOffersDBBean> rentOffersDBBeans = rentOffersDao.getRentOffersByIdsString(rentIds);
			Map<String, RentOffersDBBean> rentMap= CommonUtility.getRentMap(rentOffersDBBeans);
			Map<String,ImagesDBBean> imageMap = imagesDao.getPrimaryImageOfProduct(productsDBBeans);
			CartDaoOB cartDaoOB = new CartDaoOB();
			cartDaoOB.setImageMap(imageMap);
			cartDaoOB.setProductMap(productMap);
			cartDaoOB.setRentMap(rentMap);
			cartDaoOB.setProductRentIds(productRentIds);
			cartProjectorOB = cartProjector.viewCart(cartDaoOB);

		}
		cartProjectorOB.setNumberOfItemsInCart(String.valueOf(noOfItems));
		return cartProjectorOB;
	}
	
	public void removeFromCart(CartAppServiceIB cartAppServiceIB)
	{
		usersDao.removeFromCart(userProfile.getUserName(), cartAppServiceIB.getProductId(),cartAppServiceIB.getRentOfferId() );
		return;
	}
	
	public void emptyCart()
	{
		usersDao.emptyCart(userProfile.getUserName());
	}
	
	public UsersDao getUsersDao() {
		return usersDao;
	}
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public CartProjector getCartProjector() {
		return cartProjector;
	}
	public void setCartProjector(CartProjector cartProjector) {
		this.cartProjector = cartProjector;
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
	public ImagesDao getImagesDao() {
		return imagesDao;
	}
	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}
}

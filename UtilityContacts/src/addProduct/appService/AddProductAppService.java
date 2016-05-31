package addProduct.appService;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.AddRentOfferAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.dao.outputBeans.AddRentOfferDaoOB;
import addProduct.dao.outputBeans.ImagesDaoOB;
import addProduct.projector.AddProductProjector;
import addProduct.projector.outputBeans.AddProductProjectorOB;

import com.dao.ImagesDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;


public class AddProductAppService {

	private AddProductProjector addProductProjector;
	private ProductsDao productsDao;
	private RentOffersDao rentOffersDao;
	private ImagesDao imagesDao;
	private UserProfile userProfile;

	public AddProductProjectorOB getInputDetails(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB = null;
		try{
			
			
			if(UserType.VENDOR.equals(userProfile.getUserType()))
			{
				addProductProjectorOB = addProductProjector.getAddProductInput(addProductAppServiceIB);
			}
		}catch(Exception exception)
		{

		}
		return addProductProjectorOB;
	}

	public AddProductProjectorOB addProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		ImagesDaoOB imagesDaoOB= imagesDao.insertMultipleImages(addProductAppServiceIB);
		addProductAppServiceIB.setImageIdsList(imagesDaoOB.getImageIdsList());
		addProductAppServiceIB.setUsername(userProfile.getUserName());
		AddProductDaoOB addProductDaoOB = productsDao.addProduct(addProductAppServiceIB);
		AddRentOfferDaoOB addRentOfferDaoOB = addRentOffer(addProductAppServiceIB.getAddRentOfferAppServiceIB());
		AddProductProjectorOB addProductProjectorOB =null;
		return addProductProjectorOB;
	}

	public AddRentOfferDaoOB addRentOffer(AddRentOfferAppServiceIB addRentOfferAppServiceIB)
	{
		AddRentOfferDaoOB addRentOfferDaoOB = rentOffersDao.addRentOffer(addRentOfferAppServiceIB);
		return addRentOfferDaoOB;
	}



	public AddProductProjector getAddProductProjector() {
		return addProductProjector;
	}
	public void setAddProductProjector(AddProductProjector addProductProjector) {
		this.addProductProjector = addProductProjector;
	}

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	public ImagesDao getImagesDao() {
		return imagesDao;
	}

	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
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

	


}

package addProduct.appService;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.projector.AddProductProjector;
import addProduct.projector.outputBeans.AddProductProjectorOB;

import com.dao.ProductsDao;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.ApplicationContextProvider;


public class AddProductAppService {

	private AddProductProjector addProductProjector;
	private ProductsDao productsDao;

	public AddProductProjectorOB getInputDetails(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB = null;
		UserProfile userProfile = null;
		try{
			
			ApplicationContextProvider appContext = new ApplicationContextProvider();
			userProfile = appContext.getApplicationContext().getBean("userProfile", UserProfile.class);
			
			if(UserType.VENDOR.equals(userProfile.getUserType()))
			{
				addProductProjectorOB = addProductProjector.getAddProductInput(addProductAppServiceIB);
			}
		}catch(Exception exception)
		{

		}
		return addProductProjectorOB;
	}

	public AddProductProjectorOB verifyProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB =new AddProductProjectorOB();

		addProductProjectorOB.setValidaionSuccess(true);
		return addProductProjectorOB;
	}

	public AddProductProjectorOB addProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductDaoOB addProductDaoOB = productsDao.addProduct(addProductAppServiceIB);
		AddProductProjectorOB addProductProjectorOB =null;
		return addProductProjectorOB;
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



}

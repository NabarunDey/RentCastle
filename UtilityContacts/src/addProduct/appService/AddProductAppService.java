package addProduct.appService;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.projector.AddProductProjector;
import addProduct.projector.outputBeans.AddProductProjectorOB;

import com.dao.ProductsDao;


public class AddProductAppService {
	
	public AddProductProjector addProductProjector;
	public ProductsDao productsDao;
	
	public AddProductProjectorOB verifyProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB =new AddProductProjectorOB();
		addProductProjectorOB.setValidaionSuccess(true);
		return addProductProjectorOB;
	}
	
	public AddProductProjectorOB addProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductDaoOB addProductDaoOB = productsDao.addProduct(addProductAppServiceIB);
		AddProductProjectorOB addProductProjectorOB =addProductProjector.project(addProductDaoOB);
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

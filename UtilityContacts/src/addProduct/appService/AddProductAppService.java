package addProduct.appService;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.AddProductDao;
import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.projector.AddProductProjector;
import addProduct.projector.outputBeans.AddProductProjectorOB;


public class AddProductAppService {
	
	public AddProductProjector addProductProjector;
	public AddProductDao addProductDao;
	
	public AddProductProjectorOB addProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductDaoOB addProductDaoOB = addProductDao.addProduct(addProductAppServiceIB);
		AddProductProjectorOB addProductProjectorOB =addProductProjector.project(addProductDaoOB);
		return addProductProjectorOB;
	}
	
	
	
	
	public AddProductProjector getAddProductProjector() {
		return addProductProjector;
	}
	public void setAddProductProjector(AddProductProjector addProductProjector) {
		this.addProductProjector = addProductProjector;
	}
	public AddProductDao getAddProductDao() {
		return addProductDao;
	}
	public void setAddProductDao(AddProductDao addProductDao) {
		this.addProductDao = addProductDao;
	}

	

}

package addProduct.projector;

import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.projector.outputBeans.AddProductProjectorOB;


public class AddProductProjector {

	public AddProductProjectorOB project(AddProductDaoOB addProductDaoOB)
	{
		AddProductProjectorOB addProductProjectorOB =new  AddProductProjectorOB();
		return addProductProjectorOB;
	}
}

package addProduct.action;

import addProduct.appService.AddProductAppService;
import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.projector.outputBeans.AddProductProjectorOB;

public class AddProductAction {
	

	public AddProductAppService addProductAppService;
	
	public String addProductInput()
	{
		
		return "SUCCESS";
	}
	
	public String addProductRecap()
	{
		return "SUCCESS";
	}
	
	public String addProductConfirmation()
	{
		AddProductAppServiceIB addProductAppServiceIB = new AddProductAppServiceIB();
		AddProductProjectorOB addProductProjectorOB = addProductAppService.addProduct(addProductAppServiceIB);
		return "SUCCESS";
	}

	public AddProductAppService getAddProductAppService() {
		return addProductAppService;
	}

	public void setAddProductAppService(AddProductAppService addProductAppService) {
		this.addProductAppService = addProductAppService;
	}

   
	
}

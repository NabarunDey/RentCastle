package viewProduct.action;

import viewProduct.ViewProductAppContext;
import viewProduct.appService.ViewProductAppService;
import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;


public class ViewProductAction {
	
	int productId;
	ViewProductAppService viewProductAppService;
	ViewProductAppContext context;
	public String viewProduct()
	{
		ViewProductAppServiceIB viewProductAppServiceIB = new ViewProductAppServiceIB();
		viewProductAppServiceIB.setProductId(productId);
		ViewProductProjectorOB viewProductProjectorOB = viewProductAppService.viewProduct(viewProductAppServiceIB);
		return "success";
	}

	public ViewProductAppService getViewProductAppService() {
		return viewProductAppService;
	}

	public void setViewProductAppService(ViewProductAppService viewProductAppService) {
		this.viewProductAppService = viewProductAppService;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ViewProductAppContext getContext() {
		return context;
	}

	public void setContext(ViewProductAppContext context) {
		this.context = context;
	}

}

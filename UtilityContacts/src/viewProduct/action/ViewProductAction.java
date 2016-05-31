package viewProduct.action;

import viewProduct.ViewProductAppContext;
import viewProduct.appService.ViewProductAppService;
import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;


public class ViewProductAction {
	
	ViewProductAppService viewProductAppService;
	ViewProductAppContext viewProductAppContext;
	public String viewProduct()
	{
		ViewProductAppServiceIB viewProductAppServiceIB = new ViewProductAppServiceIB();
		ViewProductProjectorOB viewProductProjectorOB = viewProductAppService.viewProduct(viewProductAppServiceIB);
		return "success";
	}

	public ViewProductAppService getViewProductAppService() {
		return viewProductAppService;
	}

	public void setViewProductAppService(ViewProductAppService viewProductAppService) {
		this.viewProductAppService = viewProductAppService;
	}

	public ViewProductAppContext getViewProductAppContext() {
		return viewProductAppContext;
	}

	public void setViewProductAppContext(ViewProductAppContext viewProductAppContext) {
		this.viewProductAppContext = viewProductAppContext;
	}

	
	


}

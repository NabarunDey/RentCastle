package viewProduct.action;

import viewProduct.appService.ViewProductAppService;


public class ViewProductAction {
	
	ViewProductAppService viewProductAppService;

	public String viewProduct()
	{
		return "success";
	}

	public ViewProductAppService getViewProductAppService() {
		return viewProductAppService;
	}

	public void setViewProductAppService(ViewProductAppService viewProductAppService) {
		this.viewProductAppService = viewProductAppService;
	}

	


}

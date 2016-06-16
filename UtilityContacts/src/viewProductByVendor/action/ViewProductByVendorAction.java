package viewProductByVendor.action;

import viewProductByVendor.ViewProductByVendorAppContext;
import viewProductByVendor.appService.ViewProductByVendorAppService;



public class ViewProductByVendorAction {
	
	ViewProductByVendorAppContext context;
	ViewProductByVendorAppService viewProductByVendorAppService;
	public ViewProductByVendorAppContext getContext() {
		return context;
	}
	public void setContext(ViewProductByVendorAppContext context) {
		this.context = context;
	}
	public ViewProductByVendorAppService getViewProductByVendorAppService() {
		return viewProductByVendorAppService;
	}
	public void setViewProductByVendorAppService(
			ViewProductByVendorAppService viewProductByVendorAppService) {
		this.viewProductByVendorAppService = viewProductByVendorAppService;
	}
	
	
	
}

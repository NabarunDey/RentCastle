package viewProductByVendor.action;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;
import viewProductByVendor.ViewProductByVendorAppContext;
import viewProductByVendor.appService.ViewProductByVendorAppService;
import viewProductByVendor.appService.inputBeans.ViewProductByVendorAppServiceIB;



public class ViewProductByVendorAction {
	
	String productId;
	
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
	
	public String getProductListByVendor()
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = viewProductByVendorAppService.getProductListByVendor();
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}
	
	public String deleteProductFunction()
	{
		ViewProductByVendorAppServiceIB viewProductByVendorAppServiceIB = new ViewProductByVendorAppServiceIB();
		viewProductByVendorAppServiceIB.setProductId(productId);
		viewProductByVendorAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		List<SearchProductProjectorOB> searchProductProjectorOBs = viewProductByVendorAppService.deleteProduct(viewProductByVendorAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}

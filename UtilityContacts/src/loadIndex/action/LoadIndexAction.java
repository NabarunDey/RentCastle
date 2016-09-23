package loadIndex.action;

import java.util.List;

import loadIndex.LoadIndexContext;
import productManagement.appService.ProductManagementAppService;
import search.projector.outputBeans.SearchProductProjectorOB;



public class LoadIndexAction {
	

	LoadIndexContext context;
	ProductManagementAppService productManagementAppService;
	
	public String loadIndex()
	{
		List<SearchProductProjectorOB> featuredProducts = productManagementAppService.getFeaturedProducts();
		context.setFeaturedProducts(featuredProducts);
		return "success";
	}

	public LoadIndexContext getContext() {
		return context;
	}

	public void setContext(LoadIndexContext context) {
		this.context = context;
	}

	public ProductManagementAppService getProductManagementAppService() {
		return productManagementAppService;
	}

	public void setProductManagementAppService(
			ProductManagementAppService productManagementAppService) {
		this.productManagementAppService = productManagementAppService;
	}
	
	
	
}

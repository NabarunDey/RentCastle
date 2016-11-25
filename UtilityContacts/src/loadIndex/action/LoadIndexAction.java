package loadIndex.action;

import java.util.List;
import java.util.TimeZone;

import loadIndex.LoadIndexContext;
import loadIndex.appService.LoadIndexAppService;
import loadIndex.projector.outputBeans.AdsSectionProjectorOB;
import productManagement.appService.ProductManagementAppService;
import search.projector.outputBeans.SearchProductProjectorOB;



public class LoadIndexAction {
	

	LoadIndexContext context;
	ProductManagementAppService productManagementAppService;
	LoadIndexAppService loadIndexAppService;
	
	public String loadIndex()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));

		List<SearchProductProjectorOB> featuredProducts = productManagementAppService.getFeaturedProducts();
		AdsSectionProjectorOB adsSectionProjectorOB = loadIndexAppService.getAdsSection();
		context.setFeaturedProducts(featuredProducts);
		context.setAdsSectionProjectorOB(adsSectionProjectorOB);
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

	public LoadIndexAppService getLoadIndexAppService() {
		return loadIndexAppService;
	}

	public void setLoadIndexAppService(LoadIndexAppService loadIndexAppService) {
		this.loadIndexAppService = loadIndexAppService;
	}
	
}

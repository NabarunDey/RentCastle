package viewProductByVendor.appService.inputBeans;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;



public class ViewProductByVendorAppServiceIB {
	
	private String productId;
	private List<SearchProductProjectorOB> searchProductProjectorOBs;
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}
	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
	}
	
	
}

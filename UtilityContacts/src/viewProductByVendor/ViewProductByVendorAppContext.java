package viewProductByVendor;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;



public class ViewProductByVendorAppContext {
	
	private List<SearchProductProjectorOB> searchProductProjectorOBs;

	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}

	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
	}
}

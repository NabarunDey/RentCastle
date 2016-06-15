package search;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;


public class SearchProductAppContext {
	
	private List<SearchProductProjectorOB> searchProductProjectorOBs;

	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}

	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
	}
}

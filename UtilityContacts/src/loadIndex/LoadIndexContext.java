package loadIndex;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;

public class LoadIndexContext {
	
	private List<SearchProductProjectorOB> featuredProducts;

	public List<SearchProductProjectorOB> getFeaturedProducts() {
		return featuredProducts;
	}

	public void setFeaturedProducts(List<SearchProductProjectorOB> featuredProducts) {
		this.featuredProducts = featuredProducts;
	}
}

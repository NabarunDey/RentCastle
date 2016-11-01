package loadIndex;

import java.util.List;

import loadIndex.projector.outputBeans.AdsSectionProjectorOB;
import search.projector.outputBeans.SearchProductProjectorOB;

public class LoadIndexContext {
	
	private List<SearchProductProjectorOB> featuredProducts;
	private AdsSectionProjectorOB adsSectionProjectorOB;
	
	

	public AdsSectionProjectorOB getAdsSectionProjectorOB() {
		return adsSectionProjectorOB;
	}

	public void setAdsSectionProjectorOB(AdsSectionProjectorOB adsSectionProjectorOB) {
		this.adsSectionProjectorOB = adsSectionProjectorOB;
	}

	public List<SearchProductProjectorOB> getFeaturedProducts() {
		return featuredProducts;
	}

	public void setFeaturedProducts(List<SearchProductProjectorOB> featuredProducts) {
		this.featuredProducts = featuredProducts;
	}
}

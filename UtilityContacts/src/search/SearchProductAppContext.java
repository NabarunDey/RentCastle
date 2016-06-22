package search;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;


public class SearchProductAppContext {
	
	private List<SearchProductProjectorOB> searchProductProjectorOBs;
	private String searchState;
	private String searchCity;
	private String searchLocation;
	private String searchType;
	private String searchSubType;
	private String searchString;
	
	
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchState() {
		return searchState;
	}

	public void setSearchState(String searchState) {
		this.searchState = searchState;
	}

	public String getSearchCity() {
		return searchCity;
	}

	public void setSearchCity(String searchCity) {
		this.searchCity = searchCity;
	}

	public String getSearchLocation() {
		return searchLocation;
	}

	public void setSearchLocation(String searchLocation) {
		this.searchLocation = searchLocation;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchSubType() {
		return searchSubType;
	}

	public void setSearchSubType(String searchSubType) {
		this.searchSubType = searchSubType;
	}

	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}

	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
	}
	
}

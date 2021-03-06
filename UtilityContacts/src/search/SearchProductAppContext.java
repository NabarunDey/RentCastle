package search;

import java.util.List;

import search.projector.outputBeans.SearchFilter;
import search.projector.outputBeans.SearchProductProjectorOB;


public class SearchProductAppContext {
	
	private List<SearchProductProjectorOB> searchProductProjectorOBs;
	private String searchState;
	private String searchCity;
	private String searchPin;
	private String searchType;
	private String searchSubType;
	private String searchString;
	private SearchFilter searchFilter;

	public SearchFilter getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(SearchFilter searchFilter) {
		this.searchFilter = searchFilter;
	}

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

	public String getSearchPin() {
		return searchPin;
	}

	public void setSearchPin(String searchPin) {
		this.searchPin = searchPin;
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

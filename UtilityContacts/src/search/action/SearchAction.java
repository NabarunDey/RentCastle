package search.action;

import java.util.List;

import search.SearchProductAppContext;
import search.appService.SearchProductAppService;
import search.appService.inputBeans.SearchProductAppServiceIB;
import search.projector.outputBeans.SearchProductProjectorOB;


public class SearchAction {
	
	String searchString;
	SearchProductAppService searchProductAppService;
	SearchProductAppContext context;
	String searchState;
	String searchCity;
	String searchLocation;
	String searchType;
	String searchSubType;
	

	public String search()
	{
		SearchProductAppServiceIB searchProductAppServiceIB =new  SearchProductAppServiceIB();
		searchProductAppServiceIB.setSearchString(searchString);
		List<SearchProductProjectorOB> searchProductProjectorOBs = searchProductAppService.getSearchResult(searchProductAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}

	public String searchByCriteria()
	{
		SearchProductAppServiceIB searchProductAppServiceIB =new  SearchProductAppServiceIB();
		searchProductAppServiceIB.setSearchCity(searchCity);
		searchProductAppServiceIB.setSearchLocation(searchLocation);
		searchProductAppServiceIB.setSearchState(searchState);
		searchProductAppServiceIB.setSearchSubType(searchSubType);
		searchProductAppServiceIB.setSearchType(searchType);
		List<SearchProductProjectorOB> searchProductProjectorOBs = searchProductAppService.getSearchResultByCriteria(searchProductAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}

	public String getSearchString() {
		return searchString;
	}


	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}


	public SearchProductAppService getSearchProductAppService() {
		return searchProductAppService;
	}


	public void setSearchProductAppService(
			SearchProductAppService searchProductAppService) {
		this.searchProductAppService = searchProductAppService;
	}


	public SearchProductAppContext getContext() {
		return context;
	}


	public void setContext(SearchProductAppContext context) {
		this.context = context;
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

	


}

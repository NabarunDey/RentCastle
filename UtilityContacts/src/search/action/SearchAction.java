package search.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import search.SearchProductAppContext;
import search.appService.SearchProductAppService;
import search.appService.inputBeans.SearchProductAppServiceIB;
import search.projector.outputBeans.SearchFilter;
import search.projector.outputBeans.SearchProductProjectorOB;


public class SearchAction {
	
	String searchString;
	SearchProductAppService searchProductAppService;
	SearchProductAppContext context;
	String searchState;
	String searchCity;
	String searchPin;
	String searchType;
	String searchSubType;
	

	public String search()
	{
		SearchProductAppServiceIB searchProductAppServiceIB =new  SearchProductAppServiceIB();
		searchProductAppServiceIB.setSearchString(searchString);
		List<SearchProductProjectorOB> searchProductProjectorOBs = searchProductAppService.getSearchResult(searchProductAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		context.setSearchString(searchString);
		setsearchFilters(searchProductProjectorOBs);
		return "success";
	}

	public String searchByCriteria()
	{
		SearchProductAppServiceIB searchProductAppServiceIB =new  SearchProductAppServiceIB();
		searchProductAppServiceIB.setSearchCity(searchCity);
		searchProductAppServiceIB.setSearchPin(searchPin);
		searchProductAppServiceIB.setSearchState(searchState);
		searchProductAppServiceIB.setSearchSubType(searchSubType);
		searchProductAppServiceIB.setSearchType(searchType);
		List<SearchProductProjectorOB> searchProductProjectorOBs = searchProductAppService.getSearchResultByCriteria(searchProductAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		context.setSearchCity(searchCity);
		context.setSearchPin(searchPin);
		context.setSearchState(searchState);
		context.setSearchSubType(searchSubType);
		context.setSearchType(searchType);
		setsearchFilters(searchProductProjectorOBs);
		return "success";
	}
	
	private void setsearchFilters(List<SearchProductProjectorOB> searchProductProjectorOBs)
	{
		List<String> productType = new ArrayList<String>();
		List<String> productSubType = new ArrayList<String>();
		List<String> state = new ArrayList<String>();
		List<String> city = new ArrayList<String>();
		List<String> pin = new ArrayList<String>();
		
		for(SearchProductProjectorOB searchProductProjectorOB : searchProductProjectorOBs)
		{
			if(StringUtils.isNotEmpty(searchProductProjectorOB.getProductType()) && !productType.contains(searchProductProjectorOB.getProductType()))
			{
				productType.add(searchProductProjectorOB.getProductType());
			}
			if(StringUtils.isNotEmpty(searchProductProjectorOB.getProductSubtype()) && !productSubType.contains(searchProductProjectorOB.getProductSubtype()))
			{
				productSubType.add(searchProductProjectorOB.getProductSubtype());
			}
			if(StringUtils.isNotEmpty(searchProductProjectorOB.getProductState()) && !state.contains(searchProductProjectorOB.getProductState()))
			{
				state.add(searchProductProjectorOB.getProductState());
			}
			if(StringUtils.isNotEmpty(searchProductProjectorOB.getProductCity()) && !city.contains(searchProductProjectorOB.getProductCity()))
			{
				city.add(searchProductProjectorOB.getProductCity());
			}
			if(StringUtils.isNotEmpty(searchProductProjectorOB.getProductPin()) && !pin.contains(searchProductProjectorOB.getProductPin()))
			{
				pin.add(searchProductProjectorOB.getProductPin());
			}
		}
		SearchFilter searchFilter = new SearchFilter();
		searchFilter.setCity(city);
		searchFilter.setPin(pin);
		searchFilter.setProductSubType(productSubType);
		searchFilter.setProductType(productType);
		searchFilter.setState(state);
		context.setSearchFilter(searchFilter);
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

}

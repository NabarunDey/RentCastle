package search.action;

import search.SearchProductAppContext;
import search.appService.SearchProductAppService;


public class SearchAction {
	
	String searchString;
	SearchProductAppService searchProductAppService;
	SearchProductAppContext context;
	

	public String search()
	{
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

	


}

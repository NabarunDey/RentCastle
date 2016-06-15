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
	

	public String search()
	{
		SearchProductAppServiceIB searchProductAppServiceIB =new  SearchProductAppServiceIB();
		searchProductAppServiceIB.setSearchString(searchString);
		List<SearchProductProjectorOB> searchProductProjectorOBs = searchProductAppService.getSearchResult(searchProductAppServiceIB);
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

	


}

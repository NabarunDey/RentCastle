package search.projector;

import java.util.ArrayList;
import java.util.List;

import search.appService.inputBeans.SearchProductAppServiceIB;
import search.dao.outputBeans.SearchProductDaoOB;
import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.databaseBeans.ImagesDBBean;


public class SearchProductProjector {

	public List<SearchProductProjectorOB> getSearchList(SearchProductDaoOB searchProductDaoOB)
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = new ArrayList<SearchProductProjectorOB>();
		
		return searchProductProjectorOBs;

	}


}

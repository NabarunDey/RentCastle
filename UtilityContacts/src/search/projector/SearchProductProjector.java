package search.projector;

import java.util.ArrayList;
import java.util.List;

import search.dao.outputBeans.SearchProductDaoOB;
import search.projector.outputBeans.SearchProductProjectorOB;

import com.databaseBeans.ProductsDBBean;


public class SearchProductProjector {

	public List<SearchProductProjectorOB> getSearchList(SearchProductDaoOB searchProductDaoOB)
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = new ArrayList<SearchProductProjectorOB>();
		for(int i=1;i<=10;i++)
		{
			for(ProductsDBBean productsDBBean : searchProductDaoOB.getProductsDBBeans())
			{
				SearchProductProjectorOB searchProductProjectorOB = new SearchProductProjectorOB();
				searchProductProjectorOB.setProductId(productsDBBean.getProductid());
				searchProductProjectorOB.setProductName(productsDBBean.getProductname());
				searchProductProjectorOB.setRentAmount(searchProductDaoOB.getRentMap().get(String.valueOf(productsDBBean.getProductid())).getAmount());
				searchProductProjectorOB.setPeriodValue(searchProductDaoOB.getRentMap().get(String.valueOf(productsDBBean.getProductid())).getPeriodvalue());
				searchProductProjectorOB.setPeriodUnit(searchProductDaoOB.getRentMap().get(String.valueOf(productsDBBean.getProductid())).getPeriodunit());
				searchProductProjectorOB.setImageUrl(searchProductDaoOB.getImageMap().get(String.valueOf(productsDBBean.getProductid())).getImagepath());
				searchProductProjectorOB.setProductCity(productsDBBean.getProductcity());
				searchProductProjectorOB.setProductState(productsDBBean.getProductstate());
				searchProductProjectorOB.setProductLocation(productsDBBean.getProductlocation());
				searchProductProjectorOB.setProductType(productsDBBean.getProducttype());
				searchProductProjectorOB.setProductSubtype(productsDBBean.getSubproducttype());
				searchProductProjectorOB.setUserName(productsDBBean.getUsername());
				searchProductProjectorOBs.add(searchProductProjectorOB);
			}
		}
		return searchProductProjectorOBs;
	}
}

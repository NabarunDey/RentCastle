package currentHoldings.projector;

import java.util.ArrayList;
import java.util.List;

import com.databaseBeans.CurrentHoldingsDBBean;

import currentHoldings.projector.input.CurrentHoldingsProjectorIB;
import currentHoldings.projector.outputBeans.CurrentHoldingsProjectorOB;





public class CurrentHoldingsProjector {
	
	public List<CurrentHoldingsProjectorOB> getMyCurrentHoldingsProjector(CurrentHoldingsProjectorIB currentHoldingsProjectorIB)
	{
		List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs =new ArrayList<CurrentHoldingsProjectorOB>();
		
		if(null!= currentHoldingsProjectorIB && null != currentHoldingsProjectorIB.getCurrentHoldingsDBBeans() && currentHoldingsProjectorIB.getCurrentHoldingsDBBeans().size()>0)
		{
			for(CurrentHoldingsDBBean currentHoldingsDBBean : currentHoldingsProjectorIB.getCurrentHoldingsDBBeans())
			{
				CurrentHoldingsProjectorOB currentHoldingsProjectorOB = new CurrentHoldingsProjectorOB();
				currentHoldingsProjectorOB.setCurrentHoldingsDBBean(currentHoldingsDBBean);
				currentHoldingsProjectorOB.setOrdersDBBean(currentHoldingsProjectorIB.getOrdersMap().get(String.valueOf(currentHoldingsDBBean.getOrderid())));
				currentHoldingsProjectorOB.setProductsDBBean(currentHoldingsProjectorIB.getProductsMap().get(String.valueOf(currentHoldingsDBBean.getProductid())));
				currentHoldingsProjectorOB.setRentOffersDBBean(currentHoldingsProjectorIB.getRentMap().get(String.valueOf(currentHoldingsDBBean.getRentOfferid())));
				currentHoldingsProjectorOB.setImagesDBBean(currentHoldingsProjectorIB.getProductImagesMap().get(String.valueOf(currentHoldingsDBBean.getProductid())));
				currentHoldingsProjectorOBs.add(currentHoldingsProjectorOB);
			}
		}
		return currentHoldingsProjectorOBs;
	}
	
}

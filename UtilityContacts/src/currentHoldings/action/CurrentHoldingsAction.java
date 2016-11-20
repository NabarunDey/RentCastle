package currentHoldings.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import currentHoldings.CurrentHoldingsAppContext;
import currentHoldings.appService.CurrentHoldingsAppService;
import currentHoldings.projector.outputBeans.CurrentHoldingsProjectorOB;



public class CurrentHoldingsAction extends ActionSupport    {

	CurrentHoldingsAppContext context;
	CurrentHoldingsAppService currentHoldingsAppService;

	public String viewMyCurrentHoldingsCustomer()
	{
		List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs = currentHoldingsAppService.viewMyCurrentHoldingsCustomer();
		context.setCurrentHoldingsProjectorOBs(currentHoldingsProjectorOBs);
		return "success";
	}

	public CurrentHoldingsAppContext getContext() {
		return context;
	}

	public void setContext(CurrentHoldingsAppContext context) {
		this.context = context;
	}

	public CurrentHoldingsAppService getCurrentHoldingsAppService() {
		return currentHoldingsAppService;
	}

	public void setCurrentHoldingsAppService(
			CurrentHoldingsAppService currentHoldingsAppService) {
		this.currentHoldingsAppService = currentHoldingsAppService;
	}

	
}

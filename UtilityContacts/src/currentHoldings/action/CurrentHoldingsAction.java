package currentHoldings.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import currentHoldings.CurrentHoldingsAppContext;
import currentHoldings.appService.CurrentHoldingsAppService;
import currentHoldings.projector.outputBeans.CurrentHoldingsProjectorOB;



public class CurrentHoldingsAction extends ActionSupport    {

	CurrentHoldingsAppContext context;
	CurrentHoldingsAppService currentHoldingsAppService;
	private String holdingId;

	public String viewMyCurrentHoldingsCustomer()
	{
		List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs = currentHoldingsAppService.viewMyCurrentHoldingsCustomer();
		context.setCurrentHoldingsProjectorOBs(currentHoldingsProjectorOBs);
		return "success";
	}
	
	public String viewMyCurrentHoldingsVendor()
	{
		List<CurrentHoldingsProjectorOB> currentHoldingsProjectorOBs = currentHoldingsAppService.viewMyCurrentHoldingsVendor();
		context.setCurrentHoldingsProjectorOBs(currentHoldingsProjectorOBs);
		return "success";
	}
	
	public String endCurrentHolding()
	{
		currentHoldingsAppService.endCurrentHolding(holdingId,false);
		return SUCCESS;
	}
	
	public String enableAutoRenew()
	{
		currentHoldingsAppService.enableAutorenewal(holdingId);
		return SUCCESS;
	}
	
	public String diableAutoRenew()
	{
		currentHoldingsAppService.disableAutorenewal(holdingId);
		return SUCCESS;
	}

	public String getHoldingId() {
		return holdingId;
	}

	public void setHoldingId(String holdingId) {
		this.holdingId = holdingId;
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

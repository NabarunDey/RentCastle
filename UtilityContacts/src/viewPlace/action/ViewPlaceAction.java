package viewPlace.action;

import viewPlace.ViewPlaceAppContext;
import viewPlace.appService.ViewPlaceAppService;
import viewPlace.appService.inputBeans.ViewPlaceAppServiceIB;
import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;


public class ViewPlaceAction {
	
	ViewPlaceAppService viewPlaceAppService;
	ViewPlaceAppContext context;
	
	private String placeId;
	
	
	public String viewPlace()
	{
		ViewPlaceAppServiceIB viewPlaceAppServiceIB = new ViewPlaceAppServiceIB();
		viewPlaceAppServiceIB.setPlaceId(Integer.parseInt(placeId));
		ViewPlaceProjectorOB viewPlaceProjectorOB =  viewPlaceAppService.viewPlace(viewPlaceAppServiceIB);
		context.setViewPlaceProjectorOB(viewPlaceProjectorOB);
		return "success";
	}
	


	public ViewPlaceAppService getViewPlaceAppService() {
		return viewPlaceAppService;
	}


	public void setViewPlaceAppService(ViewPlaceAppService viewPlaceAppService) {
		this.viewPlaceAppService = viewPlaceAppService;
	}


	public ViewPlaceAppContext getContext() {
		return context;
	}

	public void setContext(ViewPlaceAppContext context) {
		this.context = context;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	
}

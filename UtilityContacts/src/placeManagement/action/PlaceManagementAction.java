package placeManagement.action;

import java.util.List;

import placeManagement.PlaceManagementContext;
import placeManagement.appService.PlaceManagementAppService;
import placeManagement.appService.outputBeans.PlaceManagementProjectorOB;

import com.opensymphony.xwork2.ActionSupport;

public class PlaceManagementAction  extends ActionSupport{


	private PlaceManagementAppService placeManagementAppService;
	private PlaceManagementContext context;


	public String myPlaces()
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = placeManagementAppService.getPlacesForVendor();
		context.setPlaceManagementProjectorOBs(placeManagementProjectorOBs);
		return "success";
	}

	
}

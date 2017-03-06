package placeManagement.action;

import java.util.List;

import placeManagement.PlaceManagementContext;
import placeManagement.appService.PlaceManagementAppService;
import placeManagement.appService.inputBeans.SearchPlaceCriteria;
import placeManagement.appService.outputBeans.PlaceManagementProjectorOB;

import com.opensymphony.xwork2.ActionSupport;

public class PlaceManagementAction  extends ActionSupport{


	private PlaceManagementAppService placeManagementAppService;
	private PlaceManagementContext context;
	
	private String qt;
	private String category;
	private String query;
	private int placeid;
	private String approvalStatus;

	public String myPlaces()
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = placeManagementAppService.getPlacesForVendor();
		context.setPlaceManagementProjectorOBs(placeManagementProjectorOBs);
		return "success";
	}
	
	public String pendingPLaces()
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = placeManagementAppService.getPendingPlaces();
		context.setPlaceManagementProjectorOBs(placeManagementProjectorOBs);
		return "success";
	}
	
	public String deletePlace()
	{
		placeManagementAppService.deletePlace(placeid);
		return "success";
	}


	public String searchCategory()
	{
		SearchPlaceCriteria searchPlaceCriteria = new SearchPlaceCriteria();
		searchPlaceCriteria.setPlaceType(category);
		searchPlaceCriteria.setQuality(qt);
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs  = placeManagementAppService.getPlacesByCriteria(searchPlaceCriteria);
		context.setPlaceManagementProjectorOBs(placeManagementProjectorOBs);
		return "success";
	}
	
	public String search()
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs  = placeManagementAppService.searchPlaceByText(query);
		context.setPlaceManagementProjectorOBs(placeManagementProjectorOBs);
		return "success";
	}
	
	public String changePlaceApprovalStatus()
	{
		placeManagementAppService.changeApprovalStatus(placeid, approvalStatus);
		return "success";
	}
	
	public PlaceManagementAppService getPlaceManagementAppService() {
		return placeManagementAppService;
	}


	public void setPlaceManagementAppService(
			PlaceManagementAppService placeManagementAppService) {
		this.placeManagementAppService = placeManagementAppService;
	}


	public PlaceManagementContext getContext() {
		return context;
	}


	public void setContext(PlaceManagementContext context) {
		this.context = context;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getPlaceid() {
		return placeid;
	}

	public void setPlaceid(int placeid) {
		this.placeid = placeid;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
}

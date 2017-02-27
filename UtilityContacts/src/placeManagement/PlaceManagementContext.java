package placeManagement;

import java.util.List;

import placeManagement.appService.outputBeans.PlaceManagementProjectorOB;


public class PlaceManagementContext {
	
	private List<PlaceManagementProjectorOB> placeManagementProjectorOBs;

	public List<PlaceManagementProjectorOB> getPlaceManagementProjectorOBs() {
		return placeManagementProjectorOBs;
	}

	public void setPlaceManagementProjectorOBs(
			List<PlaceManagementProjectorOB> placeManagementProjectorOBs) {
		this.placeManagementProjectorOBs = placeManagementProjectorOBs;
	}

	
}

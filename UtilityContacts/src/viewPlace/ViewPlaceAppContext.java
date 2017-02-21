package viewPlace;

import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;



public class ViewPlaceAppContext {
	
	ViewPlaceProjectorOB viewPlaceProjectorOB;
	int placeId;

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public ViewPlaceProjectorOB getViewPlaceProjectorOB() {
		return viewPlaceProjectorOB;
	}

	public void setViewPlaceProjectorOB(ViewPlaceProjectorOB viewPlaceProjectorOB) {
		this.viewPlaceProjectorOB = viewPlaceProjectorOB;
	}
	
}

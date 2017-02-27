package placeManagement.appService.outputBeans;

import com.databaseBeans.PlacesDBBean;

public class PlaceManagementProjectorOB {
	
	private PlacesDBBean placesDBBean;
	private String profileImagePath;
	public PlacesDBBean getPlacesDBBean() {
		return placesDBBean;
	}
	public void setPlacesDBBean(PlacesDBBean placesDBBean) {
		this.placesDBBean = placesDBBean;
	}
	public String getProfileImagePath() {
		return profileImagePath;
	}
	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}
	
}

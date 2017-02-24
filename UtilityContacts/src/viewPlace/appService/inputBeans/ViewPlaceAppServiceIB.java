package viewPlace.appService.inputBeans;

import com.databaseBeans.PlacesDBBean;


public class ViewPlaceAppServiceIB {

	private int placeId;
	private String facilities;
	private PlacesDBBean placesDBBean;
	private String priceDetails;
	

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	
	public String getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(String priceDetails) {
		this.priceDetails = priceDetails;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public PlacesDBBean getPlacesDBBean() {
		return placesDBBean;
	}

	public void setPlacesDBBean(PlacesDBBean placesDBBean) {
		this.placesDBBean = placesDBBean;
	}
	
}

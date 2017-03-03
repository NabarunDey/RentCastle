package addPlaces;

import com.databaseBeans.PlacesDBBean;


public class AddPlacesAppContext {
	
	private PlacesDBBean placesDBBean;

	public PlacesDBBean getPlacesDBBean() {
		return placesDBBean;
	}

	public void setPlacesDBBean(PlacesDBBean placesDBBean) {
		this.placesDBBean = placesDBBean;
	}
	
}

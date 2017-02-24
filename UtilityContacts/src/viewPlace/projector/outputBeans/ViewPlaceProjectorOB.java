package viewPlace.projector.outputBeans;

import java.util.List;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.PlacesDBBean;



public class ViewPlaceProjectorOB {
	
	private PlacesDBBean placesDBBean;
	private String profileImage;
	private List<String> facilitiesList;
	private List<String> priceList;
	private List<ImagesDBBean> imagesList;
	private boolean isVendor;
	
	public boolean isVendor() {
		return isVendor;
	}

	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	public List<String> getFacilitiesList() {
		return facilitiesList;
	}

	public void setFacilitiesList(List<String> facilitiesList) {
		this.facilitiesList = facilitiesList;
	}

	public List<ImagesDBBean> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<ImagesDBBean> imagesList) {
		this.imagesList = imagesList;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public PlacesDBBean getPlacesDBBean() {
		return placesDBBean;
	}

	public void setPlacesDBBean(PlacesDBBean placesDBBean) {
		this.placesDBBean = placesDBBean;
	}

	public List<String> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<String> priceList) {
		this.priceList = priceList;
	}
	
}

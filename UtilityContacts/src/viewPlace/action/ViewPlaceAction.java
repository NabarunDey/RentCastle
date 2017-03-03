package viewPlace.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.databaseBeans.PlacesDBBean;
import com.opensymphony.xwork2.ActionSupport;

import viewPlace.ViewPlaceAppContext;
import viewPlace.appService.ViewPlaceAppService;
import viewPlace.appService.inputBeans.ViewPlaceAppServiceIB;
import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;


public class ViewPlaceAction{
	
	ViewPlaceAppService viewPlaceAppService;
	ViewPlaceAppContext context;
	
	private String placeId;
	private List<File> galleryImages; 
	private String facilitiesDescription;
	private String price;
	
	
	public String viewPlace()
	{
		if(StringUtils.isNotEmpty(placeId))
			context.setPlaceId(Integer.parseInt(placeId));
		ViewPlaceAppServiceIB viewPlaceAppServiceIB = new ViewPlaceAppServiceIB();
		viewPlaceAppServiceIB.setPlaceId(context.getPlaceId());
		ViewPlaceProjectorOB viewPlaceProjectorOB =  viewPlaceAppService.viewPlace(viewPlaceAppServiceIB);
		context.setViewPlaceProjectorOB(viewPlaceProjectorOB);
		return "success";
	}
	
	
	public String addGalleryImages()
	{
		viewPlaceAppService.addGalleryImages(context.getViewPlaceProjectorOB().getPlacesDBBean(), galleryImages);
		return "success";
	}

	public String addFacilites()
	{
		ViewPlaceAppServiceIB viewPlaceAppServiceIB = new ViewPlaceAppServiceIB();
		viewPlaceAppServiceIB.setFacilities(facilitiesDescription);
		viewPlaceAppServiceIB.setPlacesDBBean(context.getViewPlaceProjectorOB().getPlacesDBBean());
		viewPlaceAppService.addFacilities(viewPlaceAppServiceIB);
		return "success";
	}
	
	public String addPrice()
	{
		ViewPlaceAppServiceIB viewPlaceAppServiceIB = new ViewPlaceAppServiceIB();
		viewPlaceAppServiceIB.setPriceDetails(price);
		viewPlaceAppServiceIB.setPlacesDBBean(context.getViewPlaceProjectorOB().getPlacesDBBean());
		viewPlaceAppService.addPrice(viewPlaceAppServiceIB);
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


	public List<File> getGalleryImages() {
		return galleryImages;
	}


	public void setGalleryImages(List<File> galleryImages) {
		this.galleryImages = galleryImages;
	}


	public String getFacilitiesDescription() {
		return facilitiesDescription;
	}


	public void setFacilitiesDescription(String facilitiesDescription) {
		this.facilitiesDescription = facilitiesDescription;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	
}

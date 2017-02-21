package viewPlace.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import viewPlace.ViewPlaceAppContext;
import viewPlace.appService.ViewPlaceAppService;
import viewPlace.appService.inputBeans.ViewPlaceAppServiceIB;
import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;


public class ViewPlaceAction {
	
	ViewPlaceAppService viewPlaceAppService;
	ViewPlaceAppContext context;
	
	private String placeId;
	private List<File> galleryImages; 
	
	
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
	
}

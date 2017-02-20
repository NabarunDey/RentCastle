package viewPlace.appService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import viewPlace.appService.inputBeans.ViewPlaceAppServiceIB;
import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.dao.FacilitiesDao;
import com.dao.ImagesDao;
import com.dao.ImagesGalleryDao;
import com.dao.PlacesDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.PlacesDBBean;
import com.util.CommonUtility;



/**
 * @author nd29794
 *
 */
public class ViewPlaceAppService {
	
	private PlacesDao placesDao;
	private FacilitiesDao facilitiesDao;
	private ImagesDao imagesDao;
	private ImagesGalleryDao imagesGalleryDao;
	
	
	public ViewPlaceProjectorOB viewPlace(ViewPlaceAppServiceIB viewPlaceAppServiceIB) {
		
		PlacesDBBean placesDBBean = placesDao.getPlaceDetails(viewPlaceAppServiceIB.getPlaceId());
		List<String> imagesIdList =new ArrayList<String>();
		String imagesString = imagesGalleryDao.getImagesGallery(placesDBBean.getImagesGalleryId()).getImageids();
		if(StringUtils.isNotEmpty(imagesString))
		{
			imagesIdList = Arrays.asList(imagesString.split("|"));

		}
		imagesIdList.add(placesDBBean.getProfileImage());
		List<ImagesDBBean> imagesDBBeans= imagesDao.getImagesByIdList(imagesIdList);
		
		String profileImagePath = CommonUtility.getProfileImage(placesDBBean.getProfileImage(), imagesDBBeans);
		String facilitiesString = facilitiesDao.getFacilities(placesDBBean.getFacilitiesId()).getFacilitiesDescription();
		List<String> facilitiesList = new ArrayList<String>();
		if(StringUtils.isNotEmpty(facilitiesString))
		{
			facilitiesList= Arrays.asList(facilitiesString.split("|"));
		}
		 
		
		ViewPlaceProjectorOB viewPlaceProjectorOB = new ViewPlaceProjectorOB();
		viewPlaceProjectorOB.setFacilitiesList(facilitiesList);
		viewPlaceProjectorOB.setImagesList(imagesDBBeans);
		viewPlaceProjectorOB.setPlacesDBBean(placesDBBean);
		viewPlaceProjectorOB.setProfileImage(profileImagePath);

		return viewPlaceProjectorOB;
		
	}


	public PlacesDao getPlacesDao() {
		return placesDao;
	}


	public void setPlacesDao(PlacesDao placesDao) {
		this.placesDao = placesDao;
	}


	public FacilitiesDao getFacilitiesDao() {
		return facilitiesDao;
	}


	public void setFacilitiesDao(FacilitiesDao facilitiesDao) {
		this.facilitiesDao = facilitiesDao;
	}


	public ImagesDao getImagesDao() {
		return imagesDao;
	}


	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}


	public ImagesGalleryDao getImagesGalleryDao() {
		return imagesGalleryDao;
	}


	public void setImagesGalleryDao(ImagesGalleryDao imagesGalleryDao) {
		this.imagesGalleryDao = imagesGalleryDao;
	}
}

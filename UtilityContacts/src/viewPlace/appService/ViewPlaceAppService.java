package viewPlace.appService;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import viewPlace.appService.inputBeans.ViewPlaceAppServiceIB;
import viewPlace.projector.outputBeans.ViewPlaceProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.dao.FacilitiesDao;
import com.dao.ImagesDao;
import com.dao.ImagesGalleryDao;
import com.dao.PlacesDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ImagesGalleryDBBean;
import com.databaseBeans.PlacesDBBean;
import com.sessionBeans.UserProfile;
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
	private UserProfile userProfile; 

	public ViewPlaceProjectorOB viewPlace(ViewPlaceAppServiceIB viewPlaceAppServiceIB) {

		PlacesDBBean placesDBBean = placesDao.getPlaceDetails(viewPlaceAppServiceIB.getPlaceId());
		List<String> imagesIdList =new ArrayList<String>();
		String imagesString = imagesGalleryDao.getImagesGallery(placesDBBean.getImagesGalleryId()).getImageids();
		if(StringUtils.isNotEmpty(imagesString))
		{
			imagesIdList = new ArrayList<>( Arrays.asList(imagesString.split("\\|")));

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

	public void addGalleryImages(PlacesDBBean placesDBBean,List<File> files) 
	{
		if(placesDBBean.getUsername().equals(userProfile.getUserName()))
		{
			List<FileBean> fileBeans = new ArrayList<FileBean>();
			if(null!= files && files.size()>0)
			{
				for(File file : files)
				{
					FileBean fileBean = new FileBean();
					fileBean.setFile(file);
					fileBeans.add(fileBean);
				}
				ImagesDaoOB imagesDaoOB =  imagesDao.insertMultipleProductImages(fileBeans);

				String imageIdConcat = "";
				
				ImagesGalleryDBBean imagesGalleryDBBean = imagesGalleryDao.getImagesGallery(placesDBBean.getImagesGalleryId());
				
				if(StringUtils.isNotEmpty(imagesGalleryDBBean.getImageids()))
				{
					imageIdConcat=imageIdConcat+imagesGalleryDBBean.getImageids();
				}
				for(String imageId: imagesDaoOB.getImageIdsList())
				{
					imageIdConcat= imageIdConcat+imageId+"|";

				}
				imagesGalleryDao.editImageGallery(imageIdConcat, placesDBBean.getImagesGalleryId());
			}
		}
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}

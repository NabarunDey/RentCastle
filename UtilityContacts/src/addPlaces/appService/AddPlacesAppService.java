package addPlaces.appService;

import java.util.ArrayList;
import java.util.List;

import addPlaces.appService.inputBeans.AddPlacesAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.dao.FacilitiesDao;
import com.dao.ImagesDao;
import com.dao.ImagesGalleryDao;
import com.dao.PlacesDao;
import com.dao.PriceDetailsDao;
import com.databaseBeans.FacilitiesDBBean;
import com.databaseBeans.ImagesGalleryDBBean;
import com.databaseBeans.PlacesDBBean;
import com.databaseBeans.PriceDetailsDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;


public class AddPlacesAppService {

	private PlacesDao placesDao;
	private FacilitiesDao facilitiesDao;
	private ImagesGalleryDao imagesGalleryDao;
	private ImagesDao imagesDao;
	private PriceDetailsDao priceDetailsDao;
	private UserProfile userProfile;

	public boolean getInputDetails()
	{

		if(UserType.VENDOR.equals(userProfile.getUserType()))
		{
			return true;			}
		return false;
	}

	public int addPlace(AddPlacesAppServiceIB addPlacesAppServiceIB)
	{
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		FileBean fileBean = new FileBean();
		fileBean.setFile(addPlacesAppServiceIB.getImageFile());
		fileBeans.add(fileBean);

		ImagesDaoOB imagesDaoOB= imagesDao.insertMultipleProductImages(fileBeans);
		addPlacesAppServiceIB.setProfileImage(imagesDaoOB.getImageIdsList().get(0));
		addPlacesAppServiceIB.setUsername(userProfile.getUserName());

		FacilitiesDBBean facilitiesDBBean = facilitiesDao.addFacilities();
		addPlacesAppServiceIB.setFacilitiesId(facilitiesDBBean.getFacilitiesId());

		PriceDetailsDBBean priceDetailsDBBean = priceDetailsDao.addPrice();
		addPlacesAppServiceIB.setPriceId(priceDetailsDBBean.getPriceId());

		ImagesGalleryDBBean imagesGalleryDBBean = imagesGalleryDao.addImagesGallery();
		addPlacesAppServiceIB.setImagesGalleryId(imagesGalleryDBBean.getImagesgalleryid());

		PlacesDBBean placesDBBean =  placesDao.addPlaces(addPlacesAppServiceIB);
		return placesDBBean.getPlaceid();
	}

	public PlacesDBBean editPlace(int placeId)
	{
		PlacesDBBean placesDBBean = placesDao.getPlaceDetails(placeId);
		if(null!= userProfile && (placesDBBean.getUsername().equals(userProfile.getUserName()) 
				|| userProfile.getUserType().equals(UserType.ADMIN)))
		{
			return placesDBBean;		
		}
		return null;

	}

	public void editPlaceSubmit(AddPlacesAppServiceIB addPlacesAppServiceIB ,PlacesDBBean placesDBBean)
	{
		if(null!= userProfile && (placesDBBean.getUsername().equals(userProfile.getUserName()) 
				|| userProfile.getUserType().equals(UserType.ADMIN)))
		{
			placesDao.editPlace(addPlacesAppServiceIB);
		}
	}


	public ImagesDao getImagesDao() {
		return imagesDao;
	}

	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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

	public ImagesGalleryDao getImagesGalleryDao() {
		return imagesGalleryDao;
	}

	public void setImagesGalleryDao(ImagesGalleryDao imagesGalleryDao) {
		this.imagesGalleryDao = imagesGalleryDao;
	}

	public PriceDetailsDao getPriceDetailsDao() {
		return priceDetailsDao;
	}

	public void setPriceDetailsDao(PriceDetailsDao priceDetailsDao) {
		this.priceDetailsDao = priceDetailsDao;
	}

}

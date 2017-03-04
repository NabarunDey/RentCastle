package placeManagement.appService;

import java.util.ArrayList;
import java.util.List;

import placeManagement.appService.inputBeans.SearchPlaceCriteria;
import placeManagement.appService.outputBeans.PlaceManagementProjectorOB;
import addPlaces.appService.inputBeans.AddPlacesAppServiceIB;
import addProduct.appService.inputBeans.AddProductAppServiceIB;

import com.dao.ImagesDao;
import com.dao.PlacesDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.PlacesDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;


public class PlaceManagementAppService {

	private PlacesDao placesDao;
	private ImagesDao imagesDao;
	private UserProfile userProfile;

	public List<PlaceManagementProjectorOB> getPlacesForVendor()
	{
		List<PlacesDBBean> placesDBBeans = null;
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = null;
		if(null!=userProfile && UserType.VENDOR.equals(userProfile.getUserType()))
		{
			placesDBBeans = placesDao.getPlacesForVendor(userProfile.getUserName());
			List<String> imageIds = new ArrayList<String>();
			
			if(null!= placesDBBeans && placesDBBeans.size()>0)
			{
				for(PlacesDBBean  placesDBBean : placesDBBeans)
				{
					imageIds.add(placesDBBean.getProfileImage());
				}
				
				List<ImagesDBBean> imagesDBBeans = imagesDao.getImagesByIdList(imageIds);
				
				placeManagementProjectorOBs = new ArrayList<PlaceManagementProjectorOB>();
				
				for(PlacesDBBean  placesDBBean : placesDBBeans)
				{
					PlaceManagementProjectorOB placeManagementProjectorOB = new PlaceManagementProjectorOB();
					placeManagementProjectorOB.setPlacesDBBean(placesDBBean);
					String profileImagePath = CommonUtility.getProfileImage(placesDBBean.getProfileImage(), imagesDBBeans);
					placeManagementProjectorOB.setProfileImagePath(profileImagePath);
					placeManagementProjectorOB.setEditable(true);
					placeManagementProjectorOBs.add(placeManagementProjectorOB);
				}
			}
		}
		return placeManagementProjectorOBs;
	}
	
	public List<PlaceManagementProjectorOB> getPlacesByCriteria(SearchPlaceCriteria searchPlaceCriteria)
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = null;
		List<PlacesDBBean> placesDBBeans = placesDao.getPlacesByCriteria(searchPlaceCriteria);
		List<String> imageIds = new ArrayList<String>();
		
		if(null!= placesDBBeans && placesDBBeans.size()>0)
		{
			for(PlacesDBBean  placesDBBean : placesDBBeans)
			{
				imageIds.add(placesDBBean.getProfileImage());
			}
			
			List<ImagesDBBean> imagesDBBeans = imagesDao.getImagesByIdList(imageIds);
			
			placeManagementProjectorOBs = new ArrayList<PlaceManagementProjectorOB>();
			
			for(PlacesDBBean  placesDBBean : placesDBBeans)
			{
				PlaceManagementProjectorOB placeManagementProjectorOB = new PlaceManagementProjectorOB();
				placeManagementProjectorOB.setPlacesDBBean(placesDBBean);
				String profileImagePath = CommonUtility.getProfileImage(placesDBBean.getProfileImage(), imagesDBBeans);
				placeManagementProjectorOB.setProfileImagePath(profileImagePath);
				placeManagementProjectorOBs.add(placeManagementProjectorOB);
			}
		}
		
		return placeManagementProjectorOBs;
	}
	
	public List<PlaceManagementProjectorOB> searchPlaceByText(String searchString)
	{
		List<PlaceManagementProjectorOB> placeManagementProjectorOBs = null;
		List<PlacesDBBean> placesDBBeans = placesDao.searchByPlaceText(searchString);
		List<String> imageIds = new ArrayList<String>();
		
		if(null!= placesDBBeans && placesDBBeans.size()>0)
		{
			for(PlacesDBBean  placesDBBean : placesDBBeans)
			{
				imageIds.add(placesDBBean.getProfileImage());
			}
			
			List<ImagesDBBean> imagesDBBeans = imagesDao.getImagesByIdList(imageIds);
			
			placeManagementProjectorOBs = new ArrayList<PlaceManagementProjectorOB>();
			
			for(PlacesDBBean  placesDBBean : placesDBBeans)
			{
				PlaceManagementProjectorOB placeManagementProjectorOB = new PlaceManagementProjectorOB();
				placeManagementProjectorOB.setPlacesDBBean(placesDBBean);
				String profileImagePath = CommonUtility.getProfileImage(placesDBBean.getProfileImage(), imagesDBBeans);
				placeManagementProjectorOB.setProfileImagePath(profileImagePath);
				placeManagementProjectorOBs.add(placeManagementProjectorOB);
			}
		}
		
		return placeManagementProjectorOBs;
	}
	
	public void changeApprovalStatus(int placeid, String approvalStatus)
	{
		if(null!=userProfile && UserType.ADMIN.equals(userProfile.getUserType()))
		{
			placesDao.changeApprovalStatus(placeid, approvalStatus);
		}
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


	public ImagesDao getImagesDao() {
		return imagesDao;
	}


	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}
	
}

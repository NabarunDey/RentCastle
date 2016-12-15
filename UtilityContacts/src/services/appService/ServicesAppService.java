package services.appService;

import java.util.List;

import services.appService.inputBeans.ServicesAppServiceIB;

import com.dao.ServicesDao;
import com.databaseBeans.ServicesDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;



/**
 * @author nd29794
 *
 */
public class ServicesAppService {

	ServicesDao servicesDao;
	UserProfile userProfile; 

	public List<ServicesDBBean> addService(ServicesAppServiceIB servicesAppServiceIB)
	{
		List<ServicesDBBean> servicesDBBeans=null;
		try{
			if(null!= userProfile && userProfile.getUserType().equals(UserType.SERVICEPROVIDER))
			{
				servicesDao.addService(servicesAppServiceIB, userProfile.getUserName());
				servicesDBBeans =getServicesForProvider();
			}
		}catch(Exception exception)
		{
			System.out.println("Error in adding Service");
		}
		return servicesDBBeans;
	}


	public List<ServicesDBBean> getServicesForProvider()
	{
		List<ServicesDBBean> servicesDBBeans = null;
		try{
			servicesDBBeans=servicesDao.getServicesForProvider(userProfile.getUserName());
		}catch(Exception exception)
		{
			System.out.println("Error in getting Service");
		}
		return servicesDBBeans;
	}

	public ServicesDao getServicesDao() {
		return servicesDao;
	}

	public void setServicesDao(ServicesDao servicesDao) {
		this.servicesDao = servicesDao;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}

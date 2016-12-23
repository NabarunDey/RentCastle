package services.appService;

import java.util.List;

import services.appService.inputBeans.ServicesAppServiceIB;

import com.dao.ServiceRequestDao;
import com.dao.ServicesDao;
import com.databaseBeans.ServiceRequestDBBean;
import com.databaseBeans.ServicesDBBean;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.SMSHandler;



/**
 * @author nd29794
 *
 */
public class ServicesAppService {

	ServicesDao servicesDao;
	UserProfile userProfile; 
	ServiceRequestDao serviceRequestDao; 

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

	public List<ServicesDBBean> getServicesForAdmin()
	{

		List<ServicesDBBean> servicesDBBeans = null;
		try{
			if(null!= userProfile && UserType.ADMIN.equals(userProfile.getUserType()))
				servicesDBBeans=servicesDao.getServicesForAdmin();
		}catch(Exception exception)
		{
			System.out.println("Error in getting Service");
		}
		return servicesDBBeans;
	}
	

	public boolean changeApprovalSatus(String id, String status)
	{

		boolean result=false;
		try{
			if(null!= userProfile && UserType.ADMIN.equals(userProfile.getUserType()))
			{
				servicesDao.changeServiceApprovalStatus(id, status);
				result=true;
			}
		}catch(Exception exception)
		{
			System.out.println("Error in updating Service");
		}
		return result;
	}

	public ServiceRequestDBBean addServiceReqest(ServicesAppServiceIB servicesAppServiceIB)
	{
		ServiceRequestDBBean serviceRequestDBBean = null;
		try{
			if(null!= userProfile && userProfile.getUserType().equals(UserType.CUSTOMER))
			{
				serviceRequestDBBean = serviceRequestDao.addServiceRequest(servicesAppServiceIB, userProfile.getUserName());
				sendServiceRequestSMStoAdmin(serviceRequestDBBean);
			}
		}catch(Exception exception)
		{
			System.out.println("Error in adding Service");
		}
		return serviceRequestDBBean;
	}
	
	public List<ServiceRequestDBBean> getServiceRequestsAdmin()
	{
		 List<ServiceRequestDBBean> serviceRequestDBBeans = null;
		try{
			if(null!= userProfile && userProfile.getUserType().equals(UserType.ADMIN))
			{
				serviceRequestDBBeans = serviceRequestDao.getServiceRequestAdmin();
			}
		}catch(Exception exception)
		{
			System.out.println("Error in getting ServiceReq");
		}
		return serviceRequestDBBeans;
	}

	public boolean changeServiceRequestStatus(String id, String status)
	{

		boolean result=false;
		try{
			if(null!= userProfile && UserType.ADMIN.equals(userProfile.getUserType()))
			{
				serviceRequestDao.changeServiceRequestStatus(id, status);
				result=true;
			}
		}catch(Exception exception)
		{
			System.out.println("Error in updating ServiceReq");
		}
		return result;
	}

	private void sendServiceRequestSMStoAdmin(final ServiceRequestDBBean serviceRequestDBBean)
	{
		Runnable myrunnable = new Runnable() {
			public void run() {
				SMSHandler.sendServiceRequestToAdmin(serviceRequestDBBean);
			}
		};
		new Thread(myrunnable).start();
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


	public ServiceRequestDao getServiceRequestDao() {
		return serviceRequestDao;
	}


	public void setServiceRequestDao(ServiceRequestDao serviceRequestDao) {
		this.serviceRequestDao = serviceRequestDao;
	}

}

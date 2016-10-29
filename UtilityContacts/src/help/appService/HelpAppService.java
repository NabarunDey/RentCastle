package help.appService;

import com.dao.HelpDao;
import com.sessionBeans.UserProfile;

import help.appService.inputBeans.HelpAppServiceIB;
import help.projector.outputBeans.HelpProjectorOB;




/**
 * @author nd29794
 *
 */
public class HelpAppService {
	
	private UserProfile userProfile;
	private HelpDao helpDao;
	
	public HelpProjectorOB getHelpInput()
	{
		HelpProjectorOB helpProjectorOB = new  HelpProjectorOB();
		if(null!= userProfile)
		{
			helpProjectorOB.setEmail(userProfile.getEmail());
			helpProjectorOB.setName(userProfile.getFirstName());
		}
		return helpProjectorOB;
	}
	
	public boolean submitHelpRequest(HelpAppServiceIB helpAppServiceIB)
	{
		boolean result = helpDao.submitHelpRequest(helpAppServiceIB);
		return result;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public HelpDao getHelpDao() {
		return helpDao;
	}

	public void setHelpDao(HelpDao helpDao) {
		this.helpDao = helpDao;
	}
	
}

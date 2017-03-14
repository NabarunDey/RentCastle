package help.appService;

import cart.projector.outputBeans.CartItem;

import com.dao.HelpDao;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;
import com.util.MailHandler;
import com.util.SMSHandler;

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
		sendHelpNotifications(helpAppServiceIB);
		return result;
	}
	
	private void sendHelpNotifications(final HelpAppServiceIB helpAppServiceIB)
	{
		Runnable myrunnable = new Runnable() {
			public void run() {
				MailHandler.feedBackMail(helpAppServiceIB);
			}
		};
		new Thread(myrunnable).start();
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

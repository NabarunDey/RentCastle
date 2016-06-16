package loadIndex.appService;

import login.appService.inputBeans.LoginAppServiceIB;
import login.projector.outputBeans.LoginProjectorOB;

import com.sessionBeans.UserProfile;


public class LoadIndexAppService {
	
	UserProfile userProfile;
	
	public LoginProjectorOB login(LoginAppServiceIB loginAppServiceIB) {
		
		LoginProjectorOB loginProjectorOB = new LoginProjectorOB();
		if(null!=userProfile)
		{
			loginProjectorOB.setUserProfile(userProfile);
		}
		
		return loginProjectorOB;
	}




	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}	

	
	
}

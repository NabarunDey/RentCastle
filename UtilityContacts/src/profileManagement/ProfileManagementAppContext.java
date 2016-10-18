package profileManagement;

import profileManagement.appService.inputBeans.ProfileManagementAppServiceIB;
import profileManagement.projector.outputBeans.ProfileManagementProjectorOB;

public class ProfileManagementAppContext {

	private ProfileManagementAppServiceIB profileManagementAppServiceIB;
	private ProfileManagementProjectorOB profileManagementProjectorOB;
	
	public ProfileManagementProjectorOB getProfileManagementProjectorOB() {
		return profileManagementProjectorOB;
	}

	public void setProfileManagementProjectorOB(
			ProfileManagementProjectorOB profileManagementProjectorOB) {
		this.profileManagementProjectorOB = profileManagementProjectorOB;
	}

	public ProfileManagementAppServiceIB getProfileManagementAppServiceIB() {
		return profileManagementAppServiceIB;
	}

	public void setProfileManagementAppServiceIB(
			ProfileManagementAppServiceIB profileManagementAppServiceIB) {
		this.profileManagementAppServiceIB = profileManagementAppServiceIB;
	}
	
	
}

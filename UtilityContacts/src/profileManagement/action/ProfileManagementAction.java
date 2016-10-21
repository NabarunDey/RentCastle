package profileManagement.action;

import profileManagement.ProfileManagementAppContext;
import profileManagement.appService.ProfileManagementAppService;
import profileManagement.appService.inputBeans.ProfileManagementAppServiceIB;
import profileManagement.projector.outputBeans.ProfileManagementProjectorOB;

import com.opensymphony.xwork2.ActionSupport;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;

public class ProfileManagementAction extends ActionSupport{

	String username;
	String firstname;
	String lastname;
	String sex;
	String password;
	UserType usertype;
	String address;
	String city;
	String state;
	String pinno;
	String phoneno;
	String mobileno1;
	String mobileno2;
	String status;
	String email;
	
	public ProfileManagementAppService profileManagementAppService;
	ProfileManagementAppContext context;
	
	public String profileManagementInput()
	{
		ProfileManagementProjectorOB profileManagementProjectorOB = profileManagementAppService.getUserData();
		context.setProfileManagementProjectorOB(profileManagementProjectorOB);
		return "success";
	}
	
	public String profileManagementConfirm()
	{
		ProfileManagementAppServiceIB profileManagementAppServiceIB = new ProfileManagementAppServiceIB();
		CommonUtility.copyBean(this, profileManagementAppServiceIB);
		ProfileManagementProjectorOB profileManagementProjectorOB =profileManagementAppService.editUser(profileManagementAppServiceIB);
		context.setProfileManagementProjectorOB(profileManagementProjectorOB);
		return "success";
	}
	
	public String changePasswordSubmit()
	{
		ProfileManagementProjectorOB profileManagementProjectorOB =profileManagementAppService.changePassword(password);
		context.setProfileManagementProjectorOB(profileManagementProjectorOB);
		return "success";
	}

	public ProfileManagementAppService getProfileManagementAppService() {
		return profileManagementAppService;
	}

	public void setProfileManagementAppService(
			ProfileManagementAppService profileManagementAppService) {
		this.profileManagementAppService = profileManagementAppService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinno() {
		return pinno;
	}

	public void setPinno(String pinno) {
		this.pinno = pinno;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getMobileno1() {
		return mobileno1;
	}

	public void setMobileno1(String mobileno1) {
		this.mobileno1 = mobileno1;
	}

	public String getMobileno2() {
		return mobileno2;
	}

	public void setMobileno2(String mobileno2) {
		this.mobileno2 = mobileno2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProfileManagementAppContext getContext() {
		return context;
	}

	public void setContext(ProfileManagementAppContext context) {
		this.context = context;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

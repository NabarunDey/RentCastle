package userRegistration.action;

import userRegistration.UserRegistrationAppContext;
import userRegistration.appService.UserRegistrationAppService;
import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;
import userRegistration.projector.outputBeans.UserRegistrationProjectorOB;

import com.opensymphony.xwork2.ActionSupport;
import com.structures.userTypes.UserType;
import com.util.CommonUtility;

public class UserRegistrationAction  extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public UserRegistrationAppService userRegistrationAppService;
	UserRegistrationAppContext context;
	
	public String userRegistrationInput()
	{
		
		return "success";
	}
	
	public String userRegistrationAdditionalInfo()
	{
		UserRegistrationAppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();
		CommonUtility.copyBean(this, userRegistrationAppServiceIB);
		context.setUserRegistrationAppServiceIB(userRegistrationAppServiceIB);
		return "success";
	}
	
	public String userRegistrationConfirm()
	{
		UserRegistrationAppServiceIB userRegistrationAppServiceIB = context.getUserRegistrationAppServiceIB();
		CommonUtility.copyBean(this, userRegistrationAppServiceIB);
		UserRegistrationProjectorOB registrationProjectorOB =userRegistrationAppService.addUser(userRegistrationAppServiceIB);
		return "success";
	}

	public UserRegistrationAppService getUserRegistrationAppService() {
		return userRegistrationAppService;
	}

	public void setUserRegistrationAppService(
			UserRegistrationAppService userRegistrationAppService) {
		this.userRegistrationAppService = userRegistrationAppService;
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

	public UserRegistrationAppContext getContext() {
		return context;
	}

	public void setContext(UserRegistrationAppContext context) {
		this.context = context;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

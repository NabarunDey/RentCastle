package loadIndex.action;

import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sessionBeans.UserProfile;

import loadIndex.LoadIndexContext;
import loadIndex.appService.LoadIndexAppService;
import loadIndex.projector.outputBeans.AdsSectionProjectorOB;
import login.appService.LoginAppService;
import login.appService.inputBeans.LoginAppServiceIB;
import login.projector.outputBeans.LoginProjectorOB;
import productManagement.appService.ProductManagementAppService;
import search.projector.outputBeans.SearchProductProjectorOB;



public class LoadIndexAction  extends ActionSupport  implements ServletRequestAware{

	private HttpServletRequest httpServletRequest;
	LoadIndexContext context;
	ProductManagementAppService productManagementAppService;
	LoadIndexAppService loadIndexAppService;
	LoginAppService loginAppService; 
	UserProfile userProfile;
	String rememberMe;

	public String loadIndex()
	{
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));

		LoginAppServiceIB loginAppServiceIB = new LoginAppServiceIB();

		String server=httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath();
		Cookie[] cookies = httpServletRequest.getCookies();     // request is an instance of type 
		String userNameFoundFromCookie = null;

		if((null== userProfile || StringUtils.isEmpty(userProfile.getUserName())) && null!= cookies)
		{
			for(int i = 0; i < cookies.length; i++)
			{ 
				Cookie c = cookies[i];
				if (c.getName().equals("usernameRemembered"))
				{
					userNameFoundFromCookie = c.getValue();
				}
			}  
		}
		if(StringUtils.isNotEmpty(userNameFoundFromCookie) )
		{
			loginAppServiceIB.setUsername(userNameFoundFromCookie);
			LoginProjectorOB loginProjectorOB = loginAppService.login(loginAppServiceIB,server,true);
		}

		if(StringUtils.isNotEmpty(rememberMe) && rememberMe.equals("on") && null!= userProfile && StringUtils.isNotEmpty(userProfile.getUserName()))
		{
			HttpServletResponse response = ServletActionContext.getResponse();

			{
				Cookie c = new Cookie("usernameRemembered", userProfile.getUserName());
				c.setMaxAge(24*60*60);
				response.addCookie(c); 
			}
		}

		List<SearchProductProjectorOB> featuredProducts = productManagementAppService.getFeaturedProducts();
		AdsSectionProjectorOB adsSectionProjectorOB = loadIndexAppService.getAdsSection();
		context.setFeaturedProducts(featuredProducts);
		context.setAdsSectionProjectorOB(adsSectionProjectorOB);
		return "success";
	}
	
	public String loadIndexLogout()
	{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie cookie = new Cookie("usernameRemembered", "");
		response.addCookie(cookie);

		List<SearchProductProjectorOB> featuredProducts = productManagementAppService.getFeaturedProducts();
		AdsSectionProjectorOB adsSectionProjectorOB = loadIndexAppService.getAdsSection();
		context.setFeaturedProducts(featuredProducts);
		context.setAdsSectionProjectorOB(adsSectionProjectorOB);
		return "success";
	}

	public LoadIndexContext getContext() {
		return context;
	}

	public void setContext(LoadIndexContext context) {
		this.context = context;
	}

	public ProductManagementAppService getProductManagementAppService() {
		return productManagementAppService;
	}

	public void setProductManagementAppService(
			ProductManagementAppService productManagementAppService) {
		this.productManagementAppService = productManagementAppService;
	}

	public LoadIndexAppService getLoadIndexAppService() {
		return loadIndexAppService;
	}

	public void setLoadIndexAppService(LoadIndexAppService loadIndexAppService) {
		this.loadIndexAppService = loadIndexAppService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		httpServletRequest=arg0;
	}

	public LoginAppService getLoginAppService() {
		return loginAppService;
	}

	public void setLoginAppService(LoginAppService loginAppService) {
		this.loginAppService = loginAppService;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}

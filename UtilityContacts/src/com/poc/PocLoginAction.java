package com.poc;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

import com.opensymphony.xwork2.ActionSupport;



public class PocLoginAction  extends ActionSupport  implements ServletRequestAware{
	
	private HttpServletRequest httpServletRequest;
	String name;
	String emailId;
	String codeMasked;
	String code;
	String tokenMasked;
	

	public String loginInputFunctionPoc()
	{
		return ActionSupport.SUCCESS;		
	}
	
	

	public String loginFunctionStep1()
	{
		httpServletRequest.getSession().setAttribute("code", code);

		String codeMid = code.substring(19, 35);
		codeMasked = code.replace(codeMid, "***********************");
		return ActionSupport.SUCCESS;		
	}
	
	public String loginFunctionStep2()
	{
		String server=httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath();
		String getCode= (String)httpServletRequest.getSession().getAttribute("code");
		String token=  GoogleHandlerPoc.accessToken(getCode, server);
		httpServletRequest.getSession().setAttribute("access_token", token);

		String codeMid = token.substring(19, 115);
		tokenMasked=token.replace(codeMid, "***********************");
		return ActionSupport.SUCCESS;		
	}
	
	public String loginFunctionStep3()
	{
		String getCode= (String)httpServletRequest.getSession().getAttribute("access_token");
		UserRegistrationAppServiceIB userRegistrationAppServiceIB=  GoogleHandlerPoc.getUserInfo(getCode);
		name=userRegistrationAppServiceIB.getFirstname()+' '+userRegistrationAppServiceIB.getLastname();
		emailId=userRegistrationAppServiceIB.getEmail();
		return ActionSupport.SUCCESS;		
	}
	
	
	public String logoutFunction()
	{
		httpServletRequest.getSession().invalidate();
		return "success";
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		 this.httpServletRequest = arg0;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getCodeMasked() {
		return codeMasked;
	}



	public void setCodeMasked(String codeMasked) {
		this.codeMasked = codeMasked;
	}

	public String getTokenMasked() {
		return tokenMasked;
	}

	public void setTokenMasked(String tokenMasked) {
		this.tokenMasked = tokenMasked;
	}

	
}

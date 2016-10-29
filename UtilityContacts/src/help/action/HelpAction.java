package help.action;

import help.HelpAppContext;
import help.appService.HelpAppService;
import help.appService.inputBeans.HelpAppServiceIB;
import help.projector.outputBeans.HelpProjectorOB;

import com.opensymphony.xwork2.ActionSupport;
import com.structures.category.HelpCategory;
import com.util.CommonUtility;



public class HelpAction extends ActionSupport {
	
	private String email;
	private String name;
	private String mobile;
	private HelpCategory category;
	private String message;
	private HelpAppContext context;
	private HelpAppService helpAppService;

	public String helpInput()
	{
		HelpProjectorOB helpProjectorOB = helpAppService.getHelpInput();
		context.setHelpProjectorOB(helpProjectorOB);
		return "success";
	}

	public String helpRequestSubmit()
	{
		HelpAppServiceIB helpAppServiceIB = new HelpAppServiceIB();
		CommonUtility.copyBean(this, helpAppServiceIB);
		boolean result = helpAppService.submitHelpRequest(helpAppServiceIB);
		context.setHelpRequestSubmitSuccess(result);
		return "success";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public HelpCategory getCategory() {
		return category;
	}

	public void setCategory(HelpCategory category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelpAppContext getContext() {
		return context;
	}

	public void setContext(HelpAppContext context) {
		this.context = context;
	}

	public HelpAppService getHelpAppService() {
		return helpAppService;
	}

	public void setHelpAppService(HelpAppService helpAppService) {
		this.helpAppService = helpAppService;
	}
	
}

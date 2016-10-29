package help.appService.inputBeans;

import com.structures.category.HelpCategory;


public class HelpAppServiceIB {
	
	private String email;
	private String name;
	private String mobile;
	private HelpCategory category;
	private String message;
	
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

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HelpCategory getCategory() {
		return category;
	}
	public void setCategory(HelpCategory category) {
		this.category = category;
	}
	
	
}

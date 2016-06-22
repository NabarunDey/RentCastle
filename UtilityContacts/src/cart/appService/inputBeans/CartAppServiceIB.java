package cart.appService.inputBeans;

import com.sessionBeans.UserProfile;



public class CartAppServiceIB {
	
	private UserProfile userProfile;
	private String productId;
	private String rentOfferId;
	
	public String getRentOfferId() {
		return rentOfferId;
	}
	public void setRentOfferId(String rentOfferId) {
		this.rentOfferId = rentOfferId;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
}

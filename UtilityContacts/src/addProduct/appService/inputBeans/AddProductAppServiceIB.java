package addProduct.appService.inputBeans;

import java.util.List;

public class AddProductAppServiceIB {

	private String productname;
	private String producttype;
	private String subproducttype;
	private String username;
	private String quantity;
	private List<FileBean> fileBeans;
	private String status;
	private String securitymoney;
	private List<String> imageIdsList;
	private String productstate;
	private String productcity;
	private String productpin;
	private String description;
	private String deliveryCharge;
	private AddRentOffersAppServiceIB addRentOfferAppServiceIB;
	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AddRentOffersAppServiceIB getAddRentOfferAppServiceIB() {
		return addRentOfferAppServiceIB;
	}
	public void setAddRentOfferAppServiceIB(
			AddRentOffersAppServiceIB addRentOfferAppServiceIB) {
		this.addRentOfferAppServiceIB = addRentOfferAppServiceIB;
	}
	public String getSubproducttype() {
		return subproducttype;
	}
	public void setSubproducttype(String subproducttype) {
		this.subproducttype = subproducttype;
	}
	public List<String> getImageIdsList() {
		return imageIdsList;
	}
	public void setImageIdsList(List<String> imageIdsList) {
		this.imageIdsList = imageIdsList;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSecuritymoney() {
		return securitymoney;
	}
	public void setSecuritymoney(String securitymoney) {
		this.securitymoney = securitymoney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<FileBean> getFileBeans() {
		return fileBeans;
	}
	public void setFileBeans(List<FileBean> fileBeans) {
		this.fileBeans = fileBeans;
	}
	public String getProductstate() {
		return productstate;
	}
	public void setProductstate(String productstate) {
		this.productstate = productstate;
	}
	public String getProductcity() {
		return productcity;
	}
	public void setProductcity(String productcity) {
		this.productcity = productcity;
	}
	public String getProductpin() {
		return productpin;
	}
	public void setProductpin(String productpin) {
		this.productpin = productpin;
	}
	public String getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
}

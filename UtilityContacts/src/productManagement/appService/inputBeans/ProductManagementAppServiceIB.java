package productManagement.appService.inputBeans;

import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;
import addProduct.appService.inputBeans.FileBean;



public class ProductManagementAppServiceIB {
	
	private String productId;
	private List<SearchProductProjectorOB> searchProductProjectorOBs;
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
	private String rentId;
	private	String periodunit;
	private	String periodvalue;
	private	String amount;
	private String oldImages;
	
	public String getOldImages() {
		return oldImages;
	}
	public void setOldImages(String oldImages) {
		this.oldImages = oldImages;
	}
	public String getPeriodunit() {
		return periodunit;
	}
	public void setPeriodunit(String periodunit) {
		this.periodunit = periodunit;
	}
	public String getPeriodvalue() {
		return periodvalue;
	}
	public void setPeriodvalue(String periodvalue) {
		this.periodvalue = periodvalue;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	

	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<SearchProductProjectorOB> getSearchProductProjectorOBs() {
		return searchProductProjectorOBs;
	}
	public void setSearchProductProjectorOBs(
			List<SearchProductProjectorOB> searchProductProjectorOBs) {
		this.searchProductProjectorOBs = searchProductProjectorOBs;
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
	public String getSubproducttype() {
		return subproducttype;
	}
	public void setSubproducttype(String subproducttype) {
		this.subproducttype = subproducttype;
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
	public List<FileBean> getFileBeans() {
		return fileBeans;
	}
	public void setFileBeans(List<FileBean> fileBeans) {
		this.fileBeans = fileBeans;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSecuritymoney() {
		return securitymoney;
	}
	public void setSecuritymoney(String securitymoney) {
		this.securitymoney = securitymoney;
	}
	public List<String> getImageIdsList() {
		return imageIdsList;
	}
	public void setImageIdsList(List<String> imageIdsList) {
		this.imageIdsList = imageIdsList;
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
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	
}

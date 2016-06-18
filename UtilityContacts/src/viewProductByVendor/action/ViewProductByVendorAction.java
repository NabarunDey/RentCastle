package viewProductByVendor.action;

import java.io.File;
import java.util.List;

import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;
import viewProductByVendor.ViewProductByVendorAppContext;
import viewProductByVendor.appService.ViewProductByVendorAppService;
import viewProductByVendor.appService.inputBeans.ViewProductByVendorAppServiceIB;



public class ViewProductByVendorAction {
	
	String productId;
	
	private List<File> image;
	private List<String> imageContentType;
	private String productName;
	private String quantity;
	private String securityMoney;
	private String status;
	private String productType;
	private String subProductTypeSelected;
	private int productIdForRentOffer;
	private String productState;
	private String productCity;
	private String productLocation;
	private	String periodunit;
	private String periodvalue;
	private	String rentAmount;
	
	ViewProductByVendorAppContext context;
	ViewProductByVendorAppService viewProductByVendorAppService;
	public ViewProductByVendorAppContext getContext() {
		return context;
	}
	public void setContext(ViewProductByVendorAppContext context) {
		this.context = context;
	}
	public ViewProductByVendorAppService getViewProductByVendorAppService() {
		return viewProductByVendorAppService;
	}
	public void setViewProductByVendorAppService(
			ViewProductByVendorAppService viewProductByVendorAppService) {
		this.viewProductByVendorAppService = viewProductByVendorAppService;
	}
	
	public String getProductListByVendor()
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = viewProductByVendorAppService.getProductListByVendor();
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		context.setEditable(true);
		return "success";
	}
	
	public String deleteProductFunction()
	{
		ViewProductByVendorAppServiceIB viewProductByVendorAppServiceIB = new ViewProductByVendorAppServiceIB();
		viewProductByVendorAppServiceIB.setProductId(productId);
		viewProductByVendorAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		List<SearchProductProjectorOB> searchProductProjectorOBs = viewProductByVendorAppService.deleteProduct(viewProductByVendorAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}
	
	public String editProductInputFunction()
	{
		ViewProductByVendorAppServiceIB viewProductByVendorAppServiceIB = new ViewProductByVendorAppServiceIB();
		viewProductByVendorAppServiceIB.setProductId(productId);
		context.setProductIdfroEdit(productId);
		viewProductByVendorAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		ViewProductProjectorOB viewProductProjectorOB = viewProductByVendorAppService.editProductInput(viewProductByVendorAppServiceIB);
		if(null != viewProductProjectorOB)
		{
			context.setViewProductProjectorOB(viewProductProjectorOB);
			context.setEditable(true);
			return "success";
		}
		return "error";
	}
	
	public String editProductSubmitFunction()
	{
		ViewProductByVendorAppServiceIB viewProductByVendorAppServiceIB = new ViewProductByVendorAppServiceIB();
		viewProductByVendorAppServiceIB.setProductId(productId);
		viewProductByVendorAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		ViewProductProjectorOB viewProductProjectorOB = viewProductByVendorAppService.editProductInput(viewProductByVendorAppServiceIB);
		if(null != viewProductProjectorOB)
		{
			context.setViewProductProjectorOB(viewProductProjectorOB);
			context.setEditable(true);
			return "success";
		}
		return "error";
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<File> getImage() {
		return image;
	}
	public void setImage(List<File> image) {
		this.image = image;
	}
	public List<String> getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(List<String> imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSecurityMoney() {
		return securityMoney;
	}
	public void setSecurityMoney(String securityMoney) {
		this.securityMoney = securityMoney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getSubProductTypeSelected() {
		return subProductTypeSelected;
	}
	public void setSubProductTypeSelected(String subProductTypeSelected) {
		this.subProductTypeSelected = subProductTypeSelected;
	}
	public int getProductIdForRentOffer() {
		return productIdForRentOffer;
	}
	public void setProductIdForRentOffer(int productIdForRentOffer) {
		this.productIdForRentOffer = productIdForRentOffer;
	}
	public String getProductState() {
		return productState;
	}
	public void setProductState(String productState) {
		this.productState = productState;
	}
	public String getProductCity() {
		return productCity;
	}
	public void setProductCity(String productCity) {
		this.productCity = productCity;
	}
	public String getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
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
	public String getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	
}

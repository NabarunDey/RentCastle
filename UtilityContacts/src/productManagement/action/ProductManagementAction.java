package productManagement.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import productManagement.ProductManagementAppContext;
import productManagement.appService.ProductManagementAppService;
import productManagement.appService.inputBeans.ProductManagementAppServiceIB;
import search.projector.outputBeans.SearchProductProjectorOB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;
import addProduct.appService.inputBeans.FileBean;



public class ProductManagementAction {
	
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
	private String productPin;
	private	String periodunit;
	private String periodvalue;
	private	String rentAmount;
	private String rentId;
	
	ProductManagementAppContext context;
	ProductManagementAppService productManagementAppService;
	public ProductManagementAppContext getContext() {
		return context;
	}
	public void setContext(ProductManagementAppContext context) {
		this.context = context;
	}
	public ProductManagementAppService getProductManagementAppService() {
		return productManagementAppService;
	}
	public void setProductManagementAppService(
			ProductManagementAppService productManagementAppService) {
		this.productManagementAppService = productManagementAppService;
	}
	
	public String getProductListByVendor()
	{
		List<SearchProductProjectorOB> searchProductProjectorOBs = productManagementAppService.getProductListByVendor();
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		context.setEditable(true);
		return "success";
	}
	
	public String deleteProductFunction()
	{
		ProductManagementAppServiceIB productManagementAppServiceIB = new ProductManagementAppServiceIB();
		productManagementAppServiceIB.setProductId(productId);
		productManagementAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		List<SearchProductProjectorOB> searchProductProjectorOBs = productManagementAppService.deleteProduct(productManagementAppServiceIB);
		context.setSearchProductProjectorOBs(searchProductProjectorOBs);
		return "success";
	}
	
	public String editProductInputFunction()
	{
		ProductManagementAppServiceIB productManagementAppServiceIB = new ProductManagementAppServiceIB();
		productManagementAppServiceIB.setProductId(productId);
		context.setProductIdfroEdit(productId);
		productManagementAppServiceIB.setSearchProductProjectorOBs(context.getSearchProductProjectorOBs());
		ViewProductProjectorOB viewProductProjectorOB = productManagementAppService.editProductInput(productManagementAppServiceIB);
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
		ProductManagementAppServiceIB productManagementAppServiceIB = new ProductManagementAppServiceIB();
		productManagementAppServiceIB.setProductId(context.getProductIdfroEdit());
		List<FileBean> fileBeans = new ArrayList<FileBean>();

		if(null!= image)
		{
			for(int i=0; i<image.size();i++)
			{
				FileBean fileBean = new FileBean();
				fileBean.setFile(image.get(i));
				fileBean.setFileType(imageContentType.get(i));
				fileBeans.add(fileBean);
			}
		}
		productManagementAppServiceIB.setFileBeans(fileBeans);
		productManagementAppServiceIB.setProductname(productName);
		productManagementAppServiceIB.setProducttype(productType);
		productManagementAppServiceIB.setSubproducttype(subProductTypeSelected);
		productManagementAppServiceIB.setQuantity(quantity);
		productManagementAppServiceIB.setSecuritymoney(securityMoney);
		productManagementAppServiceIB.setStatus(status);
		productManagementAppServiceIB.setProductpin(productPin);
		productManagementAppServiceIB.setProductstate(productState);
		productManagementAppServiceIB.setProductcity(productCity);
		productManagementAppServiceIB.setOldImages(context.getViewProductProjectorOB().getProductsDBBean().getImages());
		productManagementAppService.editProductSubmit(productManagementAppServiceIB);
		return "success";
	}
	
	public String editRentOffersSubmit()
	{
		ProductManagementAppServiceIB productManagementAppServiceIB = new ProductManagementAppServiceIB();
		productManagementAppServiceIB.setRentId(rentId);
		productManagementAppServiceIB.setProductId(context.getProductIdfroEdit());
		productManagementAppServiceIB.setPeriodunit(periodunit);
		productManagementAppServiceIB.setPeriodvalue(periodvalue);
		productManagementAppServiceIB.setAmount(rentAmount);
		productManagementAppService.editRentOfferSubmit(productManagementAppServiceIB);
		return "success";
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
	public String getProductPin() {
		return productPin;
	}
	public void setProductPin(String productPin) {
		this.productPin = productPin;
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
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	
}

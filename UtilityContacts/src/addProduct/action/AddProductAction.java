package addProduct.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import addProduct.AddProductAppContext;
import addProduct.appService.AddProductAppService;
import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.AddRentOffersAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.projector.outputBeans.AddProductProjectorOB;
import addProduct.projector.outputBeans.AddRentOffersProjectorOB;

public class AddProductAction  extends ActionSupport{


	private AddProductAppService addProductAppService;
	private AddProductAppContext context;
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
	private String description;
	private String deliveryCharge;



	public String addProductInput()
	{
		AddProductAppServiceIB addProductAppServiceIB = new AddProductAppServiceIB();
		AddProductProjectorOB addProductProjectorOB = addProductAppService.getInputDetails(addProductAppServiceIB);
		context.setAddProductProjectorOB(addProductProjectorOB);
		return "success";
	}
	
	public String addProductSubmit()
	{
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
		AddProductAppServiceIB addProductAppServiceIB =new AddProductAppServiceIB();
		addProductAppServiceIB.setFileBeans(fileBeans);
		addProductAppServiceIB.setProductname(productName);
		addProductAppServiceIB.setProducttype(productType);
		addProductAppServiceIB.setSubproducttype(subProductTypeSelected);
		addProductAppServiceIB.setQuantity(quantity);
		addProductAppServiceIB.setSecuritymoney(securityMoney);
		addProductAppServiceIB.setStatus(status);
		addProductAppServiceIB.setProductpin(productPin);
		addProductAppServiceIB.setProductstate(productState);
		addProductAppServiceIB.setProductcity(productCity);
		addProductAppServiceIB.setDescription(description);
		addProductAppServiceIB.setDeliveryCharge(deliveryCharge);
		AddProductProjectorOB addProductProjectorOB = addProductAppService.addProduct(addProductAppServiceIB);
		context.setAddProductProjectorOB(addProductProjectorOB);
		productIdForRentOffer=addProductProjectorOB.getProductIdForRentOffers();
		return "success";
	}
	
	public String addRentOffersSubmit()
	{
		AddRentOffersAppServiceIB addRentOfferAppServiceIB = new AddRentOffersAppServiceIB();
		int productId = productIdForRentOffer>0?productIdForRentOffer:context.getAddProductProjectorOB().getProductIdForRentOffers();
		addRentOfferAppServiceIB.setProductid(productId);
		addRentOfferAppServiceIB.setPeriodunit(periodunit);
		addRentOfferAppServiceIB.setPeriodvalue(periodvalue);
		addRentOfferAppServiceIB.setAmount(rentAmount);
		AddRentOffersProjectorOB addRentOffersProjectorOB = addProductAppService.addRentOffer(addRentOfferAppServiceIB);
		context.setAddRentOffersProjectorOB(addRentOffersProjectorOB);
		return "success";
	}
	
	public AddProductAppService getAddProductAppService() {
		return addProductAppService;
	}

	public void setAddProductAppService(AddProductAppService addProductAppService) {
		this.addProductAppService = addProductAppService;
	}

	public AddProductAppContext getContext() {
		return context;
	}

	public void setContext(AddProductAppContext context) {
		this.context = context;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

}

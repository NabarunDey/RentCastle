package addProduct.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import addProduct.AddProductAppContext;
import addProduct.appService.AddProductAppService;
import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.AddRentOffersAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.projector.outputBeans.AddProductProjectorOB;
import addProduct.projector.outputBeans.AddRentOffersProjectorOB;

public class AddProductAction {


	private AddProductAppService addProductAppService;
	private AddProductAppContext context;
	private List<File> image;
	private List<String> imageContentType;
	private String productName;
	private String quantity;
	private String securityMoney;
	private String status;
	private String productType;
	private String subProductType;
	private int productIdForRentOffer;
	private	String periodunit;
	private String periodvalue;
	private	String rentAmount;


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
		addProductAppServiceIB.setSubproducttype(subProductType);
		addProductAppServiceIB.setQuantity(quantity);
		addProductAppServiceIB.setSecuritymoney(securityMoney);
		addProductAppServiceIB.setStatus(status);
		AddProductProjectorOB addProductProjectorOB = addProductAppService.addProduct(addProductAppServiceIB);
		context.setAddProductProjectorOB(addProductProjectorOB);
		productIdForRentOffer=addProductProjectorOB.getProductIdForRentOffers();
		return "success";
	}
	
	public String addRentOffersSubmit()
	{
		AddRentOffersAppServiceIB addRentOfferAppServiceIB = new AddRentOffersAppServiceIB();
		addRentOfferAppServiceIB.setProductid(productIdForRentOffer);
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


	public String getSubProductType() {
		return subProductType;
	}


	public void setSubProductType(String subProductType) {
		this.subProductType = subProductType;
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

}

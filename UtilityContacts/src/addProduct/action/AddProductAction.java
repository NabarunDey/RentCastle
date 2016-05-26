package addProduct.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.structures.productTypes.ProductType;
import com.structures.status.ProductStatus;

import addProduct.AddProductAppContext;
import addProduct.appService.AddProductAppService;
import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.projector.outputBeans.AddProductProjectorOB;

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



	public String addProductInput()
	{
		AddProductAppServiceIB addProductAppServiceIB = new AddProductAppServiceIB();
		AddProductProjectorOB addProductProjectorOB = addProductAppService.getInputDetails(addProductAppServiceIB);
		context.setAddProductProjectorOB(addProductProjectorOB);
		return "success";
	}


	public String addProductConfirm()
	{
		Map<String, String> confirmDisplayMap = new HashMap<String, String>();
		confirmDisplayMap.put("ProductName", "Godrej Fridje");
		confirmDisplayMap.put("ProductType", "Refrijerator");
		confirmDisplayMap.put("Price", "20000");
		context.getAddProductProjectorOB().setConfirmDisplayMap(confirmDisplayMap);

		List<FileBean> fileBeans = new ArrayList<FileBean>();

		for(int i=0; i<image.size();i++)
		{
			FileBean fileBean = new FileBean();
			fileBean.setFile(image.get(i));
			fileBean.setFileType(imageContentType.get(i));
			fileBeans.add(fileBean);
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
	
	
}

package addProduct.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 



}

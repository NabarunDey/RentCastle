package viewProduct.projector;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.databaseBeans.ImagesDBBean;


public class ViewProductProjector {

	public ViewProductProjectorOB viewProduct(ViewProductAppServiceIB viewProductAppServiceIB)
	{
		ViewProductProjectorOB viewProductProjectorOB = new ViewProductProjectorOB();
		viewProductProjectorOB.setProductsDBBean(viewProductAppServiceIB.getProductsDBBean());
		viewProductProjectorOB.setRentOffersDBBeans(viewProductAppServiceIB.getRentOffersDBBeans());
		List<String> imagesPathList =new ArrayList<String>();
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") +"\\";

		for(ImagesDBBean imagesDBBean : viewProductAppServiceIB.getImagesDBBeans())
		{
			imagesPathList.add(contextPath+"productImages\\"+imagesDBBean.getImagepath());
		}
		viewProductProjectorOB.setProductImagesList(imagesPathList);
		return viewProductProjectorOB;

	}


}

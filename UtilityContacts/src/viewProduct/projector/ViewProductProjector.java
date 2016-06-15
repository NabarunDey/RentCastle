package viewProduct.projector;

import java.util.ArrayList;
import java.util.List;

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
		for(ImagesDBBean imagesDBBean : viewProductAppServiceIB.getImagesDBBeans())
		{
			imagesPathList.add(imagesDBBean.getImagepath());
		}
		viewProductProjectorOB.setProductImagesList(imagesPathList);
		return viewProductProjectorOB;

	}


}

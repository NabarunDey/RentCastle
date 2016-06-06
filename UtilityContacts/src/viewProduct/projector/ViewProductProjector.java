package viewProduct.projector;

import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;


public class ViewProductProjector {

	public ViewProductProjectorOB viewProduct(ViewProductAppServiceIB viewProductAppServiceIB)
	{
		ViewProductProjectorOB viewProductProjectorOB = new ViewProductProjectorOB();
		viewProductProjectorOB.setProductsDBBean(viewProductAppServiceIB.getProductsDBBean());
		viewProductProjectorOB.setRentOffersDBBeans(viewProductAppServiceIB.getRentOffersDBBeans());
		return viewProductProjectorOB;

	}


}

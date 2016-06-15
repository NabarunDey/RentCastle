package viewProduct;

import viewProduct.projector.outputBeans.ViewProductProjectorOB;


public class ViewProductAppContext {
	
	private ViewProductProjectorOB viewProductProjectorOB;

	public ViewProductProjectorOB getViewProductProjectorOB() {
		return viewProductProjectorOB;
	}

	public void setViewProductProjectorOB(
			ViewProductProjectorOB viewProductProjectorOB) {
		this.viewProductProjectorOB = viewProductProjectorOB;
	}
	
	

}

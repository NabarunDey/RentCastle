package addProduct;

import addProduct.projector.outputBeans.AddProductProjectorOB;
import addProduct.projector.outputBeans.AddRentOffersProjectorOB;

public class AddProductAppContext {
	
	AddProductProjectorOB addProductProjectorOB;
	AddRentOffersProjectorOB addRentOffersProjectorOB;
	
	

	public AddRentOffersProjectorOB getAddRentOffersProjectorOB() {
		return addRentOffersProjectorOB;
	}

	public void setAddRentOffersProjectorOB(
			AddRentOffersProjectorOB addRentOffersProjectorOB) {
		this.addRentOffersProjectorOB = addRentOffersProjectorOB;
	}

	public AddProductProjectorOB getAddProductProjectorOB() {
		return addProductProjectorOB;
	}

	public void setAddProductProjectorOB(AddProductProjectorOB addProductProjectorOB) {
		this.addProductProjectorOB = addProductProjectorOB;
	}
	
	

}

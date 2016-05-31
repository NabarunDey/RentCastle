package addProduct.projector.outputBeans;

import java.util.List;

public class AddRentOffersProjectorOB {

	private String productName;
	private List<String> images;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}

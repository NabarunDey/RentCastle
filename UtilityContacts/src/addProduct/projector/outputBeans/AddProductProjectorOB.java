package addProduct.projector.outputBeans;

import java.util.List;
import java.util.Map;

import com.structures.productTypes.ProductType;

public class AddProductProjectorOB {
	
	private Map<String, List<String>> productTypeMap;
	private int productIdForRentOffers;
	
	public int getProductIdForRentOffers() {
		return productIdForRentOffers;
	}

	public void setProductIdForRentOffers(int productIdForRentOffers) {
		this.productIdForRentOffers = productIdForRentOffers;
	}

	public Map<String, List<String>> getProductTypeMap() {
		return productTypeMap;
	}

	public void setProductTypeMap(Map<String, List<String>> productTypeMap) {
		this.productTypeMap = productTypeMap;
	}

	

	
	
	
	

}

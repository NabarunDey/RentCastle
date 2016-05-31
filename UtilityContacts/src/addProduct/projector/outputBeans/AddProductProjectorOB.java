package addProduct.projector.outputBeans;

import java.util.List;
import java.util.Map;

import com.structures.productTypes.ProductType;

public class AddProductProjectorOB {
	
	private Map<ProductType, List<Object>> productTypeMap;
	private int productIdForRentOffers;
	
	public int getProductIdForRentOffers() {
		return productIdForRentOffers;
	}

	public void setProductIdForRentOffers(int productIdForRentOffers) {
		this.productIdForRentOffers = productIdForRentOffers;
	}

	public Map<ProductType, List<Object>> getProductTypeMap() {
		return productTypeMap;
	}

	public void setProductTypeMap(Map<ProductType, List<Object>> productTypeMap) {
		this.productTypeMap = productTypeMap;
	}

	

	
	
	
	

}

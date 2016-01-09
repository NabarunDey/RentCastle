package addProduct.projector.outputBeans;

import java.util.List;
import java.util.Map;

import com.structures.productTypes.ProductType;

public class AddProductProjectorOB {
	
	private Map<ProductType, List<ProductType>> productTypeMap;
	
	private boolean loadInputDetailsSuccess;
	
	private boolean validaionSuccess;

	public boolean isValidaionSuccess() {
		return validaionSuccess;
	}

	public void setValidaionSuccess(boolean validaionSuccess) {
		this.validaionSuccess = validaionSuccess;
	}

	public boolean isLoadInputDetailsSuccess() {
		return loadInputDetailsSuccess;
	}

	public void setLoadInputDetailsSuccess(boolean loadInputDetailsSuccess) {
		this.loadInputDetailsSuccess = loadInputDetailsSuccess;
	}

	public Map<ProductType, List<ProductType>> getProductTypeMap() {
		return productTypeMap;
	}

	public void setProductTypeMap(Map<ProductType, List<ProductType>> productTypeMap) {
		this.productTypeMap = productTypeMap;
	}


	
	
	
	

}

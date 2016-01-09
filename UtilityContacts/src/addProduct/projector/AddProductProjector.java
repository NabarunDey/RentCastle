package addProduct.projector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.structures.productTypes.ProductType;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.projector.outputBeans.AddProductProjectorOB;


public class AddProductProjector {

	public AddProductProjectorOB getAddProductInput(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB =new  AddProductProjectorOB();
		 Map<ProductType, List<ProductType>> productTypeMap = new LinkedHashMap<ProductType, List<ProductType>>();
		
		for(ProductType productType : ProductType.values())
		{
			List<ProductType> subProductTypeList = new ArrayList<ProductType>();
			for(ProductType subProductType : productType.values())
			{
				subProductTypeList.add(subProductType);
			}
			productTypeMap.put(productType, subProductTypeList);
		}
		
		return addProductProjectorOB;
	}
}

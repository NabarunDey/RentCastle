package addProduct.projector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.projector.outputBeans.AddProductProjectorOB;

import com.structures.productTypes.Electronics;
import com.structures.productTypes.Furniture;
import com.structures.productTypes.ProductType;


public class AddProductProjector {

	public AddProductProjectorOB getAddProductInput(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB =new  AddProductProjectorOB();
		Map<ProductType, List<Object>> productTypeMap = new LinkedHashMap<ProductType, List<Object>>();

		for(ProductType productType : ProductType.values())
		{
			List<Object> subProductTypeList = new ArrayList<Object>();

			if(productType.equals(ProductType.FURNITURE))
			{
				for(Furniture subProductType : Furniture.values())
				{
					subProductTypeList.add(subProductType);
				}
				productTypeMap.put(productType, subProductTypeList);
			}
			
			if(productType.equals(ProductType.ELECTRONICS))
			{
				for(Electronics subProductType : Electronics.values())
				{
					subProductTypeList.add(subProductType);
				}
				productTypeMap.put(productType, subProductTypeList);
			}
		}

		return addProductProjectorOB;
	}
}

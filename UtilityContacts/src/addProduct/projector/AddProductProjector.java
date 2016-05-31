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
		Map<String, List<String>> productTypeMap = new LinkedHashMap<String, List<String>>();
		 
		productTypeMap.put("Select Product Type", new ArrayList<String>());
		for(ProductType productType : ProductType.values())
		{
			List<String> subProductTypeList = new ArrayList<String>();

			if(productType.equals(ProductType.FURNITURE))
			{
				for(Furniture subProductType : Furniture.values())
				{
					subProductTypeList.add(subProductType.getText());
				}
				productTypeMap.put(productType.getText(), subProductTypeList);
			}
			
			if(productType.equals(ProductType.ELECTRONICS))
			{
				for(Electronics subProductType : Electronics.values())
				{
					subProductTypeList.add(subProductType.getText());
				}
				productTypeMap.put(productType.getText(), subProductTypeList);
			}
		}
		addProductProjectorOB.setProductTypeMap(productTypeMap);
		return addProductProjectorOB;
	}
}

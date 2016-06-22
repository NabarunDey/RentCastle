package viewProduct.projector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.databaseBeans.ImagesDBBean;
import com.structures.productTypes.Electronics;
import com.structures.productTypes.Furniture;
import com.structures.productTypes.ProductType;


public class ViewProductProjector {

	public ViewProductProjectorOB viewProduct(ViewProductAppServiceIB viewProductAppServiceIB)
	{
		ViewProductProjectorOB viewProductProjectorOB = new ViewProductProjectorOB();
		viewProductProjectorOB.setProductsDBBean(viewProductAppServiceIB.getProductsDBBean());
		viewProductProjectorOB.setRentOffersDBBeans(viewProductAppServiceIB.getRentOffersDBBeans());
		List<String> imagesPathList =new ArrayList<String>();
		for(ImagesDBBean imagesDBBean : viewProductAppServiceIB.getImagesDBBeans())
		{
			imagesPathList.add(imagesDBBean.getImagepath());
		}
		viewProductProjectorOB.setProductImagesList(imagesPathList);
		Map<String, List<String>> productTypeMap = new LinkedHashMap<String, List<String>>();

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
		viewProductProjectorOB.setProductTypeMap(productTypeMap);
		return viewProductProjectorOB;

	}


}

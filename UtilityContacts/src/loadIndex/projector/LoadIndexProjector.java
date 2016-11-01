package loadIndex.projector;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import loadIndex.projector.outputBeans.AdsSectionProjectorOB;

import com.databaseBeans.DynamicContentDBBean;

public class LoadIndexProjector {
	
	public AdsSectionProjectorOB adsSectionProjector(List<DynamicContentDBBean> dynamicContentDBBeans)
	{
		Map<String, String> adsSectionMap = new LinkedHashMap<String, String>();
		for(DynamicContentDBBean dynamicContentDBBean :dynamicContentDBBeans)
		{
			adsSectionMap.put(dynamicContentDBBean.getElement(),dynamicContentDBBean.getValue());
		}
		AdsSectionProjectorOB adsSectionProjectorOB= new AdsSectionProjectorOB();
		adsSectionProjectorOB.setDynamicContentsMap(adsSectionMap);
		return adsSectionProjectorOB;
	}

}

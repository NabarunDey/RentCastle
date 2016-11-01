package loadIndex.appService;

import java.util.ArrayList;
import java.util.List;

import com.dao.DynamicContentDao;
import com.databaseBeans.DynamicContentDBBean;

import loadIndex.projector.LoadIndexProjector;
import loadIndex.projector.outputBeans.AdsSectionProjectorOB;


public class LoadIndexAppService {

	private DynamicContentDao dynamicContentDao;
	private LoadIndexProjector loadIndexProjector;
	
	public AdsSectionProjectorOB getAdsSection()
	{
		List<String> dynamicContentKeys= new ArrayList<String>();
		dynamicContentKeys.add("adsSectionImage1");
		dynamicContentKeys.add("adsSectionHeader1");
		dynamicContentKeys.add("adsSectionText1");
		dynamicContentKeys.add("adsSectionUrl1");
		dynamicContentKeys.add("adsSectionImage2");
		dynamicContentKeys.add("adsSectionHeader2");
		dynamicContentKeys.add("adsSectionText2");
		dynamicContentKeys.add("adsSectionUrl2");
		dynamicContentKeys.add("adsSectionImage3");
		dynamicContentKeys.add("adsSectionHeader3");
		dynamicContentKeys.add("adsSectionText3");
		dynamicContentKeys.add("adsSectionUrl3");
		dynamicContentKeys.add("sliderImage1");
		dynamicContentKeys.add("sliderImage2");
		dynamicContentKeys.add("sliderImage3");
		
		List<DynamicContentDBBean> dynamicContentDBBeans = dynamicContentDao.getDynamicContent(dynamicContentKeys);
		AdsSectionProjectorOB adsSectionProjectorOB = null;
		if(null!= dynamicContentDBBeans && dynamicContentDBBeans.size()>0)
		{
			adsSectionProjectorOB =  loadIndexProjector.adsSectionProjector(dynamicContentDBBeans);
		}
		return adsSectionProjectorOB;
	}

	public DynamicContentDao getDynamicContentDao() {
		return dynamicContentDao;
	}

	public void setDynamicContentDao(DynamicContentDao dynamicContentDao) {
		this.dynamicContentDao = dynamicContentDao;
	}

	public LoadIndexProjector getLoadIndexProjector() {
		return loadIndexProjector;
	}

	public void setLoadIndexProjector(LoadIndexProjector loadIndexProjector) {
		this.loadIndexProjector = loadIndexProjector;
	}
	
}

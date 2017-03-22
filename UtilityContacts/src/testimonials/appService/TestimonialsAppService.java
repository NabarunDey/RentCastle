package testimonials.appService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import testimonials.appService.inputBeans.TestimonialsAppServiceIB;
import testimonials.appService.outputBeans.TestimonialsProjectorOB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.dao.ImagesDao;
import com.dao.TestimonialsDao;
import com.databaseBeans.TestimonialsDBBean;
import com.sessionBeans.UserProfile;




/**
 * @author nd29794
 *
 */
public class TestimonialsAppService {

	private UserProfile userProfile;
	private TestimonialsDao testimonialsDao;
	private ImagesDao imagesDao;


	public TestimonialsProjectorOB getTestimonialInput()
	{
		TestimonialsProjectorOB testimonialsProjectorOB = new TestimonialsProjectorOB();
		if(null!=userProfile && StringUtils.isNotEmpty(userProfile.getUserName()))
		{
			testimonialsProjectorOB.setLoggedIn(true);
			List<TestimonialsDBBean> testimonialsDBBeans= testimonialsDao.getTestimonialsForUser(userProfile.getUserName());
			if(null!=testimonialsDBBeans && testimonialsDBBeans.size()>0)
			{
				testimonialsProjectorOB.setTestimonialAdded(true);
				testimonialsProjectorOB.setTestimonialsDBBean(testimonialsDBBeans.get(0));
			}
		}
		return testimonialsProjectorOB;
	}


	public TestimonialsProjectorOB addTestimonial(TestimonialsAppServiceIB testimonialsAppServiceIB)
	{			
		TestimonialsProjectorOB testimonialsProjectorOB = new TestimonialsProjectorOB();
		
		if(null!=userProfile && StringUtils.isNotEmpty(userProfile.getUserName()))
		{
			testimonialsAppServiceIB.setUsername(userProfile.getUserName());
			FileBean fileBean = new FileBean();
			fileBean.setFile(testimonialsAppServiceIB.getProfileImage());
			List<FileBean> fileBeans = new ArrayList<FileBean>();
			fileBeans.add(fileBean);

			ImagesDaoOB imagesDaoOB=  imagesDao.insertMultipleProductImages(fileBeans);
			testimonialsAppServiceIB.setImagePath(imagesDaoOB.getImagePathList().get(0));

			testimonialsDao.addTestimonial(testimonialsAppServiceIB);
			testimonialsProjectorOB.setTestimonialAdded(true);
		}
		return testimonialsProjectorOB;

	}


	public List<TestimonialsDBBean> getOnLoadTestimonial()
	{
		String username = (null!= userProfile)?userProfile.getUserName():"";
		List<TestimonialsDBBean> testimonialsDBBeans= testimonialsDao.getOnLoadTestimonial(username);
		return testimonialsDBBeans;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public TestimonialsDao getTestimonialsDao() {
		return testimonialsDao;
	}

	public void setTestimonialsDao(TestimonialsDao testimonialsDao) {
		this.testimonialsDao = testimonialsDao;
	}


	public ImagesDao getImagesDao() {
		return imagesDao;
	}


	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}

}

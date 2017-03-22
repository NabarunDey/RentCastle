package testimonials.action;

import java.io.File;

import testimonials.TestimonialsAppContext;
import testimonials.appService.TestimonialsAppService;
import testimonials.appService.inputBeans.TestimonialsAppServiceIB;
import testimonials.appService.outputBeans.TestimonialsProjectorOB;

import com.opensymphony.xwork2.ActionSupport;
import com.util.CommonUtility;



public class TestimonialsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TestimonialsAppContext  context;
	private TestimonialsAppService testimonialsAppService;
	private String displayName;
	private File profileImage;
	private int rating;
	private String comment;
	private boolean testimonialAdded;

	public String myTestimonial()
	{
		TestimonialsProjectorOB testimonialsProjectorOB = testimonialsAppService.getTestimonialInput();
		context.setTestimonialsProjectorOB(testimonialsProjectorOB);
		return "success";
	}

	public String addTestimonial()
	{
		TestimonialsAppServiceIB testimonialsAppServiceIB = new TestimonialsAppServiceIB();
		CommonUtility.copyBean(this, testimonialsAppServiceIB);
		TestimonialsProjectorOB testimonialsProjectorOB = testimonialsAppService.addTestimonial(testimonialsAppServiceIB);
		testimonialAdded=testimonialsProjectorOB.isTestimonialAdded();
		return "success";
	}

	public TestimonialsAppContext getContext() {
		return context;
	}

	public void setContext(TestimonialsAppContext context) {
		this.context = context;
	}

	public TestimonialsAppService getTestimonialsAppService() {
		return testimonialsAppService;
	}

	public void setTestimonialsAppService(
			TestimonialsAppService testimonialAppService) {
		this.testimonialsAppService = testimonialAppService;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public File getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isTestimonialAdded() {
		return testimonialAdded;
	}

	public void setTestimonialAdded(boolean testimonialAdded) {
		this.testimonialAdded = testimonialAdded;
	}
	
}

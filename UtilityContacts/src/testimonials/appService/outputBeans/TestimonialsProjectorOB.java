package testimonials.appService.outputBeans;

import com.databaseBeans.TestimonialsDBBean;



public class TestimonialsProjectorOB {

	private boolean loggedIn;
	private boolean testimonialAdded;
	private TestimonialsDBBean testimonialsDBBean;


	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public boolean isTestimonialAdded() {
		return testimonialAdded;
	}
	public void setTestimonialAdded(boolean testimonialAdded) {
		this.testimonialAdded = testimonialAdded;
	}
	public TestimonialsDBBean getTestimonialsDBBean() {
		return testimonialsDBBean;
	}
	public void setTestimonialsDBBean(TestimonialsDBBean testimonialsDBBean) {
		this.testimonialsDBBean = testimonialsDBBean;
	}
}
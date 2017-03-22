package testimonials;

import testimonials.appService.outputBeans.TestimonialsProjectorOB;

public class TestimonialsAppContext {
	
	private TestimonialsProjectorOB testimonialsProjectorOB;
	
	public TestimonialsProjectorOB getTestimonialsProjectorOB() {
		return testimonialsProjectorOB;
	}

	public void setTestimonialsProjectorOB(
			TestimonialsProjectorOB testimonialsProjectorOB) {
		this.testimonialsProjectorOB = testimonialsProjectorOB;
	}
	
}

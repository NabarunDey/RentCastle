package testimonials.appService.inputBeans;

import java.io.File;



public class TestimonialsAppServiceIB {

	private String username;
	private String displayName;
	private File profileImage;
	private String imagePath;
	private int rating;
	private String comment;
	private String status;
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public File getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

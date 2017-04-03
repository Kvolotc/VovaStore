package store.persistence.entity;


import javax.persistence.Embeddable;

@Embeddable
public class Snubber  {
	
	private String brandSnubber;
	
	private String courseSnubber;

	public String getBrandSnubber() {
		return brandSnubber;
	}

	public void setBrandSnubber(String brandSnubber) {
		this.brandSnubber = brandSnubber;
	}

	public String getCourseSnubber() {
		return courseSnubber;
	}

	public void setCourseSnubber(String courseSnubber) {
		this.courseSnubber = courseSnubber;
	}
	
}

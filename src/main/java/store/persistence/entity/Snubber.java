package store.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import store.persistence.entity.enums.brandEnum.SnuubberBrand;
import store.persistence.entity.enums.typeEnum.SnubberType;


@Embeddable
public class Snubber  {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand_snubber")
	private SnuubberBrand brandSnubber;
	
	@Column(name = "course_snubber")
	private String courseSnubber;
	
	@Enumerated(EnumType.STRING)
	private SnubberType typeSnubber;

	public SnuubberBrand getBrandSnubber() {
		return brandSnubber;
	}

	public void setBrandSnubber(SnuubberBrand brandSnubber) {
		this.brandSnubber = brandSnubber;
	}

	public String getCourseSnubber() {
		return courseSnubber;
	}

	public void setCourseSnubber(String courseSnubber) {
		this.courseSnubber = courseSnubber;
	}

	public SnubberType getTypeSnubber() {
		return typeSnubber;
	}

	public void setTypeSnubber(SnubberType typeSnubber) {
		this.typeSnubber = typeSnubber;
	}
	
}

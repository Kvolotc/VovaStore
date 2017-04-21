package store.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import store.persistence.entity.enums.brandEnum.ForkBrand;
import store.persistence.entity.enums.typeEnum.ForkType;


@Embeddable
public class Snubber  {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand_snubber")
	private ForkBrand brandSnubber;
	
	@Column(name = "model_snubber")
	private String modelSnubber;
	
	@Column(name = "course_snubber")
	private String courseSnubber;
	
	@Enumerated(EnumType.STRING)
	private ForkType typeSnubber;

	public ForkBrand getBrandSnubber() {
		return brandSnubber;
	}

	public void setBrandSnubber(ForkBrand brandSnubber) {
		this.brandSnubber = brandSnubber;
	}

	public String getCourseSnubber() {
		return courseSnubber;
	}

	public void setCourseSnubber(String courseSnubber) {
		this.courseSnubber = courseSnubber;
	}

	public ForkType getTypeSnubber() {
		return typeSnubber;
	}

	public void setTypeSnubber(ForkType typeSnubber) {
		this.typeSnubber = typeSnubber;
	}

	public String getModelSnubber() {
		return modelSnubber;
	}

	public void setModelSnubber(String modelSnubber) {
		this.modelSnubber = modelSnubber;
	}
	
}

package store.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import store.persistence.entity.enums.Alloy;
import store.persistence.entity.enums.brandEnum.FrameBrand;
import store.persistence.entity.enums.typeEnum.FrameType;


@Entity
@Table(name = "frames")
public class Frame extends Product {
	
	@Column(name = "is_exist_snubber")
	private boolean isExistSnubber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "alloy")
	private Alloy alloy;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand")
	private FrameBrand brand;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private FrameType type;
	
	@Embedded
	@Column(name = "snubber")
	private Snubber snubber;

	public boolean isExistSnubber() {
		return isExistSnubber;
	}

	public void setExistSnubber(boolean isExistSnubber) {
		this.isExistSnubber = isExistSnubber;
	}

	public Snubber getSnubber() {
		return snubber;
	}

	public void setSnubber(Snubber snubber) {
		this.snubber = snubber;
	}

	public Alloy getAlloy() {
		return alloy;
	}

	public void setAlloy(Alloy alloy) {
		this.alloy = alloy;
	}

	public FrameType getType() {
		return type;
	}

	public void setType(FrameType type) {
		this.type = type;
	}

	public FrameBrand getBrand() {
		return brand;
	}

	public void setBrand(FrameBrand brand) {
		this.brand = brand;
	}

}

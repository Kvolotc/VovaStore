package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import store.persistence.entity.enums.brandEnum.BrakeBrand;
import store.persistence.entity.enums.typeEnum.BrakeType;


@Entity
@Table(name = "brakes")
public class Brake extends Product{
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private BrakeType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand")
	private BrakeBrand brand;
	
	@JsonIgnore
	@OneToMany(mappedBy = "brake",fetch = FetchType.LAZY)
	private Collection<Bike> bikes;

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}

	public BrakeType getType() {
		return type;
	}

	public void setType(BrakeType type) {
		this.type = type;
	}

	public BrakeBrand getBrand() {
		return brand;
	}

	public void setBrand(BrakeBrand brand) {
		this.brand = brand;
	}
	
	
}

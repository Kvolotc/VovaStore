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

import store.persistence.entity.enums.brandEnum.RimBrand;
import store.persistence.entity.enums.typeEnum.RimType;



@Entity
@Table(name = "rims")
public class Rim extends Product{

	@Column(name = "diameter")
	private double diameter;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private RimType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "brand")
	private RimBrand brand;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rim",fetch = FetchType.LAZY)
	private Collection<Bike> bikes;

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}

	public RimType getType() {
		return type;
	}

	public void setType(RimType type) {
		this.type = type;
	}

	public RimBrand getBrand() {
		return brand;
	}

	public void setBrand(RimBrand brand) {
		this.brand = brand;
	}
		
}

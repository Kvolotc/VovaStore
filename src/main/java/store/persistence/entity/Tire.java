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
import store.persistence.entity.enums.brandEnum.TireBrand;
import store.persistence.entity.enums.typeEnum.TireType;

@Entity
@Table(name = "tires")
public class Tire extends Product<TireBrand> {
	
	@Column(name = "diameter")
	private double diameter;
	
	@Column(name = "width")
	private double width;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TireType type;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tire", fetch = FetchType.LAZY)
	private Collection<Bike> bikes;

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}
	
	public TireType getType() {
		return type;
	}

	public void setType(TireType type) {
		this.type = type;
	}

}

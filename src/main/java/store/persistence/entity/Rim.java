package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rims")
public class Rim extends Product{

	@Column(name = "diameter")
	private double diameter;
	
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
	
}

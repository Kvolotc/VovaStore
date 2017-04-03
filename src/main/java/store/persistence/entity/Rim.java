package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rims")
public class Rim extends Product{

	@Column(name = "diameter")
	private int diameter;
	
	@OneToMany(mappedBy = "rim")
	private Collection<Bike> bikes;

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}
	
}

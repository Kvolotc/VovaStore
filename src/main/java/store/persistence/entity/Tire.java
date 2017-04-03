package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tires")
public class Tire extends Product {
	
	@Column(name = "diameter")
	private int diameter;
	
	@Column(name = "width")
	private double width;
	
	@OneToMany(mappedBy = "tire")
	private Collection<Bike> bikes;

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
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

	@Override
	public String toString() {
		return "Tire [diameter=" + diameter + ", width=" + width + ", bikes=" + bikes + "]";
	}
	
	

}

package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brakes")
public class Brake extends Product{
	
	@OneToMany(mappedBy = "brake")
	private Collection<Bike> bikes;

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}
	
	

}

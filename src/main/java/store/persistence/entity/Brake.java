package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "brakes")
public class Brake extends Product{
	
	@Column(name = "model")
	private String model;
	
	@JsonIgnore
	@OneToMany(mappedBy = "brake",fetch = FetchType.LAZY)
	private Collection<Bike> bikes;

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}

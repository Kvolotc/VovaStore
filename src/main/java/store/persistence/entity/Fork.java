package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "forks")
public class Fork extends Product{
	
	@Column(name = "course")
	private String course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fork")
	private Collection<Bike> bikes;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}
	
	

}

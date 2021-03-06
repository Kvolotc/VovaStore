package store.persistence.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.servlet.FrameworkServlet;

import com.fasterxml.jackson.annotation.JsonIgnore;

import store.persistence.entity.enums.brandEnum.ForkBrand;
import store.persistence.entity.enums.typeEnum.ForkType;



@Entity
@Table(name = "forks")
public class Fork extends Product<ForkBrand>{
	
	@Column(name = "course")
	private String course;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ForkType type;
	
	@JsonIgnore
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

	public ForkType getType() {
		return type;
	}

	public void setType(ForkType type) {
		this.type = type;
	}

}

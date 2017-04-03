package store.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Product {
	
	@ManyToOne
	@JoinColumn(name = "brake_id", referencedColumnName = "id")
	private Brake brake;
	
	@ManyToOne
	@JoinColumn(name = "fork_id", referencedColumnName = "id")
	private Fork fork;
	
	@OneToOne
	@JoinColumn(name = "frame_id", referencedColumnName = "id")
	private Frame frame;
	
	@ManyToOne
	@JoinColumn(name = "rim_id", referencedColumnName = "id")
	private Rim rim;
	
	@ManyToOne
	@JoinColumn(name = "tire_id", referencedColumnName = "id")
	private Tire tire;

	public Brake getBrake() {
		return brake;
	}

	public void setBrake(Brake brake) {
		this.brake = brake;
	}

	public Fork getFork() {
		return fork;
	}

	public void setFork(Fork fork) {
		this.fork = fork;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Rim getRim() {
		return rim;
	}

	public void setRim(Rim rim) {
		this.rim = rim;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
		
}

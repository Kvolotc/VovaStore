package store.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="price")
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "brake_id", referencedColumnName = "id")
	private Brake brake;
	
	@ManyToOne
	@JoinColumn(name = "fork_id", referencedColumnName = "id")
	private Fork fork;
	
	@OneToOne()
	@JoinColumn(name = "frame_id", referencedColumnName = "id", unique=true)
	private Frame frame;
	
	@ManyToOne
	@JoinColumn(name = "rim_id", referencedColumnName = "id")
	private Rim rim;
	
	@ManyToOne
	@JoinColumn(name = "tire_id", referencedColumnName = "id")
	private Tire tire;
	
	@Column(name = "image_name")
	private String imageName;

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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}

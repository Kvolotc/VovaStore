package store.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frames")
public class Frame extends Product {
	
	@Column(name = "is_exist_snubber")
	private boolean isExistSnubber;
	
	@Column(name = "size")
	private String size;
	
	@Embedded
	@Column(name = "snubber")
	private Snubber snubber;

	public String getSize() {
		return size;
	}

	public boolean isExistSnubber() {
		return isExistSnubber;
	}

	public void setExistSnubber(boolean isExistSnubber) {
		this.isExistSnubber = isExistSnubber;
	}

	public Snubber getSnubber() {
		return snubber;
	}

	public void setSnubber(Snubber snubber) {
		this.snubber = snubber;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}

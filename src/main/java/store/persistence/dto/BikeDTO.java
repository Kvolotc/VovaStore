package store.persistence.dto;


public class BikeDTO {
	
	private int price;
	
	private BrakeDTO brake;
	
	private ForkDTO fork;

	private FrameDTO frame;
	
	private RimDTO rim;

	private TireDTO tire;

	private String imageName;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BrakeDTO getBrake() {
		return brake;
	}

	public void setBrake(BrakeDTO brake) {
		this.brake = brake;
	}

	public ForkDTO getFork() {
		return fork;
	}

	public void setFork(ForkDTO fork) {
		this.fork = fork;
	}

	public FrameDTO getFrame() {
		return frame;
	}

	public void setFrame(FrameDTO frame) {
		this.frame = frame;
	}

	public RimDTO getRim() {
		return rim;
	}

	public void setRim(RimDTO rim) {
		this.rim = rim;
	}

	public TireDTO getTire() {
		return tire;
	}

	public void setTire(TireDTO tire) {
		this.tire = tire;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "BikeDTO [price=" + price + ", brake=" + brake + ", fork=" + fork + ", frame=" + frame + ", rim=" + rim
				+ ", tire=" + tire + ", imageName=" + imageName + "]";
	}
	
	
	
	
}

package store.persistence.dto;

public class FrameDTO {

	private double price;

	private String model;

	private String brand;

	private String type;

	private String alloy;

	private int createdOn;

	private boolean isExistSnubber;

	private SnubberDTO snubberDTO;
	
	private String imageName;

	public SnubberDTO getSnubberDTO() {
		return snubberDTO;
	}

	public void setSnubberDTO(SnubberDTO snubberDTO) {
		this.snubberDTO = snubberDTO;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlloy() {
		return alloy;
	}

	public void setAlloy(String alloy) {
		this.alloy = alloy;
	}

	public boolean isExistSnubber() {
		return isExistSnubber;
	}

	public void setExistSnubber(boolean isExistSnubber) {
		this.isExistSnubber = isExistSnubber;
	}

	public int getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(int createdOn) {
		this.createdOn = createdOn;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}

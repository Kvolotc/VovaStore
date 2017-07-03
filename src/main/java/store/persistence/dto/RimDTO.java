package store.persistence.dto;


public class RimDTO {
	
	private int id;
		
	private int price;

	private String model;
	
	private String brand;
	
	private String type;
	
	private double diameter;
	
	private int createdOn;
	
	private String imageName;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

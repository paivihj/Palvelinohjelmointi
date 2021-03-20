package fi.pju.Bikeshop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bikeId;
	private String brand;
	private String model;
	private double price;
	private String description;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bike")
	private List<SingleBike> singleBikes;
	
	public Bike() {}

	public Bike(String brand, String model, double price, String description) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return bikeId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SingleBike> getSingleBikes() {
		return singleBikes;
	}

	public void setSingleBikes(List<SingleBike> singleBikes) {
		this.singleBikes = singleBikes;
	}

	@Override
	public String toString() {
		return "Bike [id=" + bikeId + ", brand=" + brand + ", model=" + model + ", price=" + price + ", description="
				+ description + "]";
	}

}

package fi.pju.Bikeshop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SingleBike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String size;
	
	@ManyToOne
	@JoinColumn(name = "bikeId")
	@JsonManagedReference
	private Bike bike;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bike")
	private OrderRow orderRow;

	public SingleBike() {
		size = "";
		bike = new Bike();
	}

	public SingleBike(String size, Bike bike) {
		this.size = size;
		this.bike = bike;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	@Override
	public String toString() {
		return "SingleBike [id=" + id + ", size=" + size + ", bike=" + bike + "]";
	}

}

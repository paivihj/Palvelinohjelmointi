package fi.pju.Bikeshop.domain;

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
public class OrderRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long rowId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonManagedReference
	private Order order;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id", nullable=false)
	private SingleBike bike;

	public OrderRow() {

	}

	public long getId() {
		return rowId;
	}

	public void setId(long id) {
		this.rowId = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public SingleBike getBike() {
		return bike;
	}

	public void setBike(SingleBike bike) {
		this.bike = bike;
	}
	
}

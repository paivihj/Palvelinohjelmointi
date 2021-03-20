package fi.pju.Bikeshop.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ordertable")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	private double discount;
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonManagedReference
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderRow> orderRows;

	public Order() {
	
	}

	public Order(double discount, LocalDate orderDate, Customer customer) {
		this.discount = discount;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	public long getId() {
		return orderId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderRow> getOrderRows() {
		return orderRows;
	}

	public void setOrderRows(List<OrderRow> orderRows) {
		this.orderRows = orderRows;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", discount=" + discount + ", orderDate=" + orderDate + "]";
	}
	
	

}

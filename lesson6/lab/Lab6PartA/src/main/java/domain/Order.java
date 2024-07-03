package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.CascadeType;

import java.util.Date;

import domain.Customer;
import domain.OrderLine;
import javax.persistence.FetchType;


@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordernr;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String status;

	@ManyToOne(/*cascade = CascadeType.ALL*/fetch = FetchType.EAGER)
	private Customer customer;

	@OneToMany(fetch=FetchType.EAGER)
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order( String status) {
		this.status = status;
	}



	public long getOrdernr() {
		return ordernr;
	}

//	public void setOrdernr(String ordernr) {
//		this.ordernr = ordernr;
//	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

	@Override
	public String toString() {
		return "Order [ordernr=" + ordernr + ", date=" + date + ", status=" + status + "]";
	}

}

package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name="order_table")
public class Order {
	    private String ordernr;
	    private String date;
	    private String status;
	    @Id  
	    @GeneratedValue
	    private long id;
		@ManyToOne (cascade={CascadeType.PERSIST})
		private Customer customer;

	    @OneToMany (cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	    private Collection<OrderLine> orderlines=new ArrayList<OrderLine>();
	    
	    public Order(){}
	    public Order(String ordernr, String date, String status){
	    	this.ordernr=ordernr;
	    	this.date=date;
	    	this.status=status;
	    }
	    public void addOrderLine(OrderLine ol){
	    	orderlines.add(ol);
	    }
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getOrdernr() {
			return ordernr;
		}
		public void setOrdernr(String ordernr) {
			this.ordernr = ordernr;
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
			return orderlines;
		}
		public void setOrderlines(Collection<OrderLine> orderlines) {
			this.orderlines = orderlines;
		}
}

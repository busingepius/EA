package domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
public class Customer {
    private String firstname;
    private String lastname;

    @Id  
    @GeneratedValue
    private long id;
    
    @OneToMany (cascade={CascadeType.PERSIST},  mappedBy="customer")
    private Collection<Order> theOrders=new ArrayList<Order>();

    @ManyToOne(cascade={CascadeType.PERSIST})
    private Address address;
    
    public Customer(){
    	
    }
    public Customer(String firstname,String lastname){
    	this.firstname=firstname;
    	this.lastname=lastname;

    }

	public void addOrder(Order order){
		theOrders.add(order);
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Collection<Order> getTheOrders() {
		return theOrders;
	}
	public void setTheOrders(Collection<Order> theOrders) {
		this.theOrders = theOrders;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}

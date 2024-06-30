package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import  java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.List;


import java.util.ArrayList;

// one to many
// order column
// from and to are reserved words in SQL

@Entity
public class Passenger{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Passenger(){}

    public Passenger(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @OrderColumn(name = "flight_order")
    private List<Flight> flights = new ArrayList<Flight>();

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlight(Flight flight) {
        this.flights.add(flight);
    }

}
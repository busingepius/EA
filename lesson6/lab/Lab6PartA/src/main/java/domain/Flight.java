package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Entity
public class Flight{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String flightNumber;
    @Column(name = "from_location")
    private String from;
    @Column(name = "to_location")
    private String to;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Flight(){}

    public Flight(String flightNumber, String from, String to){
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
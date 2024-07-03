package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private long id;
//    Temporal(TemporalType.DATE)
//    private Date date;
//    Temporal(TemporalType.TIME)
//    private Time time;
    private String message;

    public TraceRecord() {
    }

    public TraceRecord(long id,String message) {
        this.message = message;this.id
    }

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Time getTime() {
//        return time;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
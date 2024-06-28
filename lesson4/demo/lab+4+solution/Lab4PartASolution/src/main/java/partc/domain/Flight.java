package partc.domain;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Flight {

	@Id
	private long flightnumber;
	@Column(name = "origin")
	private String from;
	@Column(name = "destination")
	private String to;
	private Date date;

	public Flight() {
	}

	public Flight(long flightnumber, String from, String to, Date date) {
		this.flightnumber = flightnumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}

	public long getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(long flightnumber) {
		this.flightnumber = flightnumber;
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

	@Override
	public String toString() {
		return "Flight{" +
				"flightnumber=" + flightnumber +
				", from='" + from + '\'' +
				", to='" + to + '\'' +
				", date=" + date +
				'}';
	}
}

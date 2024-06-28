package partc;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import partb.domain.Book;
import partc.domain.Flight;
import partc.domain.Passenger;
import partc.repositories.PassengerRepository;



@SpringBootApplication
public class FlightApplication implements CommandLineRunner {
	@Autowired
	PassengerRepository passengerRepository;

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flight flight1 = new Flight(10034,"Amsterdam", "Boston", new Date());
		Flight flight2 = new Flight(10045,"Amsterdam", "Chicago", new Date());
		Flight flight3 = new Flight(10072,"Chicago", "Paris", new Date());
		Passenger passenger = new Passenger("Frank Brown");

		// please note, the order in which they are added here
		// should also be the order in which they are printed
		passenger.addFlight(flight1);
		passenger.addFlight(flight3);
		passenger.addFlight(flight2);

		passengerRepository.save(passenger);


		Optional<Passenger> passengerOpt = passengerRepository.findById(1L);
		Passenger passenger2 = passengerOpt.get();
		System.out.println(passenger2);

	}

}

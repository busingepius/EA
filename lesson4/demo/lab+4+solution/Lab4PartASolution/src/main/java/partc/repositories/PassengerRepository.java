package partc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parta.domain.Department;
import partc.domain.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}

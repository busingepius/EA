package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Address;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    // Native Query. Give all addresses in Amsterdam.
    @Query(value = "SELECT * FROM Address WHERE city = :city", nativeQuery = true)
    List<Address> findByCity(String city);
}

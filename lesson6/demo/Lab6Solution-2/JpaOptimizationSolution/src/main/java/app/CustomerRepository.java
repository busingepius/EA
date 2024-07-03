package app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c join fetch c.account")
    List<Customer> getAllCustomers();

    @Modifying
    @Transactional
    @Query("update Customer c set c.name = :cname")
    void updateCustomersName(@Param("cname") String name);




}





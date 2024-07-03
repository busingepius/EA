package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.domain.Specification;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,JpaSpecificationExecutor<Customer>{
    // Get all customers with zip code 2389HJ
    @Query("SELECT c FROM Customer c WHERE c.address.zip = :zip")
    List<Customer> findByZip(String zip);

    // Get all customers who ordered a DVD with the name Rocky3 and genre Action
    @Query("SELECT c FROM Customer c JOIN c.theOrders o JOIN o.orderlines ol JOIN ol.product p WHERE p.name = :name ")
    List<Customer> findByDVDName(String name);

//    Give all customers from the USA.
    @Query("SELECT c FROM Customer c JOIN c.address a WHERE a.country = :country")
    List<Customer> findByCountry(String country);

    // Give the first and lastnames of all customers who live in Amsterdam.
    @Query("SELECT c FROM Customer c JOIN c.address a WHERE a.city = :city")
    List<Customer> findByCity(String city);

    // Use Specifications. Give all customers who live in Amsterdam.
    List<Customer> findAll(Specification<Customer> spec);
}
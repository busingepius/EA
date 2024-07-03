package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.domain.Specification;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>  {
    //    Give the ordernumbers of all orders with status ‘closed’
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(String status);

    // Give the ordernumbers of all orders from customers who live in a certain city (city is a parameter)
    @Query("SELECT o FROM Order o JOIN o.customer c JOIN c.address a WHERE a.city = :city")
    List<Order> findByCity(String city);

    // Use Specifications. Give the ordernumbers of all orders with status ‘closed’
    List<Order> findAll(Specification<Order> spec);
}
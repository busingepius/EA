package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
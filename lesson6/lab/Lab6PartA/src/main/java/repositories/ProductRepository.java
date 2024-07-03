package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

}
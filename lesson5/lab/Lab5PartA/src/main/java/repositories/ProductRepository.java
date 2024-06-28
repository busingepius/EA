package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long>{

}
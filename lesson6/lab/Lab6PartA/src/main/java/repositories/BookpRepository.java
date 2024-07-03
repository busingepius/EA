package repositories;


import domain.Bookp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookpRepository extends JpaRepository<Bookp, Long> {
}
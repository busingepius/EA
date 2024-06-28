package repositories;

import domain.CD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD, Long> {
}
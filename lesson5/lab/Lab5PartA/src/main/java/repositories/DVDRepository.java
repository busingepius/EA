package repositories;

import domain.DVD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD, Long> {
}
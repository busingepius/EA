package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
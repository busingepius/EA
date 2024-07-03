package repositories;

import domain.CD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CDRepository extends JpaRepository<CD, Long>,JpaSpecificationExecutor<CD> {
    // Get all CD’s from U2 with a price smaller than 10 euro
    List<CD> findByPriceLessThan(double price);
//    Give all CD’s from a certain artist
    List<CD> findByArtist(String artist);
    // Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2)
    @Query("SELECT c FROM CD c WHERE c.artist = :artist AND c.price > :price")
    List<CD> findByArtistAndPriceGreaterThan(String artist, double price);
    // Native Query. Give all CD’s from U2
    @Query(value = "SELECT * FROM CD WHERE artist = :artist", nativeQuery = true)
    List<CD> findByArtistt(String artist);

    // Using Specifications. Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2)
    List<CD> findAll(Specification<CD> spec);
}
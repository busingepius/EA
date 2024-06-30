package repositories;

import java.util.List;
import java.util.Optional;

import domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(String author);
    Optional<Book> findByISBN(String ISBN);
    Book findByTitleAndAuthor(String title, String author);
    List<Book> findFirst2By();

    @Query("select b.ISBN from Book b where b.title= :title")
    String findISBNByTitle(@Param("title") String title);

}
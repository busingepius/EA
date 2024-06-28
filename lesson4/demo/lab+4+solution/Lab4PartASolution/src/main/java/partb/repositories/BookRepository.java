package partb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parta.domain.Department;
import partb.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

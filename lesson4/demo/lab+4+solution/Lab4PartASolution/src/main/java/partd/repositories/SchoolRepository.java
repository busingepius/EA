package partd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import partd.domain.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
}

package parta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import parta.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

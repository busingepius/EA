package com.gegabox.lab6partb.repositories;

import com.gegabox.lab6partb.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

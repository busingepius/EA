package com.gegabox.lab6partb.repositories;

import com.gegabox.lab6partb.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}

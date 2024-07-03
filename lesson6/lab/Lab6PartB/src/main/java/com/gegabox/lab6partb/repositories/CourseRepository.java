package com.gegabox.lab6partb.repositories;

import com.gegabox.lab6partb.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

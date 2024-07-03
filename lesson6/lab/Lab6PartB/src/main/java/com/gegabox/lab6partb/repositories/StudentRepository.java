package com.gegabox.lab6partb.repositories;

import jakarta.persistence.Param;

import com.gegabox.lab6partb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Get all students from a certain department
    List<Student> findByDepartmentName(String departmentName);

    // Get all students who took a course with a certain name
    List<Student> findByGradesCourseName(String courseName);

    // Get all students from a certain department
    @Query("SELECT s FROM Student s JOIN s.department d WHERE d.name = ?1")
    List<Student> findByDepartmentNameQuery(String departmentName);

    // Get all students who took a course with a certain name.
    @Query("SELECT s FROM Student s JOIN s.grades g JOIN g.course c WHERE c.name = :courseName")
    List<Student> findByGradesCourseNameQuery(@Param String courseName);
}

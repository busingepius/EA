package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartmentName(String department);
    List<Student> findByGradesCourseName(String coursename);

    @Query("select distinct s from Student s join fetch s.grades join fetch s.department where s.department.name = :departmentname")
    List<Student> getStudentsFromDepartment(@Param("departmentname") String department);

    @Query("select distinct s from Student s join fetch s.grades sg join fetch s.department where sg.course.name = :coursename")
    List<Student> getStudentsWhoTookCourse(@Param("coursename") String coursename);
}

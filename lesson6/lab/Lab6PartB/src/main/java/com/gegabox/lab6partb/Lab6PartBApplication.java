package com.gegabox.lab6partb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gegabox.lab6partb.domain.Course;
import com.gegabox.lab6partb.domain.Department;
import com.gegabox.lab6partb.domain.Grade;
import com.gegabox.lab6partb.domain.Student;

//repository
import com.gegabox.lab6partb.repositories.CourseRepository;
import com.gegabox.lab6partb.repositories.DepartmentRepository;
import com.gegabox.lab6partb.repositories.GradeRepository;
import com.gegabox.lab6partb.repositories.StudentRepository;

@SpringBootApplication
public class Lab6PartBApplication implements CommandLineRunner {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab6PartBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course("CSC 101");
        courseRepository.save(course1);

        Department department1 = new Department("Computer Science");
        departmentRepository.save(department1);

        Grade grade1 = new Grade("A");
        grade1.setCourse(course1);
        gradeRepository.save(grade1);

        Student student1 = new Student("John Doe");
        student1.setDepartment(department1);
        studentRepository.save(student1);

        // Get all students from a certain department
        studentRepository.findByDepartmentName("Computer Science").forEach(System.out::println);

        // Get all students who took a course with a certain name
        studentRepository.findByGradesCourseName("CSC 101").forEach(System.out::println);

         // Get all students from a certain department
        studentRepository.findByDepartmentNameQuery("Computer Science").forEach(System.out::println);

        // Get all students who took a course with a certain name.
        System.out.println("-----------".repeat(30));
        studentRepository.findByGradesCourseNameQuery("CSC 101").forEach(System.out::println);

    }

}

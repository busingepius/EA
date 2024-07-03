package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.StudentRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class SchoolApplication implements CommandLineRunner{
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course1 = new Course("Programming 1");
		Course course2 = new Course("Enterprise Architecture");
		courseRepository.save(course1);
		courseRepository.save(course2);
		Department department = new Department("Computer Science");
		departmentRepository.save(department);

		Student s1 = new Student(1L, "Frank Brown");
		Student s2 = new Student(2L, "John Doe");
		Student s3 = new Student(3L, "Mary Johnson");

		s1.setDepartment(department);
		s2.setDepartment(department);
		s3.setDepartment(department);

		Grade g1 = new Grade("A", course1);
		gradeRepository.save(g1);
		s1.addGrade(g1);
		Grade g2 = new Grade("A-", course2);
		gradeRepository.save(g2);
		s1.addGrade(g2);
		Grade g3 = new Grade("B", course1);
		gradeRepository.save(g3);
		s2.addGrade(g3);
		Grade g4 = new Grade("C", course1);
		gradeRepository.save(g4);
		s3.addGrade(g4);
		Grade g5 = new Grade("C+", course2);
		gradeRepository.save(g5);
		s3.addGrade(g5);

		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);

		List<Student> students = studentRepository.findByDepartmentName("Computer Science");
		System.out.println("------All students from the computer science department  -------------------");
		students.stream().forEach(c->System.out.println(c));

		List<Student> students2 = studentRepository.getStudentsFromDepartment("Computer Science");
		System.out.println("------All students from the computer science department  -------------------");
		students2.stream().forEach(c->System.out.println(c));

		List<Student> students3 = studentRepository.getStudentsWhoTookCourse("Enterprise Architecture");
		System.out.println("------All students who took Enterprise Architecture  -------------------");
		students3.stream().forEach(c->System.out.println(c));

		List<Student> students4 = studentRepository.findByGradesCourseName("Enterprise Architecture");
		System.out.println("------All students who took Enterprise Architecture  -------------------");
		students4.stream().forEach(c->System.out.println(c));
	}


}


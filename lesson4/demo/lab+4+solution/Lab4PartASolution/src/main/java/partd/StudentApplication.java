package partd;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import partd.domain.School;
import partd.domain.Student;
import partd.repositories.SchoolRepository;



@SpringBootApplication
public class StudentApplication implements CommandLineRunner {
	@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(1, "Frank","Brown");
		Student student2 = new Student(2, "John","Doe");
		School school = new School("Happy HighSchool");
		school.addStudent(student1);
		school.addStudent(student2);

		schoolRepository.save(school);


		Optional<School> schoolOpt = schoolRepository.findById(1L);
		School school2 = schoolOpt.get();
		System.out.println(school2);

	}

}
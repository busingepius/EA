package parta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import parta.domain.Department;
import parta.domain.Employee;
import parta.repositories.DepartmentRepository;

import java.util.Optional;

@SpringBootApplication
public class DepartmentApplication implements CommandLineRunner {
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = new Department("accounting");
		Employee employee1 = new Employee("Frank Brown","062341234");
		Employee employee2 = new Employee("John Doe","064362738");
		department.addEmployee(employee1);
		department.addEmployee(employee2);
		employee1.setDepartment(department);
		employee2.setDepartment(department);

		departmentRepository.save(department);


		Optional<Department> deptOpt = departmentRepository.findById(1L);
		Department department2 = deptOpt.get();
		System.out.println(department2);

	}

}

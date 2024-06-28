package parta.domain;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Collection<Employee> employeelist = new ArrayList<Employee>();

	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployeelist() {
		return employeelist;
	}

	private void setEmployeelist(Collection<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public void addEmployee(Employee employee) {
		employeelist.add(employee);
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", employeelist=" + employeelist +
				'}';
	}
}

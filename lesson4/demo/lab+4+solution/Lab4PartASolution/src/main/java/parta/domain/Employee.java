package parta.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private long employeenumber;
	private String name;
	private String phone;
	@ManyToOne
	@JoinColumn(name = "department")
	Department department;

	public Employee() {
	}

	public Employee(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public long getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(long employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeenumber=" + employeenumber +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}

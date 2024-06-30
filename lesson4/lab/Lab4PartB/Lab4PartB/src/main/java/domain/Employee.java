package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.Department;


@Entity

public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeenumber;
    private String name;

    public Employee(){

    }

    public Employee(String name){
        this.name = name;
    }

    public long getEmployeenumber() {
        return employeenumber;
    }

//    public void setEmployeenumber(long employeenumber) {
//        this.employeenumber = employeenumber;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToOne
    private Department department;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
package com.gegabox.lab6partb.domain;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long studentnumber;
    private String name;

    public Student(){}

    public Student( String name){
        this.name = name;
    }

    public Long getStudentnumber() {
        return studentnumber;
    }

//    public void setStudentnumber(Long studentnumber) {
//        this.studentnumber = studentnumber;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Grade> grades;

//    public void setStudentnumber(Long studentnumber) {
//        this.studentnumber = studentnumber;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student [studentnumber=" + studentnumber + ", name=" + name + "]";
    }
}

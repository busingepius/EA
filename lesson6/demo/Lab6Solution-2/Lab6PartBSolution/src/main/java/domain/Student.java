package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private long studentNumber;
    private String name;
    @ManyToOne
    private Department department;
    @OneToMany(fetch=FetchType.EAGER)
    private List<Grade> grades = new ArrayList<Grade>();

    public Student() {
    }

    public Student(long studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", grades=" + grades +
                '}';
    }
}

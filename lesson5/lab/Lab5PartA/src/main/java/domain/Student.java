package domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long student_id;
    private String first_name;
    private String last_name;

    public Student() {
    }

    public Student(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public long getStudent_id() {
        return student_id;
    }

//    public void setStudent_id(long student_id) {
//        this.student_id = student_id;
//    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
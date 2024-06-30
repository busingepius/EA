package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.Map;
import javax.persistence.MapKey;
import java.util.HashMap;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
// key is the student's first name
    @MapKey(name = "student_id")
    private Map<Long, Student> student = new HashMap<>();

    public Map<Long, Student> getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student.put(student.getStudent_id(), student);
    }
}
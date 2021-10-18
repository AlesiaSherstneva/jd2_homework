package by.academy.it.pojos.perclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_PER_CLASS")
@Getter
@Setter
public class StudentPerClass extends PersonPerClass {
    private String faculty;
    private Double mark;

    public StudentPerClass() {
    }

    public StudentPerClass(Integer age, String name, String surname, String faculty, Double mark) {
        super(age, name, surname);
        this.faculty = faculty;
        this.mark = mark;
    }
}

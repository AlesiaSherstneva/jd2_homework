package by.academy.it.pojos.persubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_PER_SUBCLASS")
@PrimaryKeyJoinColumn(name = "person_id")
@Getter
@Setter
public class StudentPerSubclass extends PersonPerSubclass {
    private String faculty;
    private Double mark;

    public StudentPerSubclass() {
    }

    public StudentPerSubclass(Integer age, String name, String surname, String faculty, Double mark) {
        super(age, name, surname);
        this.faculty = faculty;
        this.mark = mark;
    }
}

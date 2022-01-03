package by.academy.it.pojos.single;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
@Getter
@Setter
public class StudentSingle extends PersonSingle {
    private String faculty;
    private Double mark;

    public StudentSingle() {
    }

    public StudentSingle(Integer age, String name, String surname, String faculty, Double mark) {
        super(age, name, surname);
        this.faculty = faculty;
        this.mark = mark;
    }
}

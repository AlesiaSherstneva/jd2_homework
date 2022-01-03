package by.academy.it.pojos.single;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON_SINGLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
@Getter
@Setter
public class PersonSingle implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "person_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    public PersonSingle() {
    }

    public PersonSingle(Integer age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
}

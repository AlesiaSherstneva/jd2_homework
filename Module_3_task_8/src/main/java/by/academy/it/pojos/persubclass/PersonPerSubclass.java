package by.academy.it.pojos.persubclass;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON_PER_SUBCLASS")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class PersonPerSubclass implements Serializable {

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

    public PersonPerSubclass() {
    }

    public PersonPerSubclass(Integer age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
}

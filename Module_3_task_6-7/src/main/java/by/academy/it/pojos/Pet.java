package by.academy.it.pojos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Pets")
@Getter
@Setter
public class Pet implements Serializable {

    @Id
    @GenericGenerator(name = "randomGenerator", strategy = "by.academy.it.generators.RandomIdGenerator")
    @GeneratedValue(generator = "randomGenerator")
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "kind_of_animal")
    private String animal;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;


    public Pet() {
    }

    public Pet(String animal, String name, Person owner) {
        this.animal = animal;
        this.name = name;
        this.owner = owner;
    }
}

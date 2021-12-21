package by.academy.it.pojos;

import by.academy.it.embedded.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "HIBERNATE_SEQUENCE")
    @Column(name = "person_id")
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Embedded
    private Address address;

    @OneToMany(targetEntity = Pet.class, mappedBy = "owner")
    private List<Pet> pets;

    @OneToMany(targetEntity = BankAccount.class, mappedBy = "owner")
    private List<BankAccount> bankAccounts;

    public Person() {
    }

    public Person(Integer age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public Person(Integer age, String name, String surname, Address address) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}

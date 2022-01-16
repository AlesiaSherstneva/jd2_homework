package by.academy.it.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String surname;
    private Integer age;
    private IAddress address;

    private Person() {
    }

    public static Person getPerson() {
        return new Person();
    }

    @Override
    public String toString(){
        return "I am " + name + " " + surname + ", " + age + " years old.\nI live in: " + address;
    }

    public void personInit() {
        System.out.println("Person is initializing");
    }

    public void personDestroy() {
        System.out.println("Person was destroyed");
    }
}

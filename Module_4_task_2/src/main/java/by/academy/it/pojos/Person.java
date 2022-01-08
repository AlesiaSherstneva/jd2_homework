package by.academy.it.pojos;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private Integer age;
    private IAddress address;

    @Override
    public String toString(){
        return "I am " + name + " " + surname + ", " + age + " years old.\nI live in: " + address;
    }
}

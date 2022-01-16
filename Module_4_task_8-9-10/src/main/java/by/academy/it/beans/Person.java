package by.academy.it.beans;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {
    @Value("${person.name}")
    private String name;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private Integer age;

    @Autowired
    @Qualifier("homeAddress")
    private IAddress firstAddress;

    @Autowired
    @Qualifier("workAddress")
    private IAddress secondAddress;

    private Person() {
    }

    @Override
    public String toString() {
        return "I am " + name + " " + surname + ", " + age + " years old.\nI live at: " + firstAddress +
                "\nI work at: " + secondAddress;
    }
}

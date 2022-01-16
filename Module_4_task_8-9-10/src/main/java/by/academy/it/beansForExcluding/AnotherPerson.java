package by.academy.it.beansForExcluding;

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
public class AnotherPerson {
    @Value("Alesia")
    private String name;

    @Value("Sherstneva")
    private String surname;

    @Value("39")
    private Integer age;

    @Autowired
    @Qualifier("anotherHomeAddress")
    private IAddress firstAddress;

    @Autowired
    @Qualifier("anotherWorkAddress")
    private IAddress secondAddress;

    private AnotherPerson() {
    }

    @Override
    public String toString() {
        return "I am " + name + " " + surname + ", " + age + " years old.\nI live at: " + firstAddress +
                "\nI work at: " + secondAddress;
    }
}

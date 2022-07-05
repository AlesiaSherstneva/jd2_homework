package by.academy.it.beansForExcluding;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
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

    private final IAddress firstAddress;

    private final IAddress secondAddress;

    private AnotherPerson(@Qualifier("anotherHomeAddress") IAddress firstAddress, @Qualifier("anotherWorkAddress") IAddress secondAddress) {
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
    }

    @Override
    public String toString() {
        return "I am " + name + " " + surname + ", " + age + " years old.\nI live at: " + firstAddress +
                "\nI work at: " + secondAddress;
    }
}

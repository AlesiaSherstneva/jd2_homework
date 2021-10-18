package by.academy.it.persons;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Person {
    private String name;
    private String surname;
    private Integer age;
    private String company;
    private BigDecimal salary;
    private String faculty;
    private Double mark;
}

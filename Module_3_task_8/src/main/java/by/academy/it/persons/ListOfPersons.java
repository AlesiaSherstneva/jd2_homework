package by.academy.it.persons;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ListOfPersons {
    Person firstPerson = new Person();
    Person secondPerson = new Person();
    Person firstEmployee = new Person();
    Person secondEmployee = new Person();
    Person student = new Person();

    public Person getFirstPerson() {
        firstPerson.setName("Anna");
        firstPerson.setSurname("Smirnova");
        firstPerson.setAge(67);
        return firstPerson;
    }

    public Person getSecondPerson() {
        secondPerson.setName("Vasily");
        secondPerson.setSurname("Vasilyev");
        secondPerson.setAge(15);
        return secondPerson;
    }

    public Person getFirstEmployee() {
        firstEmployee.setName("Natalia");
        firstEmployee.setSurname("Krupskaya");
        firstEmployee.setAge(33);
        firstEmployee.setCompany("Belpochta");
        firstEmployee.setSalary(new BigDecimal("1050.26"));
        return firstEmployee;
    }

    public Person getSecondEmployee() {
        secondEmployee.setName("Ivan");
        secondEmployee.setSurname("Petrov");
        secondEmployee.setAge(41);
        secondEmployee.setCompany("Beltelecom");
        secondEmployee.setSalary(new BigDecimal("1240.45"));
        return secondEmployee;
    }

    public Person getStudent() {
        student.setName("Petr");
        student.setSurname("Ivanov");
        student.setAge(20);
        student.setFaculty("Programming");
        student.setMark(6.92);
        return student;
    }
}

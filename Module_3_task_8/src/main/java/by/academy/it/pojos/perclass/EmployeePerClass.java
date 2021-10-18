package by.academy.it.pojos.perclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "EMPLOYEE_PER_CLASS")
@Getter
@Setter
public class EmployeePerClass extends PersonPerClass {
    private String company;
    private BigDecimal salary;

    public EmployeePerClass() {
    }

    public EmployeePerClass(Integer age, String name, String surname, String company, BigDecimal salary) {
        super(age, name, surname);
        this.company = company;
        this.salary = salary;
    }
}

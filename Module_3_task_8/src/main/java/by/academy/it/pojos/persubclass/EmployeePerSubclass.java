package by.academy.it.pojos.persubclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "EMPLOYEE_PER_SUBCLASS")
@PrimaryKeyJoinColumn(name = "person_id")
@Getter
@Setter
public class EmployeePerSubclass extends PersonPerSubclass {
    private String company;
    private BigDecimal salary;

    public EmployeePerSubclass() {
    }

    public EmployeePerSubclass(Integer age, String name, String surname, String company, BigDecimal salary) {
        super(age, name, surname);
        this.company = company;
        this.salary = salary;
    }
}

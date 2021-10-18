package by.academy.it.pojos.single;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("E")
@Getter
@Setter
public class EmployeeSingle extends PersonSingle {
    private String company;
    private BigDecimal salary;

    public EmployeeSingle() {
    }

    public EmployeeSingle(Integer age, String name, String surname, String company, BigDecimal salary) {
        super(age, name, surname);
        this.company = company;
        this.salary = salary;
    }
}

package by.academy.it.beansForExcluding;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AnotherHomeAddress implements IAddress {
    @Value("Belarus")
    private String country;

    @Value("Minsk")
    private String city;

    @Value("Korolia")
    private String street;

    @Value("6")
    private Integer house;

    @Value("76")
    private Integer apartment;

    private AnotherHomeAddress() {
    }

    @Override
    public String toString(){
        return country + ", " + city + ", " + street + ", " + house + "-" + apartment + ".";
    }
}

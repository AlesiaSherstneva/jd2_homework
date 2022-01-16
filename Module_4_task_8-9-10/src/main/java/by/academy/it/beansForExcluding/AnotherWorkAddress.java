package by.academy.it.beansForExcluding;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AnotherWorkAddress implements IAddress {

    @Value("Minsk")
    private String city;

    @Value("Odintsova")
    private String street;

    @Value("36")
    private Integer house;

    private AnotherWorkAddress() {
    }

    @Override
    public String toString() {
        return city + ", " + street + ", " + house + ".";
    }
}

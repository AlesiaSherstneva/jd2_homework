package by.academy.it.beans;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class WorkAddress implements IAddress {

    @Value("${workAddress.city}")
    private String city;

    @Value("${workAddress.street}")
    private String street;

    @Value("${workAddress.house}")
    private Integer house;

    private WorkAddress() {
    }

    @Override
    public String toString() {
        return city + ", " + street + ", " + house + ".";
    }
}

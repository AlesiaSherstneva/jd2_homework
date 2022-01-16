package by.academy.it.beans;

import by.academy.it.interfaces.IAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class HomeAddress implements IAddress {

    @Value("${homeAddress.country}")
    private String country;

    @Value("${homeAddress.city}")
    private String city;

    @Value("${homeAddress.street}")
    private String street;

    @Value("${homeAddress.house}")
    private Integer house;

    @Value("${homeAddress.apartment}")
    private Integer apartment;

    private HomeAddress() {
    }

    @Override
    public String toString(){
        return country + ", " + city + ", " + street + ", " + house + "-" + apartment + ".";
    }
}

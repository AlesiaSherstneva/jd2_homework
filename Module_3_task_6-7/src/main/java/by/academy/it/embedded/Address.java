package by.academy.it.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String postalCode;
    private String city;
    private String street;
    private String houseAndApartment;

    public Address() {
    }

    public Address(String postalCode, String city, String street, String houseAndApartment) {
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.houseAndApartment = houseAndApartment;
    }
}

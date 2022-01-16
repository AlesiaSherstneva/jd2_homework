package by.academy.it.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements IAddress {

    private String country;
    private String city;
    private String street;
    private Integer house;
    private Integer apartment;

    public Address() {
    }

    public Address(String country, String city, String street, Integer house, Integer apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    @Override
    public String toString(){
        return country + ", " + city + ", " + street + ", " + house + "-" + apartment + ".";
    }

    public void addressInit() {
        System.out.println("Address is initializing");
    }

    /* метод addressDestroy() не будет вызван, так как у бина Address scope = "prototype"
       но добавляю его, так как это требуется по условию задания */

    public void addressDestroy() {
        System.out.println("Address was destroyed");
    }
}

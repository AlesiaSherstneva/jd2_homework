package by.academy.it;

import by.academy.it.pojos.Address;
import by.academy.it.pojos.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonTest {
    Person person;
    Address address;
    ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        person = context.getBean("Person", Person.class);
        address = (Address) person.getAddress();
    }

    @Test
    public void personDataTest() {
        assertEquals(person.getName(), "testName");
        assertEquals(person.getSurname(), "testSurname");
        assertEquals(person.getAge(), (Integer) 1000);

        assertEquals(address.getCountry(), "testCountry");
        assertEquals(address.getCity(), "testCity");
        assertEquals(address.getStreet(), "testStreet");
        assertEquals(address.getHouse(), (Integer) 0);
        assertEquals(address.getApartment(), (Integer) 0);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }
}
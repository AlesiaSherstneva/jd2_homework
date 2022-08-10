package by.academy.it;

import by.academy.it.beans.Address;
import by.academy.it.beans.Person;
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
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
    }

    @Test
    public void personTest() {
        person = context.getBean("Person", Person.class);
        address = (Address) person.getAddress();

        assertEquals("testName", person.getName());
        assertEquals("testSurname", person.getSurname());
        assertEquals((Integer) 1000, person.getAge());

        assertEquals("testCountry", address.getCountry());
        assertEquals("testCity", address.getCity());
        assertEquals("testStreet", address.getStreet());
        assertEquals((Integer) 0, address.getHouse());
        assertEquals((Integer) 0, address.getApartment());
    }

    @After
    public void tearDown() {
        context.close();
    }
}
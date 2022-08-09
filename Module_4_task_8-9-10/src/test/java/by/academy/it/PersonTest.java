package by.academy.it;

import by.academy.it.beans.*;
import by.academy.it.beansForExcluding.AnotherPerson;
import org.junit.*;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonTest {
    Person firstPerson;
    AnotherPerson secondPerson;
    ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
    }

    @Test
    public void personTest() {
        firstPerson = context.getBean("person", Person.class);

        assertEquals(firstPerson.getName(), "testName");
        assertEquals(firstPerson.getSurname(), "testSurname");
        assertEquals(firstPerson.getAge(), (Integer) 1000);

        HomeAddress homeAddress = (HomeAddress) firstPerson.getFirstAddress();

        assertEquals(homeAddress.getCountry(), "testCountry");
        assertEquals(homeAddress.getCity(), "testCity");
        assertEquals(homeAddress.getStreet(), "testStreet");
        assertEquals(homeAddress.getHouse(), (Integer) 0);
        assertEquals(homeAddress.getApartment(), (Integer) 0);

        WorkAddress workAddress = (WorkAddress) firstPerson.getSecondAddress();

        assertEquals(workAddress.getCity(), "testCity");
        assertEquals(workAddress.getStreet(), "testStreet");
        assertEquals(workAddress.getHouse(), (Integer) 0);
    }

    @Test
    public void anotherPersonTest() {
        try {
            secondPerson = context.getBean("anotherPerson", AnotherPerson.class);
            fail("Expected NoSuchBeanDefinitionException");
        } catch (NoSuchBeanDefinitionException exception) {
            assertEquals("No bean named 'anotherPerson' available", exception.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }
}
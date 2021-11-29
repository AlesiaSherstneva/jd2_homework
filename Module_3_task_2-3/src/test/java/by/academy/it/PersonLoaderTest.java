package by.academy.it;

import by.academy.it.loader.PersonLoader;
import by.academy.it.pojos.Person;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonLoaderTest extends HibernateUtilTest {

    Person person = new Person(39, "Alesia", "Sherstneva");
    Session session = sessionFactory.openSession();

    @Before
    public void setUp() throws Exception {
        session.beginTransaction();
    }

    @Test
    public void savePersonTest() {
        Serializable id = PersonLoader.savePerson(session, person);
        assertEquals(id, 1L);
    }

    @Test
    public void getPersonTest() {
        PersonLoader.savePerson(session, person);
        
        Person gotPerson = PersonLoader.getPerson(session, person.getId());

        assertEquals(gotPerson.getAge(), (Integer) 39);
        assertEquals(gotPerson.getName(), "Alesia");
        assertEquals(gotPerson.getSurname(), "Sherstneva");
    }

    @Test
    public void loadPersonTest() {
        PersonLoader.savePerson(session, person);

        Person loadPerson = PersonLoader.loadPerson(session, person.getId());

        assertEquals(loadPerson.getAge(), (Integer) 39);
        assertEquals(loadPerson.getName(), "Alesia");
        assertEquals(loadPerson.getSurname(), "Sherstneva");
    }

    @Test
    public void deletePersonTest() {
        PersonLoader.savePerson(session, person);
        Long id = person.getId();

        PersonLoader.deletePerson(session, id);

        assertNull(PersonLoader.getPerson(session, id));
        assertNull(PersonLoader.loadPerson(session, id));
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }
}
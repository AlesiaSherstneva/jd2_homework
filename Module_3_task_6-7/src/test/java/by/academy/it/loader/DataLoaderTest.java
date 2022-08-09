package by.academy.it.loader;

import by.academy.it.pojos.Person;
import by.academy.it.util.HibernateUtilTest;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DataLoaderTest extends HibernateUtilTest {
    DataLoader dataLoader = new DataLoader();
    Session session;

    @Before
    public void setUp() throws Exception {
        dataLoader.loadData(sessionFactory);
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void loadPersonTest() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        criteria.from(Person.class);

        List<Person> personList = session.createQuery(criteria).getResultList();
        Person firstPerson = personList.get(0);
        Person secondPerson = personList.get(1);
        Person thirdPerson = personList.get(2);

        assertEquals("Ivan", firstPerson.getName());
        assertEquals("220136", firstPerson.getAddress().getPostalCode());
        assertEquals(2, firstPerson.getPets().size() );
        assertEquals(1, firstPerson.getBankAccounts().size() );

        assertEquals("Petrov", secondPerson.getSurname());
        assertEquals("Narodnaya", secondPerson.getAddress().getStreet());
        assertEquals(0, secondPerson.getPets().size());
        assertEquals("5462587436954128", secondPerson.getBankAccounts().get(0).getNumber());

        assertEquals((Integer) 41, thirdPerson.getAge());
        assertNull(thirdPerson.getAddress());
        assertEquals("parrot", thirdPerson.getPets().get(0).getAnimal() );
        assertEquals(0, thirdPerson.getBankAccounts().size());
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }
}
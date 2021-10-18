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

        assertEquals(firstPerson.getName(), "Ivan");
        assertEquals(firstPerson.getAddress().getPostalCode(), "220136");
        assertEquals(firstPerson.getPets().size(), 2);
        assertEquals(firstPerson.getBankAccounts().size(), 1);

        assertEquals(secondPerson.getSurname(), "Petrov");
        assertEquals(secondPerson.getAddress().getStreet(), "Narodnaya");
        assertEquals(secondPerson.getPets().size(), 0);
        assertEquals(secondPerson.getBankAccounts().get(0).getNumber(), "5462587436954128");

        assertEquals(thirdPerson.getAge(), (Integer) 41);
        assertNull(thirdPerson.getAddress());
        assertEquals(thirdPerson.getPets().get(0).getAnimal(), "parrot");
        assertEquals(thirdPerson.getBankAccounts().size(), 0);
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }
}
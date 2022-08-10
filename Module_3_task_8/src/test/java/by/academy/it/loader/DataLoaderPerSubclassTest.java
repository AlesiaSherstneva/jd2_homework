package by.academy.it.loader;

import by.academy.it.pojos.persubclass.*;
import by.academy.it.util.HibernateUtilTest;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataLoaderPerSubclassTest extends HibernateUtilTest {
    DataLoaderPerSubclass dataLoaderPerSubclass = new DataLoaderPerSubclass();
    Session session;

    @Before
    public void setUp() {
        dataLoaderPerSubclass.loadData(sessionFactory);
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void loadPersonTest() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PersonPerSubclass> criteria = builder.createQuery(PersonPerSubclass.class);
        criteria.from(PersonPerSubclass.class);

        List<PersonPerSubclass> personList = session.createQuery(criteria).getResultList();
        PersonPerSubclass personPerSubclass = personList.get(1);
        EmployeePerSubclass employeePerSubclass = (EmployeePerSubclass) personList.get(3);
        StudentPerSubclass studentPerSubclass = (StudentPerSubclass) personList.get(4);

        assertEquals(personPerSubclass.getName(), "Vasily");
        assertEquals(employeePerSubclass.getSalary(), new BigDecimal("1240.45"));
        assertEquals(studentPerSubclass.getFaculty(), "Programming");
    }

    @After
    public void tearDown() {
        session.getTransaction().commit();
        session.close();
    }
}

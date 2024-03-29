package by.academy.it.loader;

import by.academy.it.pojos.perclass.*;
import by.academy.it.util.HibernateUtilTest;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataLoaderPerClassTest extends HibernateUtilTest {
    DataLoaderPerClass dataLoaderPerClass = new DataLoaderPerClass();
    Session session;

    @Before
    public void setUp() {
        dataLoaderPerClass.loadData(sessionFactory);
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void loadPersonTest() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PersonPerClass> criteria = builder.createQuery(PersonPerClass.class);
        criteria.from(PersonPerClass.class);

        List<PersonPerClass> personList = session.createQuery(criteria).getResultList();
        PersonPerClass personPerClass = personList.get(0);
        EmployeePerClass employeePerClass = (EmployeePerClass) personList.get(3);
        StudentPerClass studentPerClass = (StudentPerClass) personList.get(4);

        assertEquals("Smirnova", personPerClass.getSurname());
        assertEquals("Beltelecom", employeePerClass.getCompany());
        assertEquals((Integer) 20, studentPerClass.getAge());
    }

    @After
    public void tearDown() {
        session.getTransaction().commit();
        session.close();
    }
}

package by.academy.it.loader;

import by.academy.it.pojos.single.*;
import by.academy.it.util.HibernateUtilTest;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataLoaderSingleTest extends HibernateUtilTest {
    DataLoaderSingle dataLoaderSingle = new DataLoaderSingle();
    Session session;

    @Before
    public void setUp() throws Exception {
        dataLoaderSingle.loadData(sessionFactory);
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void loadPersonTest() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PersonSingle> criteria = builder.createQuery(PersonSingle.class);
        criteria.from(PersonSingle.class);

        List<PersonSingle> personList = session.createQuery(criteria).getResultList();
        PersonSingle personSingle = personList.get(0);
        EmployeeSingle employeeSingle = (EmployeeSingle) personList.get(2);
        StudentSingle studentSingle = (StudentSingle) personList.get(4);

        assertEquals(personSingle.getAge(), (Integer) 67);
        assertEquals(employeeSingle.getCompany(), "Belpochta");
        assertEquals(studentSingle.getMark(), (Double) 6.92);
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }
}
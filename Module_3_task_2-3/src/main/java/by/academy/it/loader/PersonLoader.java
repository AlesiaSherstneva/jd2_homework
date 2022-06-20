package by.academy.it.loader;

import by.academy.it.pojos.Person;
import by.academy.it.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Scanner;

public class PersonLoader {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person();

        Scanner scanner = new Scanner(System.in);
        int age;
        do {
            System.out.println("Enter the age:");
            while (!scanner.hasNextInt()) {
                System.out.println("It's not a number! Enter correct number:");
                scanner.next();
            }
            age = scanner.nextInt();
        } while (age < 18 || age > 100);
        person.setAge(age);
        System.out.println("Enter your name:");
        person.setName(scanner.next());
        System.out.println("Enter your surname:");
        person.setSurname(scanner.next());

        savePerson(session, person);

        getPerson(session, person.getId());

        loadPerson(session, person.getId());

        deletePerson(session, person.getId());

        session.getTransaction().commit();
        session.close();
    }


    public static Serializable savePerson(Session session, Person person) {

        //System.out.println("New person created at: " + person.getTimestamp()); //returns null
        Serializable id = session.save(person);
        //System.out.println("New person created at: " + person.getTimestamp()); //returns current time
        //System.out.println(session.isDirty()); //return true

        session.flush();
        //System.out.println("New person created at: " + person.getTimestamp()); //returns current time
        //System.out.println(session.isDirty()); //return false

        session.refresh(person);

        // Если запустить refresh() без предварительного flush(), то триггерное время сотрётся

        return id;
    }


    public static Person getPerson(Session session, long id) {
        return session.get(Person.class, id);
    }

    public static Person loadPerson(Session session, Long id) {
        Person loadedPerson;
        try {
            loadedPerson = session.load(Person.class, id);
        } catch (HibernateException exception) {
            loadedPerson = null;
        }
        return loadedPerson;
    }

    public static void deletePerson(Session session, Long id) {
        try {
            session.delete(session.get(Person.class, id));
        } catch (ObjectNotFoundException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}

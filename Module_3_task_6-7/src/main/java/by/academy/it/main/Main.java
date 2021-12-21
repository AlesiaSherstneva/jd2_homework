package by.academy.it.main;

import by.academy.it.loader.DataLoader;
import by.academy.it.pojos.BankAccount;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Pet;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        DataLoader dataLoader = new DataLoader();
        dataLoader.loadData(sessionFactory);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~task_6~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Person> listOfPersons = loadAllData(session);
        for(Person gotPerson: listOfPersons) {
            System.out.print("Person " + gotPerson.getName() + " " + gotPerson.getSurname());
            System.out.print(" has id: " + gotPerson.getId() + " (sequence)\n");
            if (gotPerson.getPets().isEmpty()) {
                System.out.println("This person doesn't have any pets");
            } else {
                System.out.println("This person has pets:");
                for(Pet pet: gotPerson.getPets()) {
                    System.out.print(pet.getAnimal() + " " + pet.getName());
                    System.out.print(" has id: " + pet.getId() + " (random)\n");
                }
            }
            if (gotPerson.getBankAccounts().isEmpty()) {
                System.out.println("This person doesn't have any bank accounts");
            } else {
                System.out.println("This person has bank accounts:");
                for(BankAccount bankAccount: gotPerson.getBankAccounts()) {
                    System.out.print(bankAccount.getNumber());
                    System.out.print(" has id: " + bankAccount.getId() + " (uuid)\n");
                }
            }
            System.out.println("----------------------------------------------------------------");
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~task_7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Person gotPerson: listOfPersons) {
            System.out.print(gotPerson.getName() + " " + gotPerson.getSurname());
            if (gotPerson.getAddress() == null) {
                System.out.print(" is \"БОМЖ\" (have no address)" + "\n");
            } else {
                System.out.print(" lives on: " + gotPerson.getAddress().getPostalCode() + ", "
                        + gotPerson.getAddress().getCity() + ", "
                        + gotPerson.getAddress().getStreet() + ", "
                        + gotPerson.getAddress().getHouseAndApartment() + "\n");
            }
        }
        System.out.println("----------------------------------------------------------------");

        session.getTransaction().commit();
        session.close();
    }

    private static List<Person> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        criteria.from(Person.class);
        return session.createQuery(criteria).getResultList();
    }
}

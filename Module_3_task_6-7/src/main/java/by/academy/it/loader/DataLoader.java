package by.academy.it.loader;

import by.academy.it.embedded.Address;
import by.academy.it.pojos.BankAccount;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataLoader {

    public void loadData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person firstPerson = new Person(28, "Ivan", "Ivanov",
                new Address("220136", "Minsk", "Lobanka", "13/1-18"));
        session.save(firstPerson);

        Person secondPerson = new Person(33, "Petr", "Petrov");
        Address address = new Address();
        address.setPostalCode("220107");
        address.setCity("Minsk");
        address.setStreet("Narodnaya");
        address.setHouseAndApartment("15-56");
        secondPerson.setAddress(address);
        session.save(secondPerson);

        Person thirdPerson = new Person(41, "Anna", "Smirnova");
        session.save(thirdPerson);

        session.save(new Pet("cat", "Barsik", firstPerson));
        session.save(new Pet("dog", "Sharik", firstPerson));
        session.save(new Pet("parrot", "Kesha", thirdPerson));

        session.save(new BankAccount("7850570146021512", firstPerson));
        session.save(new BankAccount("5462587436954128", secondPerson));

        session.getTransaction().commit();
        session.close();
    }
}

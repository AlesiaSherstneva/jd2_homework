package by.academy.it.loader;

import by.academy.it.persons.ListOfPersons;
import by.academy.it.pojos.perclass.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataLoaderPerClass implements DataLoader {

    ListOfPersons listOfPersons = new ListOfPersons();

    public void loadData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        PersonPerClass firstPersonPerClass = new PersonPerClass(listOfPersons.getFirstPerson().getAge(),
                listOfPersons.getFirstPerson().getName(), listOfPersons.getFirstPerson().getSurname());
        PersonPerClass secondPersonPerClass = new PersonPerClass(listOfPersons.getSecondPerson().getAge(),
                listOfPersons.getSecondPerson().getName(), listOfPersons.getSecondPerson().getSurname());

        EmployeePerClass firstEmployeePerClass = new EmployeePerClass(listOfPersons.getFirstEmployee().getAge(),
                listOfPersons.getFirstEmployee().getName(), listOfPersons.getFirstEmployee().getSurname(),
                listOfPersons.getFirstEmployee().getCompany(), listOfPersons.getFirstEmployee().getSalary());
        EmployeePerClass secondEmployeePerClass = new EmployeePerClass(listOfPersons.getSecondEmployee().getAge(),
                listOfPersons.getSecondEmployee().getName(), listOfPersons.getSecondEmployee().getSurname(),
                listOfPersons.getSecondEmployee().getCompany(), listOfPersons.getSecondEmployee().getSalary());

        StudentPerClass studentPerClass = new StudentPerClass(listOfPersons.getStudent().getAge(),
                listOfPersons.getStudent().getName(), listOfPersons.getStudent().getSurname(),
                listOfPersons.getStudent().getFaculty(), listOfPersons.getStudent().getMark());

        session.save(firstPersonPerClass);
        session.save(secondPersonPerClass);
        session.save(firstEmployeePerClass);
        session.save(secondEmployeePerClass);
        session.save(studentPerClass);
        session.getTransaction().commit();
        session.close();
    }
}

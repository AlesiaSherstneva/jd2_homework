package by.academy.it.loader;

import by.academy.it.persons.ListOfPersons;
import by.academy.it.pojos.single.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataLoaderSingle implements DataLoader {

    ListOfPersons listOfPersons = new ListOfPersons();

    public void loadData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        PersonSingle firstPersonSingle = new PersonSingle(listOfPersons.getFirstPerson().getAge(),
                listOfPersons.getFirstPerson().getName(), listOfPersons.getFirstPerson().getSurname());
        PersonSingle secondPersonSingle = new PersonSingle(listOfPersons.getSecondPerson().getAge(),
                listOfPersons.getSecondPerson().getName(), listOfPersons.getSecondPerson().getSurname());

        EmployeeSingle firstEmployeeSingle = new EmployeeSingle(listOfPersons.getFirstEmployee().getAge(),
                listOfPersons.getFirstEmployee().getName(), listOfPersons.getFirstEmployee().getSurname(),
                listOfPersons.getFirstEmployee().getCompany(), listOfPersons.getFirstEmployee().getSalary());
        EmployeeSingle secondEmployeeSingle = new EmployeeSingle(listOfPersons.getSecondEmployee().getAge(),
                listOfPersons.getSecondEmployee().getName(), listOfPersons.getSecondEmployee().getSurname(),
                listOfPersons.getSecondEmployee().getCompany(), listOfPersons.getSecondEmployee().getSalary());

        StudentSingle studentSingle = new StudentSingle(listOfPersons.getStudent().getAge(),
                listOfPersons.getStudent().getName(), listOfPersons.getStudent().getSurname(),
                listOfPersons.getStudent().getFaculty(), listOfPersons.getStudent().getMark());

        session.save(firstPersonSingle);
        session.save(secondPersonSingle);
        session.save(firstEmployeeSingle);
        session.save(secondEmployeeSingle);
        session.save(studentSingle);
        session.getTransaction().commit();
        session.close();
    }
}

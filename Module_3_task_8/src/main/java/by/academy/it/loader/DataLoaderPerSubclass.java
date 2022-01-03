package by.academy.it.loader;

import by.academy.it.persons.ListOfPersons;
import by.academy.it.pojos.persubclass.EmployeePerSubclass;
import by.academy.it.pojos.persubclass.PersonPerSubclass;
import by.academy.it.pojos.persubclass.StudentPerSubclass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DataLoaderPerSubclass implements DataLoader {

    ListOfPersons listOfPersons = new ListOfPersons();

    public void loadData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        PersonPerSubclass firstPersonPerSubclass = new PersonPerSubclass(listOfPersons.getFirstPerson().getAge(),
                listOfPersons.getFirstPerson().getName(), listOfPersons.getFirstPerson().getSurname());
        PersonPerSubclass secondPersonPerSubclass = new PersonPerSubclass(listOfPersons.getSecondPerson().getAge(),
                listOfPersons.getSecondPerson().getName(), listOfPersons.getSecondPerson().getSurname());

        EmployeePerSubclass firstEmployeePerSubclass = new EmployeePerSubclass(listOfPersons.getFirstEmployee().getAge(),
                listOfPersons.getFirstEmployee().getName(), listOfPersons.getFirstEmployee().getSurname(),
                listOfPersons.getFirstEmployee().getCompany(), listOfPersons.getFirstEmployee().getSalary());
        EmployeePerSubclass secondEmployeePerSubclass = new EmployeePerSubclass(listOfPersons.getSecondEmployee().getAge(),
                listOfPersons.getSecondEmployee().getName(), listOfPersons.getSecondEmployee().getSurname(),
                listOfPersons.getSecondEmployee().getCompany(), listOfPersons.getSecondEmployee().getSalary());

        StudentPerSubclass studentPerSubclass = new StudentPerSubclass(listOfPersons.getStudent().getAge(),
                listOfPersons.getStudent().getName(), listOfPersons.getStudent().getSurname(),
                listOfPersons.getStudent().getFaculty(), listOfPersons.getStudent().getMark());

        session.save(firstPersonPerSubclass);
        session.save(secondPersonPerSubclass);
        session.save(firstEmployeePerSubclass);
        session.save(secondEmployeePerSubclass);
        session.save(studentPerSubclass);
        session.getTransaction().commit();
        session.close();
    }
}

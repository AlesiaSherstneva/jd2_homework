package by.academy.it.main;

import by.academy.it.loader.DataLoaderPerClass;
import by.academy.it.loader.DataLoaderPerSubclass;
import by.academy.it.loader.DataLoaderSingle;
import by.academy.it.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        DataLoaderSingle dataLoaderSingle = new DataLoaderSingle();
        dataLoaderSingle.loadData(sessionFactory);

        DataLoaderPerSubclass dataLoaderPerSubclass = new DataLoaderPerSubclass();
        dataLoaderPerSubclass.loadData(sessionFactory);

        DataLoaderPerClass dataLoaderPerClass = new DataLoaderPerClass();
        dataLoaderPerClass.loadData(sessionFactory);
    }
}

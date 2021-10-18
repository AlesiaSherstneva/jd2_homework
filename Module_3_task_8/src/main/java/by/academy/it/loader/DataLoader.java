package by.academy.it.loader;

import org.hibernate.SessionFactory;

public interface DataLoader {
    void loadData(SessionFactory sessionFactory);
}

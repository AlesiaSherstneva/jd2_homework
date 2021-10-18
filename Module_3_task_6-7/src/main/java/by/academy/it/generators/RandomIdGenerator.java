package by.academy.it.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.Random;

public class RandomIdGenerator implements IdentifierGenerator {
    private final Random random = new Random();

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object o) throws HibernateException {
        return Math.abs(random.nextLong());
    }
}
package by.academy.it;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao {
    Receiver getReceiver(int id);
    ArrayList<Receiver> getReceivers ();
    Expense getExpense (int id);
    ArrayList<Expense> getExpenses();
    int addReceiver (Receiver receiver);
    int addExpense (Expense expense);

    /* этого метода не было в заданном интерфейсе, я добавила его сама, чтобы иметь возможность после
    всей работы в методе main закрыть статический Connection */
    Connection getConnection();
}

package by.academy.it;

import java.util.ArrayList;

public interface Dao {
    Receiver getReceiver(int id);
    ArrayList<Receiver> getReceivers ();
    Expense getExpense (int id);
    ArrayList<Expense> getExpenses();
    int addReceiver (Receiver receiver);
    int addExpense (Expense expense);
}

package by.academy.it;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBWithDAO {

    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        Receiver receiver = new Receiver();
        Expense expense = new Expense();

        System.out.println("\nAdding new strings in tables:");
        receiver.setName("A1");
        System.out.println(dao.addReceiver(receiver) + " rows added");
        expense.setPaydate("2021-10-28");
        expense.setReceiver(5);
        expense.setValue(new BigDecimal("22.49"));
        System.out.println(dao.addExpense(expense) + " rows added");

        System.out.println("Getting one string from tables:");
        expense = dao.getExpense(1);
        System.out.println(expense.getPaydate() + " " + expense.getReceiver() + " " + expense.getValue());
        receiver = dao.getReceiver(2);
        System.out.println(receiver.getName());

        System.out.println("\nGetting all the strings from tables:");
        ArrayList<Expense> expenses = dao.getExpenses();
        for (Expense gottenExpense : expenses) {
            System.out.println(gottenExpense.getPaydate() + " "
                    + gottenExpense.getReceiver() + " "
                    + gottenExpense.getValue());
        }
        System.out.println();
        ArrayList<Receiver> receivers = dao.getReceivers();
        for (Receiver gottenReceiver : receivers) {
            System.out.println(gottenReceiver.getName());
        }

        try {
            dao.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

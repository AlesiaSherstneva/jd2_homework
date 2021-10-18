package by.academy.it;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DBWithDAO {

    public static void main(String[] args) {

        ExpRecDao dao = new ExpRecDao();

        System.out.println("Getting one string from tables:");
        Expense expense = dao.getExpense(7);
        System.out.println(expense.getPaydate() + " " + expense.getReceiver() + " " + expense.getValue());
        Receiver receiver = dao.getReceiver(2);
        System.out.println(receiver.getName());


        System.out.println("\nAdding new strings in tables:");
        Receiver receiver1 = new Receiver();
        receiver1.setName("A1");
        System.out.println(dao.addReceiver(receiver1) + " rows added");
        Expense expense1 = new Expense();
        expense1.setPaydate("2021-10-28");
        expense1.setReceiver(5);
        expense1.setValue(new BigDecimal("22.49"));
        System.out.println(dao.addExpense(expense1) + " rows added");


        System.out.println("\nReceiving all the strings from tables:");
        ArrayList<Expense> expenses = dao.getExpenses();
        for (Expense expense2 : expenses) {
            System.out.println(expense2.getPaydate() + " " + expense2.getReceiver() + " " + expense2.getValue());
        }
        System.out.println();
        ArrayList<Receiver> receivers = dao.getReceivers();
        for (Receiver receiver2 : receivers) {
            System.out.println(receiver2.getName());
        }
    }
}

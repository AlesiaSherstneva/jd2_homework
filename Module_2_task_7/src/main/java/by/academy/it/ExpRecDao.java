package by.academy.it;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ExpRecDao implements Dao {
    @Override
    public Receiver getReceiver(int id) {
        Receiver receiver = new Receiver();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM receivers where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                receiver.setName(resultSet.getString("name"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() {
        ArrayList<Receiver> receivers = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            String query = "SELECT id FROM receivers";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM receivers where id = ?");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                preparedStatement.setInt(1, id);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                while (resultSet1.next()) {
                    String name = resultSet1.getString("name");
                    receivers.add(new Receiver(name));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    @Override
    public Expense getExpense(int id) {
        Expense expense = new Expense();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT paydate, receiver, value FROM expenses where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expense.setPaydate(resultSet.getString("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getBigDecimal("value"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            String query = "SELECT id FROM expenses";
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT paydate, receiver, value FROM expenses where id = ?");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                preparedStatement.setInt(1, id);
                ResultSet resultSet1 = preparedStatement.executeQuery();
                while (resultSet1.next()) {
                    String paydate = resultSet1.getString("paydate");
                    int receiver = resultSet1.getInt("receiver");
                    BigDecimal value = resultSet1.getBigDecimal("value");
                    expenses.add(new Expense(paydate, receiver, value));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO receivers (name) VALUES ('" + receiver.getName() + "')";
            result = statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addExpense(Expense expense) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO expenses (paydate, receiver, value) VALUES ('"
                    + expense.getPaydate() + "', "
                    + expense.getReceiver() + ", "
                    + expense.getValue() + ")";
            result = statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

package by.academy.it;

import java.sql.*;

public class DBSelect {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            Statement statement = connection.createStatement();
            String query = "SELECT r.name, SUM(e.value) FROM expenses AS e " +
                    "JOIN receivers as r ON e.receiver = r.id " +
                    "GROUP BY r.name";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
            }
            System.out.println();
            query = "SELECT paydate, SUM(value) FROM expenses WHERE paydate = ( " +
                    "SELECT paydate FROM expenses WHERE value = (" +
                    "SELECT MAX(value) FROM expenses))";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
            }
            System.out.println();
            query = "SELECT paydate, MAX(value) FROM expenses WHERE paydate = " +
                    "(SELECT paydate FROM expenses GROUP BY paydate " +
                    "ORDER BY SUM(value) DESC LIMIT 1)";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
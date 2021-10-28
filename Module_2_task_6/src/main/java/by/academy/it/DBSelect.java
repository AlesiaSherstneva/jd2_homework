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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/it-academy", "root", "root");
            Statement statement = connection.createStatement();
            String query = "SELECT name, SUM(value) FROM expenses, receivers WHERE receiver=receivers.id GROUP BY name";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
            }
            System.out.println();
            query = "SELECT paydate, SUM(value) FROM expenses \n" +
                    "WHERE paydate = (select paydate from expenses\n" +
                    "WHERE value = (SELECT MAX(value) FROM expenses))";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
            }
            System.out.println();
            query = "SELECT MAX(value), paydate FROM expenses \n" +
                    "WHERE paydate = (select paydate from expenses\n" +
                    "WHERE value = (SELECT MAX(value) FROM expenses))";
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

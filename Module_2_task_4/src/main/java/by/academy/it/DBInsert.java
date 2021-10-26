package by.academy.it;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class DBInsert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of the payment (yyyy-mm-dd):");
        while (!scanner.hasNext("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            System.out.println("It's wrong date! Enter correct date:");
            scanner.nextLine();
        }
        String paydate = scanner.nextLine();
        int receiver;
        do {
            System.out.println("Enter the number of the receiver (1-4):");
            while (!scanner.hasNextInt()) {
                System.out.println("It's not a number! Enter correct number:");
                scanner.next();
            }
            receiver = scanner.nextInt();
        } while (receiver < 1 || receiver > 4);
        BigDecimal value;
        do {
            System.out.println("Enter the summary of the payment:");
            while (!scanner.hasNextDouble()) {
                System.out.println("It's not a summary! Enter correct summary:");
                scanner.next();
            }
            value = BigDecimal.valueOf(scanner.nextDouble());
        } while (value.signum() < 0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/it-academy", "root", "root");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO expenses (paydate, receiver, value) VALUES ('" +
                    paydate + "', " +
                    receiver + ", " +
                    value + ")";
            statement.executeUpdate(query);
            query = "SELECT paydate, value, name FROM expenses, receivers WHERE receiver=receivers.id";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("paydate") + " "
                        + resultSet.getString("value") + " "
                        + resultSet.getString("name"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

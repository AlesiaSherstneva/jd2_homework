package by.academy.it;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class DBInsert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of the payment (yyyy-mm-dd):");
        String paydate = "";
        boolean isCorrectDate = false;
        while (!isCorrectDate) {
            while (!scanner.hasNext("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
                System.out.println("It's not a date! Enter correct date:");
                scanner.nextLine();
            }
            paydate = scanner.nextLine();
            int year = Integer.parseInt(paydate.substring(0, 4));
            int month = Integer.parseInt(paydate.substring(5, 7));
            int dayOfMonth = Integer.parseInt(paydate.substring(8));
            if (year < 2016 || year > 2021) {
                System.out.println("There is wrong year in date!");
            } else if (month < 1 || month > 12) {
                System.out.println("There is wrong month in date!");
            } else if (dayOfMonth < 1 || dayOfMonth > 31) {
                System.out.println("There is wrong day of month in date!");
            } else if ((year % 4 == 0 && month == 2 && dayOfMonth > 29)
                    || (year % 4 != 0 && month == 2 && dayOfMonth > 28)
                    || (((month == 3 || month == 6 || month == 9 || month == 11) && dayOfMonth > 30))) {
                System.out.println("There are wrong month and day of month in date!");
            } else {
                isCorrectDate = true;
            }
        }
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO expenses (paydate, receiver, value) VALUES ('" +
                    paydate + "', " +
                    receiver + ", " +
                    value + ")";
            statement.executeUpdate(query);
            query = "SELECT e.paydate, e.value, r.name FROM expenses AS e " +
                    "JOIN receivers as r on e.receiver=r.id";
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

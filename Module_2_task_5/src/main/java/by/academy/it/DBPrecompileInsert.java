package by.academy.it;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DBPrecompileInsert {
    static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ListExpenses", "root", "root");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String paydate = "";
        int receiver;
        BigDecimal value;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of the payment (yyyy-mm-dd):");
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
            if (year < LocalDateTime.now().getYear() - 100 || year > LocalDateTime.now().getYear()) {
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
        do {
            System.out.println("Enter the number of the receiver (1-4):");
            while (!scanner.hasNextInt()) {
                System.out.println("It's not a number! Enter correct number:");
                scanner.next();
            }
            receiver = scanner.nextInt();
        } while (receiver < 1 || receiver > 4);
        do {
            System.out.println("Enter the summary of the payment:");
            while (!scanner.hasNextDouble()) {
                System.out.println("It's not a summary! Enter correct summary:");
                scanner.next();
            }
            value = BigDecimal.valueOf(scanner.nextDouble());
        } while (value.signum() < 0 || value.compareTo(new BigDecimal("9999999.99")) > 0);

        try {
            String template = "INSERT INTO expenses (paydate, receiver, value) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(template);
            preparedStatement.setString(1, paydate);
            preparedStatement.setInt(2, receiver);
            preparedStatement.setBigDecimal(3, value);
            preparedStatement.executeUpdate();
            template = "SELECT e.paydate, e.value, r.name FROM expenses AS e " +
                    "JOIN receivers as r ON e.receiver = r.id";
            ResultSet resultSet = preparedStatement.executeQuery(template);
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

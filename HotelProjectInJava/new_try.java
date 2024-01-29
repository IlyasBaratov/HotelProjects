package Final_project;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class new_try {
    public client_account client = new client_account();
    public client_account app = new client_account();
    public static final String CONNECTION_DB = "my_account.db";
    public static final String CONNECTION_NAME = "jdbc:sqlite:C:\\Users\\user\\Desktop\\Hotel_Flight_project\\src\\Final_project\\"+CONNECTION_DB;

    public double previous;

    public void my_acc_proccess(String first_name, String last_name, String date, double deposit,
                                double expenses, double total) {
        try {

            Connection conn = DriverManager.getConnection(CONNECTION_NAME);
            Statement statement = conn.createStatement();
            //statement.execute("DROP TABLE IF EXISTS my_account");


            statement.execute("CREATE TABLE  IF NOT EXISTS my_account ( " +
                    "first_name TEXT, " +
                    "last_name TEXT, " +
                    "date TEXT, " +
                    "deposit DOUBLE, " +
                    "expenses DOUBLE, " +
                    "total DOUBLE )");
            statement.execute("INSERT INTO my_account (first_name, last_name, date, deposit, expenses, total) " +
                    "VALUES ('" + first_name + "', '" + last_name + "', '" + date + "', " +
                    deposit + ", " + expenses + ", " + total + ")");
            conn.close();
            statement.close();
            System.out.println("Data saved successfully!");
        } catch (SQLException e) {
            System.out.println("ERROR! " + e.getMessage());
            e.printStackTrace();
        }
        client = new client_account(date,deposit,expenses,total);
    }

    public void getting_data() {
        client.last_data();
        previous = client.getTotal();
        Scanner input = new Scanner(System.in);
        System.out.print("your deposit amount: ");
        double deposit = input.nextDouble();
        System.out.print("Your expenses: ");
        double expenses = input.nextDouble();
        app.setDeposit(deposit);
        app.setExpenses(expenses);
        double total = previous + deposit - expenses;
        client.setTotal(total);
        String first_name = "Ilyas";
        String last_name = "Baratov";
        LocalDate current_date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
        String date_final = current_date.format(formatter);
        String date = get_date(date_final);
        my_acc_proccess(first_name,last_name,date,deposit,expenses,total);

    }
    public String get_date(String date) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("01", "Jan,");
        dictionary.put("02", "Feb,");
        dictionary.put("03", "March,");
        dictionary.put("04", "Apr,");
        dictionary.put("05", "May,");
        dictionary.put("06", "Jun,");
        dictionary.put("07", "Jul,");
        dictionary.put("08", "Aug,");
        dictionary.put("09", "Sep,");
        dictionary.put("10", "Oct,");
        dictionary.put("11", "Nov,");
        dictionary.put("12", "Dec,");
        String month = date.substring(0, 2);
        String day = date.substring(3, 5);
        String year = date.substring(6, 10);
        return (dictionary.get(month) + day + "," + year);
    }
}

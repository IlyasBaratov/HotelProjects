package Final_project;


import java.sql.*;

public class client_account {
    public static final String DB_NAME = "my_account.db";
    public static final String CONNECTION_PATH = "jdbc:sqlite:C:\\Users\\user\\Desktop\\Hotel_Flight_project\\src\\Final_project\\"+DB_NAME;
    public client_account(){}
    public client_account(String date, double deposit, double expenses, double total) {
        this.date = date;
        this.deposit = deposit;
        this.expenses = expenses;
        this.total = total;
    }

    private String date;
    private double deposit;
    private double expenses;
    private double total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void last_data (){
        try {
            double storing =0;
            Connection conn = DriverManager.getConnection(CONNECTION_PATH);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from my_account");
            while (result.next()){
                storing = result.getDouble("total");
            }
            setTotal(storing);
        }catch (SQLException e){
            System.out.println("ERROR! "+e.getMessage());
            e.printStackTrace();
        }
    }
}
package Final_project;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class hotel_system {
    fun chosen_element;
    int guest_amount;
    public new_try new_try = new new_try();
    public int chosen_id;
    public client_account client  = new client_account();
    public Scanner input = new Scanner(System.in);
    public List<Integer> ID = new ArrayList<>();
    public List<String> city = new ArrayList<>();
    public List<String> country = new ArrayList<>();
    public List<String> hotel_name = new ArrayList<>();
    public List<Integer> available_rooms = new ArrayList<>();
    public List<Double> price_per_night = new ArrayList<>();
    //public fun storing = new fun();
    public List<fun> final_version = new ArrayList<>();
    public static final String CONTTECTION_DB = "final_versionfinal_sequal.db";

    public static final String CONNECTION_STRING = ("jdbc:sqlite:C:\\Users\\user\\Desktop\\hotel_file-main\\hotel_file-main\\"+CONTTECTION_DB);
    public void hotel_read_datas(String decision){
        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM hotel");
            while (result.next()){
                ID.add(result.getInt("ID_number"));
                city.add(result.getString("city"));
                country.add(result.getString("country"));
                hotel_name.add(result.getString("hotel_name"));
                available_rooms.add(result.getInt("available_rooms"));
                price_per_night.add(result.getDouble("price_per_night"));
            }
        } catch (SQLException e){
            System.out.println("ERROR! "+e.getMessage());
            e.printStackTrace();
        }
        int index_of_decision=0;
//        System.out.print("Would you like to search by city or id? ");
//        String decision = input.next();
        if(decision.equals("city")){
            System.out.print("enter the name of the city! ");
            String city_decision = input.next().toUpperCase();
            int numbering =1;
            for (int n = 0; n < 5; n++) {
                if(city.get(n).equals(city_decision)){
                    System.out.print((numbering)+") ");
                    copying(n);
                    fun storing = new fun(ID.get(n),city.get(n),country.get(n),hotel_name.get(n),available_rooms.get(n),price_per_night.get(n));
                    final_version.add(storing);
                    numbering++;
                }
            }
        }
        else if (decision.equals("id")){
            System.out.print("enter the id number! ");
            int id_decision = input.nextInt();
            for (int n = 0; n < 5; n++) {
                if(ID.get(n)==id_decision){
                    copying(n);
                    fun storing = new fun(ID.get(n),city.get(n),country.get(n),hotel_name.get(n),available_rooms.get(n),price_per_night.get(n));
                    final_version.add(storing);
                }
            }
        }
    }
    public void reserving(int number){
        // System.out.println(final_version.get(number).toString());
        System.out.print("How many people? ");
        chosen_element = final_version.get(number);
        int available_rooms_amount = chosen_element.getAvailable_rooms();
        double money = chosen_element.getPrice();
        chosen_id = chosen_element.getId();

        guest_amount = input.nextInt();
        if (guest_amount<available_rooms_amount){
            double a = guest_amount*money;
            client.setExpenses(a);

        }

        System.out.println("Total will be "+client.getExpenses());
    }

    public void adjusting_data() {
        try {


            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            int a = (chosen_element.getAvailable_rooms()-guest_amount);
            if(a<0){
                System.out.println("no available rooms ");
                System.exit(123);
            }
            statement.execute("UPDATE hotel SET available_rooms = "+a+" WHERE ID_number = "+chosen_id);
            conn.close();
            statement.close();
        }catch (SQLException e) {
                System.out.println("ERROR! " + e.getMessage());
                e.printStackTrace();
        }

    }
    public void getting_money_from_client(){
        double expenses = client.getExpenses();
        client_account client = new client_account();
        client.last_data();
        double old_total = client.getTotal();
        //System.out.println(a);
        LocalDate current_date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
        String date_final = current_date.format(formatter);
        String date = get_date(date_final);
        if (old_total<expenses) {
            System.out.println("Insufficient funds! ");
            return;
        }
        else if (old_total>expenses){

            double new_total = old_total - expenses;
            client.setTotal(new_total);

            //client_account client2 = new client_account(date,0,expenses,client.getTotal());
            new_try.my_acc_proccess("Ilyas","Baratov",date,0,expenses,client.getTotal());
        }

        System.out.println("Your reservation is complete! ");
        System.out.println("Your reservation date is "+date);
        System.out.println("Your reservation amount is "+expenses);
        System.out.println("Your remaining balance is "+client.getTotal());
        System.out.println("Thank you for choosing us! ");
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
    public void copying (int number){
        System.out.println("ID number = "+ID.get(number)+"    name = "+hotel_name.get(number)+"    Available rooms = "+ available_rooms.get(number)+
                "    price = $"+price_per_night.get(number));
    }
}

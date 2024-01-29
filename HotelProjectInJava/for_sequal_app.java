package Final_project;

import java.sql.*;

public class for_sequal_app {
    public final String DB_NAME = "final_sequal.db";

    public final String CONNECTION_STRING =
            "jdbc:sqlite:C:\\Users\\user\\Desktop\\Hotel_Flight_project\\src\\Final_project\\final_version"+
                    DB_NAME;

    public final String TABLE_HOTEL = "hotel";
    public final String COLUMN_HOTEL_ID_NUMBER = "ID_number";
    public final String COLUMN_HOTEL_CITY = "city";
    public final String COLUMN_HOTEL_COUNTRY = "country";
    public final String COLUMN_HOTEL_HOTEL_NAME = "hotel_name";
    public final String COLUMN_HOTEL_AVAILABLE_ROOMS = "available_rooms";
    public final String COLUMN_HOTEL_PRICE = "price_per_night";

    public void insert_hotels(int ID_number, String city, String country,
                                     String hotel_name, int available_rooms, double price) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            // statement.execute("DROP TABLE IF EXISTS "+TABLE_HOTEL);
            statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_HOTEL+
                    "("+COLUMN_HOTEL_ID_NUMBER +" INTEGER, "+
                        COLUMN_HOTEL_CITY+" text, "+
                        COLUMN_HOTEL_COUNTRY+" text, "+
                        COLUMN_HOTEL_HOTEL_NAME+" text, "+
                        COLUMN_HOTEL_AVAILABLE_ROOMS+" INTEGER, "+
                        COLUMN_HOTEL_PRICE+" DOUBLE "+" )");
            statement.execute("INSERT INTO "+
                    TABLE_HOTEL+" ( "+
                COLUMN_HOTEL_ID_NUMBER+", "+
                COLUMN_HOTEL_CITY+", "+
                COLUMN_HOTEL_COUNTRY+", "+
                COLUMN_HOTEL_HOTEL_NAME+", "+
                COLUMN_HOTEL_AVAILABLE_ROOMS+", "+
                COLUMN_HOTEL_PRICE+" )"+
                "VALUES ("+ID_number+", '"+city+"', '"+country+"', '"+hotel_name+"', "+available_rooms+
                ", "+price+")");
        }catch (SQLException e){
            System.out.println("ERROR! "+e.getMessage());
            e.printStackTrace();
        }
    }
}

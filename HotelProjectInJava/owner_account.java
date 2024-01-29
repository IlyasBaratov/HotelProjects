package Final_project;

public class owner_account {
    public owner_account(){}

    private int ID_number;
    private String city;
    private String country;
    private String hotel_name;
    private int aviable_rooms;
    private double price_per_day;

    public int getID_number() {
        return ID_number;
    }

    public void setID_number(int ID_number) {
        this.ID_number = ID_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getAviable_rooms() {
        return aviable_rooms;
    }

    public void setAviable_rooms(int aviable_rooms) {
        this.aviable_rooms = aviable_rooms;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(double price_per_day) {
        this.price_per_day = price_per_day;
    }
}

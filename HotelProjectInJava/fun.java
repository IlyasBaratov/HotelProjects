package Final_project;

public class fun {
    private int id;
    private String city;
    private String country;
    private String hotel_name;
    private int available_rooms;
    private double price;
    public fun(){}

    public fun(int id, String city, String country, String hotel_name, int available_rooms, double price) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.hotel_name = hotel_name;
        this.available_rooms = available_rooms;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id = "+id+"    "+"hotel name = "+hotel_name+"    "+"available rooms = "+available_rooms+ "    "+ "price = "+price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAvailable_rooms() {
        return available_rooms;
    }

    public void setAvailable_rooms(int available_rooms) {
        this.available_rooms = available_rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

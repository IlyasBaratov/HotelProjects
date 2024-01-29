package Final_project;

import java.util.Scanner;
import  java.util.Random;

public class owner_system {
    public for_sequal_app sequal_app = new for_sequal_app();
    public owner_account owner = new owner_account();
    public Scanner input = new Scanner(System.in);
    public void Random_ID(){
        Random random = new Random();
        int chosen_num = random.nextInt(1000,9999);
        owner.setID_number(chosen_num);
    }
    public void hotel_owner () {
        try {
            System.out.print("Name of the hotel? ");
            String name = input.nextLine().toUpperCase();
            owner.setHotel_name(name);
            System.out.print("Name of the city? ");
            String city = input.next().toUpperCase();
            owner.setCity(city);
            System.out.print("Country? ");
            String country = input.next().toUpperCase();
            owner.setCountry(country);
            System.out.print("Aviable places? ");
            int places = input.nextInt();
            owner.setAviable_rooms(places);
            System.out.print("Prices? ");
            double price = input.nextDouble();
            owner.setPrice_per_day(price);
            //String done =(Random_ID()+","+city+","+country+","+name+","+places+","+price);
//            writer.append(owner.getID_number() + "," + owner.getCity() + "," + owner.getCountry() + "," +
//                    owner.getHotel_name() + "," + owner.getAviable_rooms() + "," + owner.getPrice_per_day());
//            writer.newLine();
            sequal_app.insert_hotels(owner.getID_number(),owner.getCity(),owner.getCountry(),owner.getHotel_name(),
                    owner.getAviable_rooms(),owner.getPrice_per_day());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

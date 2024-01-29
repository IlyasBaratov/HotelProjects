package Final_project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        hotel_system app = new hotel_system();
        System.out.print("If you are a client press \"1\"\nIf you are an owner press\"2\" \n    ");
        int client_or_owner = input.nextInt();
        if (client_or_owner == 2) {
            owner_system owner = new owner_system();
            owner.hotel_owner();
        }
        else if (client_or_owner == 1) {

            //app.reserving((0));
            //app.adjusting_data();
            System.out.print("Would you like to search by city or id? ");
            String decision = input.next();
            if(decision.equals("id")){
                app.hotel_read_datas("id");
//                System.out.print("enter the id number! ");
//                int id_decision = input.nextInt();
                app.reserving(0);
            } else if (decision.equals("city")) {
                app.hotel_read_datas("city");
                System.out.print("which one do you want to choose? ");
                int number = input.nextInt();
                app.reserving((number - 1));
            }
            app.getting_money_from_client();
            app.adjusting_data();
                //app.getting_money_from_another_acc();
        }
        }
}

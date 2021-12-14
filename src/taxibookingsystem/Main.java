/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxibookingsystem;

import java.util.Scanner;

/**
 *
 * @author vinee
 */
public class Main {
       public static void main(String[] args) {
        TaxiBookingSystem TaxiBookingSystem = new TaxiBookingSystem(); // try to apply singleton class
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.println("-----------------------TAXI-BOOKING-SYSTEM------------------------");
            System.out.println("1. Book taxi");
            System.out.println("2. Add new taxi");
            System.out.println("3. Display Taxi Bookings");
            System.out.println("4. Exit");
            System.out.println("-------------------------------------------------------------------");
            choice = scan.nextInt();
            menu(choice,scan,TaxiBookingSystem);
            if(choice<1 || choice>4){
                System.out.println("Please enter a valid input!");
            }
        }while(true);

    }
    private static void menu(int choice,Scanner scan, TaxiBookingSystem TaxiBookingSystem){
        switch(choice){
            case 1:
                TaxiBookingSystem.allocateTaxi(scan);
                break;
            case 2:
                TaxiBookingSystem.addNewTaxiToList(scan);
                break;
            case 3:
                 TaxiBookingSystem.displayTaxiBookings();
                 break;
            case 4:
                System.exit(0);
        }
    }
}

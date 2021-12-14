/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxibookingsystem;

import java.util.*;

/**
 *
 * @author vinee
 */
public class TaxiBookingSystem {
//    private static TaxiBookingSystem TaxiBookingSystem = null; // apply singleton
    private ArrayList<Taxi> taxis;
    public TaxiBookingSystem(){
        taxis = new ArrayList<>();
    }
    public void allocateTaxi(Scanner scan){
        Customer newCustomer = createCustomer();
        Booking booking = getBookingDetails(scan);
        booking.setCustomer(newCustomer);
        Taxi freeTaxi = findFreeTaxi(booking);
        if(freeTaxi==null){
            System.out.println("Sorry, We do not have a free taxi to provide at the given time");
            return;
        }
        System.out.println("Your Customer ID: "+newCustomer.getCustomerID());
        System.out.println("Your alloted Taxi's ID: "+freeTaxi.getTaxiID());
        System.out.printf("%d is the total charges for the travel\n",booking.computeAmount());
        int taxiUpdatedEarnings = freeTaxi.getTotalearnings()+booking.computeAmount();
        freeTaxi.setTotalearnings(taxiUpdatedEarnings);
        
    }
    public void addNewTaxiToList(Scanner scan){
        Taxi newTaxi = createTaxi(scan);
        taxis.add(newTaxi);
        System.out.printf("New Taxi with ID : %d and name : %s is successfully created!\n",newTaxi.getTaxiID(),newTaxi.getTaxiName());
        System.out.println("----------------------------------------------------------");
    }
    private Taxi createTaxi(Scanner scan){
        System.out.println("--------------------Enter-Taxi-Details--------------------");
        System.out.print("Enter Taxi Name : ");
        Taxi newTaxi = new Taxi();
        String taxiName = scan.next();
        newTaxi.setTaxiName(taxiName);
        return newTaxi;
    }
    private Customer createCustomer(){
        Customer newCustomer = new Customer();
        return newCustomer;
    }
    private Taxi findFreeTaxi(Booking booking){
        Taxi allotedTaxi=null;
        for(int i=0;i<taxis.size();i++){
            if(taxis.get(i).isFree(booking)){
                if(allotedTaxi==null){
                    allotedTaxi=taxis.get(i);
                }
                else{
                    if(taxis.get(i).getLocationAtTime(booking)==-1) {
                        continue;
                    }
                    
                    int newdistance = Math.abs(taxis.get(i).getLocationAtTime(booking)-booking.getPickUpPoint());
                    int allotedTaxisDistance = Math.abs(allotedTaxi.getLocationAtTime(booking)-booking.getPickUpPoint());
                    if(newdistance<allotedTaxisDistance){
                        allotedTaxi = taxis.get(i);
                    }
                    else if(newdistance==allotedTaxisDistance){
                        int totalEarningsAllotedTaxi = allotedTaxi.getTotalearnings();
                        int totalEarningsCurrentTaxi = taxis.get(i).getTotalearnings();
                        if(totalEarningsAllotedTaxi>totalEarningsCurrentTaxi){
                            allotedTaxi=taxis.get(i);
                        }
                    }
                }
            }
        }
        if(allotedTaxi!=null)
            allotedTaxi.getBookings().add(booking);
        return allotedTaxi;
    }
    private Booking getBookingDetails(Scanner scan){
        Booking booking = new Booking();
        System.out.print("Enter pickup time :");
        booking.setPickUpTime(scan.nextInt());
        System.out.println("");
        System.out.print("Enter pickup point (A, B, C, D, E or F) :");
        booking.setPickUpPoint(((String)scan.next()).charAt(0));
        System.out.println("");
        System.out.print("Enter drop point (A, B, C, D, E or F) :");
        booking.setDropPoint(((String)scan.next()).charAt(0));
        return booking;
    }
    public void displayTaxiBookings(){
        for(int i=0;i<taxis.size();i++){
            System.out.printf("Taxi name : %5s, TaxiID : %8d\n",taxis.get(i).getTaxiName(),taxis.get(i).getTaxiID());
             ArrayList<Booking> bookings= taxis.get(i).getBookings();
            for(int j=0;j<bookings.size();j++){
                int customerID =bookings.get(j).getCustomer().getCustomerID();
                char pickUpPoint = bookings.get(j).getPickUpPoint();
                char dropPoint = bookings.get(j).getDropPoint();
                int amount = bookings.get(j).getAmount();
                System.out.printf("Customer ID : %d,PickUp  , Pickup point : %c, Drop point : %c, Amount : %d\n",customerID,pickUpPoint,dropPoint,amount);
            }
            System.out.println("");
            
        }
    }
    
}

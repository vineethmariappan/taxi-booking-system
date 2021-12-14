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
public class Taxi {
    private int taxiID;
    private String taxiName;
    private int Totalearnings=0;
    private ArrayList<Booking> bookings ;

    /**
     * @return the taxiID
     */
    Taxi(){
        Random rand = new Random();
        this.taxiID=rand.nextInt(89999)+100000;
        bookings = new ArrayList<Booking>();
    }
    public int getTaxiID() {
        return taxiID;
    }

    /**
     * @return the Totalearnings
     */
    public int getTotalearnings() {
        return Totalearnings;
    }

    /**
     * @return the currentTicket
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * @return the currentLocation
     */
 

    /**
     * @param taxiID the taxiID to set
     */
    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    /**
     * @return the taxiName
     */
    public String getTaxiName() {
        return taxiName;
    }

    /**
     * @param taxiName the taxiName to set
     */
    public void setTaxiName(String taxiName) {
        this.taxiName = taxiName;
    }

    /**
     * @param Totalearnings the Totalearnings to set
     */
    public void setTotalearnings(int Totalearnings) {
        this.Totalearnings = Totalearnings;
    }

    public boolean isFree(Booking newBooking){
        int newDistance = Math.abs(newBooking.getDropPoint()-newBooking.getPickUpPoint());
        int newDropTime = newBooking.getPickUpTime()+newDistance; // computing drop time from distance between pickup and droptime
        int newPickUpTime = newBooking.getPickUpTime();
        
        for(int i=0;i<bookings.size();i++){
            int distance = Math.abs(bookings.get(i).getDropPoint()-bookings.get(i).getPickUpPoint());
            int dropTime = bookings.get(i).getPickUpTime()+distance;
            int pickupTime = bookings.get(i).getPickUpTime();
            if(newDropTime>pickupTime && newPickUpTime<dropTime){
                // <--------------------> old booking
        // <---------------> new booking
                return false;
            }
        }
        return true;
    }
    public int getLocationAtTime(Booking newBooking){
        if(bookings.size()==0) return 0;
        int newPickUpTime = newBooking.getPickUpTime();
        int newDropTime = newBooking.getPickUpTime()+newBooking.getDistance();
        int location = 0; //location of taxi is initially at 0
        int curTime = 0;
        for(int i=0;i<this.bookings.size();i++){
            int bookingsPickUpTime = bookings.get(i).getPickUpTime();
            int bookingsDropTime = bookingsPickUpTime+bookings.get(i).getDistance();

            if((newDropTime<=bookingsPickUpTime || newPickUpTime>=bookingsDropTime) && bookingsDropTime>=curTime){
                location = bookings.get(i).getDropPoint();
                curTime = bookingsDropTime;
            }
        }
        return location;
    }
    public boolean hasNoBookings(){
        return bookings.size()==0;
    }


}

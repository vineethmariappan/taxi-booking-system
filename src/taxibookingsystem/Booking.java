/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxibookingsystem;

/**
 *
 * @author vinee
 */
public class Booking {
    private int bookingID;
    private Customer customer;
    private Taxi taxi;
    private char pickUpPoint,dropPoint;
    private int pickUpTime;
    private int amount;
    /**
     * @return the bookingID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * @param bookingID the bookingID to set
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the taxi
     */
    public Taxi getTaxi() {
        return taxi;
    }

    /**
     * @param taxi the taxi to set
     */
    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }


    public int getPickUpTime() {
        return pickUpTime;
    }

    /**
     * @param pickUpTime the pickUpTime to set
     */
    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    /**
     * @return the pickUpPoint
     */
    public char getPickUpPoint() {
        return pickUpPoint;
    }

    /**
     * @param pickUpPoint the pickUpPoint to set
     */
    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    /**
     * @return the dropPoint
     */
    public char getDropPoint() {
        return dropPoint;
    }

    /**
     * @param dropPoint the dropPoint to set
     */
    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }
    public int computeAmount(){
        int totalDistance = getDistance()*15; // 15 kms 
        if(totalDistance<=5)
            return 100;
        totalDistance-=5;
        this.amount=(totalDistance*10)+100;
        return (totalDistance*10)+100;
        
    }
    public int getDistance(){
        int pickUpPoint = this.pickUpPoint-'A';
        int dropPoint = this.dropPoint-'A';
        return Math.abs(pickUpPoint-dropPoint);
    }


    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }
}

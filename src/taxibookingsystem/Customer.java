/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxibookingsystem;

import java.util.Random;

/**
 *
 * @author vinee
 *//**
 *
 * @author vinee
 */
public class Customer {
    private int customerID;
    private Booking booking;

    /**
     * @return the customerID
     */
    Customer(){
        Random rand = new Random();
        this.customerID=rand.nextInt(89999)+100000;
    }
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the ticket
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Booking ticket) {
        this.booking = booking;
    }
    
}

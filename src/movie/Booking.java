/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

/**
 *
 * @author lap store
 */
public abstract class Booking {
    private float price; 
    private boolean booked; 
    private int seatNumber; 
    private String Moviename;
  
    public abstract void calprice(float price);
    public abstract void book(float price, int seatnumber, String Moviename, Database d);
    
    
    
    
        
   
}


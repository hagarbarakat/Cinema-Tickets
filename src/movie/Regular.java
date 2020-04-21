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
public class Regular extends Booking{
private float price;
       @Override
    public void calprice(float price) {
     this.price= price;
    }

    @Override
    public void book(float price, int seatnumber, String Moviename, Database d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}

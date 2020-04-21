/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.util.Date;



/**
 *
 * @author lap store
 */
public class MovieThreatre {
    private int NumberOfSeats; 
    private Date Availability;
    private String Type; 

    public MovieThreatre(int NumberOfSeats, Date Availability, String Type) {
        this.NumberOfSeats = NumberOfSeats;
        this.Availability = Availability;
        this.Type = Type;
    }

    public MovieThreatre() {
    }

    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(int NumberOfSeats) {
        this.NumberOfSeats = NumberOfSeats;
    }

    public Date getAvailability() {
        return Availability;
    }

    public void setAvailability(Date Availability) {
        this.Availability = Availability;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    public boolean SearchAvailabileMovie(Date date, MovieClass movie){
   return movie.getAvailability()==date; 
    }
}

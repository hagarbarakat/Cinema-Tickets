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
public class MovieClass {
    private String MovieName;
    private int MovieDuartion; 
    private String MovieType;
    private Date Availability;

    public Date getAvailability() {
        return Availability;
    }

    public void setAvailability(Date Availability) {
        this.Availability = Availability;
    }

    public MovieClass(String MovieName, int MovieDuartion, String MovieType, Date Availability) {
        this.MovieName = MovieName;
        this.MovieDuartion = MovieDuartion;
        this.MovieType = MovieType;
        this.Availability = Availability;
    }

  
    public MovieClass() {
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public int getMovieDuartion() {
        return MovieDuartion;
    }

    public void setMovieDuartion(int MovieDuartion) {
        this.MovieDuartion = MovieDuartion;
    }

    public String getMovieType() {
        return MovieType;
    }

    public void setMovieType(String MovieType) {
        this.MovieType = MovieType;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap store
 */
public class VIP extends Booking {

    private float price;
    private static Connection connection;
    private static Statement st;
    private static ResultSet rs;

    @Override
    public void calprice(float price) {
        this.price = price;
    }

    @Override
    public void book(final float price, final int seatnumber, final String Moviename, final Database d) {
        try {
            connection = d.connect();
        } catch (SQLException ex) {
            Logger.getLogger(VIP.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread thread = new Thread() {
            public void run() {
                String sqlInsert = "insert into booking (moviename,reservationtype , seatnumber, price) values (?,?,?,?);";
                PreparedStatement preparedStmt = null;
                try {
                  
                    preparedStmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                    preparedStmt.setString(1, Moviename);
                    preparedStmt.setInt(2, 1); // 1 for VIP
                    preparedStmt.setInt(3, seatnumber);
                    preparedStmt.setFloat(4, price);
                    preparedStmt.execute();
                    ResultSet tableKeys = preparedStmt.getGeneratedKeys();
                    tableKeys.next();
                    int autoGeneratedID = tableKeys.getInt(1);
//                    menu.setMenuID(autoGeneratedID);
//                    items.add(menu);
                    d.done.set(true);
                    d.success.set(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error");
                    d.done.set(true);
                    d.success.set(false);
                    d.postOperation.set(true);
                }
            }
        };
        thread.start();
    }

}

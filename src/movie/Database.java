/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author lap store
 */
public class Database {
      private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:4000/cinematickets?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String MAX_POOL = "250";
    public AtomicBoolean done = new AtomicBoolean(false);
    public AtomicBoolean success = new AtomicBoolean(true);
    public AtomicBoolean postOperation = new AtomicBoolean(false);
  
    private static Semaphore sem = new Semaphore(1);
    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;
    private  Statement st;
    private  ResultSet rs;

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.put("connectTimeout", "2000");
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() throws SQLException {
        if (connection == null) {
            try {
                
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
                System.out.println("Connected");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                e.getCause();
                System.out.println("ERROR");
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
                done.set(true);
                success.set(false);
            }
        }
        return connection;
    }


    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {

                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

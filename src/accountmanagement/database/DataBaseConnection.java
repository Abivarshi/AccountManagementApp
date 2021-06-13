/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class DataBaseConnection {

    private static Connection con;
    private static String connectedShop;

    private void getConnection(String shopName) throws ClassNotFoundException, SQLException {
        // sqlite driver
        Class.forName("org.sqlite.JDBC");
        // database path, if it's new database, it will be created in the project folder
        con = DriverManager.getConnection("jdbc:sqlite:" + shopName + ".db");
        connectedShop = shopName;
    }

    public ResultSet addUser(String shopName, String username, String password, String role) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            // get connection
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("insert into user values(?,?,?,?);");
        prep.setString(2, username);
        prep.setString(3, password);
        prep.setString(4, role);
        prep.execute();

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("select * from user where username='" + username + "'");
        return res;
    }

    public Boolean getUser(String shopName, String username, String password) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                // get connection
                getConnection(shopName);

            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("select * from user where username='" + username + "'");
            while (res.next()) {
                if (res.getString("password").equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void createUserTable(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            // get connection
            getConnection(shopName);
        }

        // check for database table
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
        if (!res.next()) {
            System.out.println("Building the User table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("create table user(id integer,"
                    + "username varchar(60)," + "password varchar(60)," + "role varchar(60),"
                    + "primary key (id));");

        }
    }
    
    
    public void createShopTable(String shopName) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        // database path, if it's new database, it will be created in the project folder
        con = DriverManager.getConnection("jdbc:sqlite:shop.db");
        connectedShop = "main";

        // check for database table
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='shop'");
        if (!res.next()) {
            System.out.println("Building the Shop table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("create table user(id integer,"
                    + "shopName varchar(60)," + "primary key (id));");

        }
    }
}

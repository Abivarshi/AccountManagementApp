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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class DataBaseConnection {

    private static Connection con;
    private static String connectedShop;

    private void getConnection(String shopName) {
        try {
            // sqlite driver
            Class.forName("org.sqlite.JDBC");
            // database path, if it's new database, it will be created in the project folder
            con = DriverManager.getConnection("jdbc:sqlite:" + shopName + ".db");
            connectedShop = shopName;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createUserTable(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

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

    public ResultSet addUser(String shopName, String username, String password, String role) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
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

    public void createTillTable(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='till'");
        if (!res.next()) {
            System.out.println("Building the Till table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("create table till(id integer,"
                    + "Date varchar(60),"
                    + "primary key (id));");

        }
    }

    public void addItemToTill(String shopName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        System.out.println("Alter the till table..." + shopName + " " + item);

        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE till ADD " + item + " FLOAT NULL;");
            System.out.println("Alter the till table..." + item);

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSetMetaData getTillItems(String shopName) {
        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM till");
            ResultSetMetaData metadata = res.getMetaData();
            return metadata;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void insertTill(String shopName, String date, HashMap<String, Float> till) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        String fun = "INSERT INTO till( date, ";
        String value = "('" + date + "',";
        for (String i : till.keySet()) {
            fun = fun + i + ",";
            value = value + till.get(i) + ",";
        }
        fun = fun.substring(0, fun.length() - 1) + ")" + " VALUES " + value.substring(0, value.length() - 1) + ");";

        PreparedStatement prep;
        try {
            prep = con.prepareStatement(fun);
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet getTill(String shopName, String date) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM till WHERE date='" + date + "'");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void createShop(String shopName) throws ClassNotFoundException, SQLException {
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
            state2.executeUpdate("CREATE TABLE shop(id integer,"
                    + "shopName varchar(60)," + "primary key (id));");

        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO shop VALUES(?,?);");
        prep.setString(2, shopName);
        prep.execute();

        createUserTable(shopName);
        createTillTable(shopName);
    }

    public ResultSet getShopList() {

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:shop.db");
            connectedShop = "main";

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM shop");
            return res;
        } catch (Exception ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

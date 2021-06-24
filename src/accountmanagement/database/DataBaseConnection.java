/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.database;

import java.sql.Connection;
import java.sql.Date;
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

    public Boolean login(String shopName, String username, String password) {

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

    public void createTabDetailTable(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='TabDetail'");
        if (!res.next()) {
            System.out.println("Building the TabDetail table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("CREATE TABLE TabDetail(id integer,"
                    + "TabName varchar(60),"
                    + "primary key (id));");
            
            insertDefaultTabDetail(shopName);

        }
    }

    public void insertTabDetail(String shopName, String tabName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO TabDetail values(?,?);");
        prep.setString(2, tabName);
        prep.execute();
    }

    public void insertDefaultTabDetail(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        createTabTable(shopName, "Till");
        createTabTable(shopName, "Expenditure");
        createTabTable(shopName, "Purchase");
        createTabTable(shopName, "Bank");
        createTabTable(shopName, "Petty");
        createTabTable(shopName, "Staff");
        createTabTable(shopName, "Staff_Time");
        createTabTable(shopName, "Sales");
    }

    public ResultSet getTabDetail(String shopName) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT TabName FROM TabDetail");
            return res;

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void createStaff(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='Staff'");
        if (!res.next()) {
            System.out.println("Building the Staff table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("CREATE TABLE Staff(id integer,"
                    + "StaffName VARCHAR(60),"
                    + "SalaryPercentage FLOAT,"
                    + "Till YESNO,"
                    + "Floor YESNO,"
                    + "CashCarry YESNO,"
                    + "Management YESNO,"
                    + "primary key (id));");
        }
    }
    
    public void insertStaff(String shopName, String staffName, Float salaryPercentage, HashMap<String, Boolean> type) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO Staff values(?,?,?,?,?,?,?);");
        prep.setString(2, staffName);
        prep.setFloat(3, salaryPercentage);
        prep.setBoolean(4, type.get("Till"));
        prep.setBoolean(5, type.get("Floor"));
        prep.setBoolean(6, type.get("CashCarry"));
        prep.setBoolean(7, type.get("Management"));
        prep.execute();
    }

    public ResultSet getStaff(String shopName) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM Staff");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void createStaffTime(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='StaffTime'");
        if (!res.next()) {
            System.out.println("Building the Staff table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("CREATE TABLE StaffTime(id integer,"
                    + "Date DATE"
                    + "StaffName VARCHAR(60),"
                    + "Type VARCHAR(60),"
                    + "StartTime FLOAT,"
                    + "EndTime FLOAT,"
                    + "primary key (id));");
        }
    }
    
    public void insertStaffTime(String shopName, Date date, String staffName, String staffType, Float start, Float end) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO Staff (Date, StaffName, Type, StartTime, EndTime) VALUES ("
                + "'" + date + "', '" + staffName + ", '" + staffType + "', " + start + ", " + end +");");
        prep.execute();
    }
    
    public ResultSet getStaffTime(String shopName, String date) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM StaffTime WHERE Date='" + date + "'");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void createExpenditureDetail(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='ExpenditureDetail'");
        if (!res.next()) {
            System.out.println("Building the ExpenditureDetail table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("CREATE TABLE ExpenditureDetail(id integer,"
                    + "Name varchar(60),"
                    + "primary key (id));");

        }
    }
    
    public void insertExpenditureDetail(String shopName, String name) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO ExpenditureDetail(Name) values('" + name + "');");
        prep.execute();
    }

    public void addItemToExpenditure(String shopName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        System.out.println("Alter the Expenditure table..." + shopName + " " + item);
        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE Expenditure ADD " + item + " FLOAT NULL;");
            insertExpenditureDetail(shopName, item);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getExpenditureDetail(String shopName) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM ExpenditureDetail");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void createPurchaseDetail(String shopName) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='PurchaseDetail'");
        if (!res.next()) {
            System.out.println("Building the PurchaseDetail table...");

            Statement state2 = con.createStatement();
            state2.executeUpdate("CREATE TABLE PurchaseDetail(id integer,"
                    + "Name varchar(60),"
                    + "primary key (id));");

        }
    }
    
    public void insertPurchaseDetail(String shopName, String name) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO PurchaseDetail(Name) values('" + name + "');");
        prep.execute();
    }

    public void addItemToPurchase(String shopName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        System.out.println("Alter the Purschase table..." + shopName + " " + item);
        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE Purchase ADD " + item + " FLOAT NULL;");
            insertPurchaseDetail(shopName, item);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getPurchaseDetail(String shopName) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM PurchaseDetail");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void addItemToBank(String shopName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        try {
            Statement state = con.createStatement();
            if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
            }
            PreparedStatement prep = con.prepareStatement("INSERT INTO Bank values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            prep.setString(2, item);
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTabTable(String shopName, String tabName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        ResultSet res;
        try {
            insertTabDetail(shopName, tabName);

            Statement state = con.createStatement();
            res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='" + tabName + "'");
            if (!res.next()) {
                System.out.println("Building the " + tabName + " table...");

                Statement state2 = con.createStatement();
                state2.executeUpdate("create table " + tabName + "(id integer,"
                        + "Date DATE,"
                        + "primary key (id));");

            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSetMetaData getItems(String shopName, String tabName) {
        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM " + tabName);
            ResultSetMetaData metadata = res.getMetaData();
            return metadata;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void insertItemToTab(String shopName, String tabName,String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        System.out.println("Alter the "+tabName+" table..." + item);

        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE "+tabName+" ADD " + item + " FLOAT NULL;");
            System.out.println("Alter the "+tabName+" table..." + item);

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
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
        createTabDetailTable(shopName);
        createStaff(shopName);
        createStaffTime(shopName);
        createExpenditureDetail(shopName);
        createPurchaseDetail(shopName);
        createTabTable(shopName, "Expenditure");
        createTabTable(shopName, "Purchase");
    }

    public ResultSet getShopList() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:shop.db");
            connectedShop = "main";

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM shop");
            return res;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

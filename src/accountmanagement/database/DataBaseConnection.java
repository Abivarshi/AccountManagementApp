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
        } catch (ClassNotFoundException | SQLException ex) {
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

    public ResultSet addStaff(String shopName, String staffName, float salaryPercentage, Boolean till, Boolean floor, Boolean cashCarry, Boolean management) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("insert into Staff values(?,?,?,?,?,?,?);");
        prep.setString(2, staffName);
        prep.setFloat(3, salaryPercentage);
        prep.setBoolean(4, till);
        prep.setBoolean(5, floor);
        prep.setBoolean(6, cashCarry);
        prep.setBoolean(7, management);
        prep.execute();

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("select * from Staff where staffName='" + staffName + "'");
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
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
                    + "Date DATE,"
                    + "StaffName VARCHAR(60),"
                    + "Type VARCHAR(60),"
                    + "StartTime FLOAT,"
                    + "EndTime FLOAT,"
                    + "primary key (id));");
        }
    }

    public void insertStaffTime(String shopName, String date, String staffName, String staffType, Float start, Float end) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        System.out.println("INSERT INTO StaffTime (Date, StaffName, Type, StartTime, EndTime) VALUES ("
                + "'" + date + "', '" + staffName + ", '" + staffType + "', " + start + ", " + end + ");");
        PreparedStatement prep = con.prepareStatement("INSERT INTO StaffTime (Date, StaffName, Type, StartTime, EndTime) VALUES ("
                + "'" + date + "', '" + staffName + "', '" + staffType + "', " + start + ", " + end + ");");

        prep.execute();
    }
//
//    public ResultSet getStaffTime(String shopName, String dateFrom, String dateTo) {
//
//        try {
//            if (con == null || !connectedShop.equals(shopName)) {
//                getConnection(shopName);
//            }
//
//            Statement state = con.createStatement();
//            ResultSet res = state.executeQuery("SELECT * FROM StaffTime WHERE Date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'");
//            return res;
//        } catch (SQLException ex) {
//            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    public void createTabTable(String shopName, String tabName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        ResultSet res;
        try {
            Statement state = con.createStatement();
            res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='" + tabName + "'");
            if (!res.next()) {
                System.out.println("Building the " + tabName + " table...");

                Statement state2 = con.createStatement();
                state2.executeUpdate("create table " + tabName + "(id integer,"
                        + "Date DATE,"
                        + "primary key (id));");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterTabTable(String shopName, String tabName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE " + tabName + " ADD " + item + " FLOAT NULL;");
            System.out.println("Alter the " + tabName + " table..." + item);

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSetMetaData getTabColumns(String shopName, String tabName) {
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

    public Boolean isColumnExist(String shopName, String tabName, String columnName) {
        ResultSetMetaData metadata = getTabColumns(shopName, tabName);
        Boolean isExist = false;
        try {
            for (int i = 3; i <= metadata.getColumnCount(); i++) {
                String colName = metadata.getColumnName(i);
                if (colName.equalsIgnoreCase(columnName)) {
                    isExist = true;
                }
            }
            return isExist;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Boolean isDateExist(String shopName, String tabName, String date) {
        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            if (tabName.equals("From Report")) {
                tabName = "TillReport";
            } else if (tabName.equals("From BackOffice")) {
                tabName = "TillBackOffice";
            }
            System.out.println(tabName);
            Boolean isExist = false;
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM " + tabName + " WHERE Date='" + date + "'");
            if (res.next()) {
                isExist = true;
            }
            return isExist;

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void insertValuesTabTable(String shopName, String tabName, String date, HashMap<String, Float> values) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        String fun = "INSERT INTO " + tabName + "( date, ";
        String value = "('" + date + "',";
        for (String i : values.keySet()) {
            fun = fun + i + ",";
            value = value + values.get(i) + ",";
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

    public ResultSet getValuesTabTable(String shopName, String tabName, String dateFrom, String dateTo) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM " + tabName + " WHERE Date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void createDefaultBank(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Bank", "FB_NETWEST");
        alterTabTable(shopName, "Bank", "FB_CashPlus");
        alterTabTable(shopName, "Bank", "FB_ElevenCard");
        alterTabTable(shopName, "Bank", "FB_MilkVouture");
        alterTabTable(shopName, "Bank", "MI_PayZone");
        alterTabTable(shopName, "Bank", "MI_NoteMachine");
        alterTabTable(shopName, "Bank", "SMO_PayPoint");
        alterTabTable(shopName, "Bank", "SMO_PayZone");
        alterTabTable(shopName, "Bank", "SMO_Oyster");
        alterTabTable(shopName, "Bank", "SMO_Camlot");
        alterTabTable(shopName, "Bank", "EM_SalarayMike");
        alterTabTable(shopName, "Bank", "EM_SalarySathees");
        alterTabTable(shopName, "Bank", "EM_CapitalGains");
        alterTabTable(shopName, "Bank", "EM_BT");
        alterTabTable(shopName, "Bank", "EM_Nest");
        alterTabTable(shopName, "Bank", "EM_Rent");
        alterTabTable(shopName, "Bank", "EM_Water");
        alterTabTable(shopName, "Bank", "EM_Alarm");
        alterTabTable(shopName, "Bank", "EM_Electric");
        alterTabTable(shopName, "Bank", "EM_ToiletBlock");
        alterTabTable(shopName, "Bank", "EY_ShopInsurance");
        alterTabTable(shopName, "Bank", "EY_BIFFA");
        alterTabTable(shopName, "Bank", "EY_Buil");
        alterTabTable(shopName, "Bank", "EY_OffFee");
        alterTabTable(shopName, "Bank", "EB_ElevenCharge");
        alterTabTable(shopName, "Bank", "EB_CardMachine");
        alterTabTable(shopName, "Bank", "EB_BankCharge");
        alterTabTable(shopName, "Bank", "EB_PayZoneRental");
        alterTabTable(shopName, "Bank", "P_CostCutter");
        alterTabTable(shopName, "Bank", "P_NI");
        alterTabTable(shopName, "Bank", "P_BestWay");
        alterTabTable(shopName, "Bank", "PB_BorrowMoney");
    }

//    public void createDefaultPetty(String shopName) {
//        if (con == null || !connectedShop.equals(shopName)) {
//            getConnection(shopName);
//        }
//        alterTabTable(shopName, "Petty", "Cash");
//        alterTabTable(shopName, "Petty", "Coin");
//        alterTabTable(shopName, "Petty", "BE_IOU_Paid");
//        alterTabTable(shopName, "Petty", "CC_Ambiant");
//        alterTabTable(shopName, "Petty", "CC_Chilled");
//        alterTabTable(shopName, "Petty", "CC_Frozen");
//        alterTabTable(shopName, "Petty", "CB_Payback");
//        alterTabTable(shopName, "Petty", "CCard_Barrow");
//        alterTabTable(shopName, "Petty", "CCB_Payback");
//        alterTabTable(shopName, "Petty", "IOU_Payback");
//        alterTabTable(shopName, "Petty", "P_CostCutter");
//        alterTabTable(shopName, "Petty", "P_Dhamecha");
//        alterTabTable(shopName, "Petty", "P_BeerShop");
//        alterTabTable(shopName, "Petty", "P_Vegetable");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        alterTabTable(shopName, "Petty", "");
//        
//    }
    public void createDefaultTill(String shopName, String tableType) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, tableType, "YesterdayTillCount");
        alterTabTable(shopName, tableType, "TodayTillCount");
        alterTabTable(shopName, tableType, "Cash");
        alterTabTable(shopName, tableType, "Coin");
        alterTabTable(shopName, tableType, "Card");
        alterTabTable(shopName, tableType, "VoucherMilk");
        alterTabTable(shopName, tableType, "VoucherPayPoint");
        alterTabTable(shopName, tableType, "RefundGoods");
        alterTabTable(shopName, tableType, "RefundServices");
        alterTabTable(shopName, tableType, "RefundAccountCredit");
        alterTabTable(shopName, tableType, "Purchase");
        alterTabTable(shopName, tableType, "Expenditure");
        alterTabTable(shopName, tableType, "AccPay");
        alterTabTable(shopName, tableType, "CashBack");
        alterTabTable(shopName, tableType, "InstantPayOut");
        alterTabTable(shopName, tableType, "LottaryPayOut");
        alterTabTable(shopName, tableType, "InsLottary");
        alterTabTable(shopName, tableType, "Lottary");
        alterTabTable(shopName, tableType, "Oyster");
        alterTabTable(shopName, tableType, "PayPoint");
        alterTabTable(shopName, tableType, "PayZone");
    }

    public void createDefaultSheet2(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Sheet2", "CommisionPayPoint");
        alterTabTable(shopName, "Sheet2", "CommisionLottary");
        alterTabTable(shopName, "Sheet2", "CommisionOyster");
        alterTabTable(shopName, "Sheet2", "SC_PayPoint");
        alterTabTable(shopName, "Sheet2", "SC_Lottary");
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
        createStaff(shopName);
        createStaffTime(shopName);
        createTabTable(shopName, "Expenditure");
        createTabTable(shopName, "Purcharse");
        createTabTable(shopName, "TillReport");
        createDefaultTill(shopName, "TillReport");
        createTabTable(shopName, "TillBackOffice");
        createDefaultTill(shopName, "TillBackOffice");
        createTabTable(shopName, "Bank");
        createDefaultBank(shopName);
        createTabTable(shopName, "Sheet2");
        createDefaultSheet2(shopName);
        createTabTable(shopName, "Petty");
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

    public void logout() throws SQLException {
        con.close();
    }

    public String getUserType(String shopName, String username, String password) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        String role = "";
        try {
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("select * from user where username='" + username + "'and password='" + password + "'");
            while (res.next()) {
                role = res.getString("role");
            }
        } catch (Exception e) {

        }
        return role;
    }

    public void dropTable(String shopName, String tableName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        try {
            Statement state = con.createStatement();
            state.executeUpdate("DROP TABLE " + tableName);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

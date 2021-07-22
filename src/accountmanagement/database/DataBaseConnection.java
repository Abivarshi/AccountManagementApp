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
import java.util.List;
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
            state2.executeUpdate("CREATE TABLE user(id integer,"
                    + "username varchar(60)," + "password varchar(60)," + "role varchar(60),"
                    + "primary key (id));");

        }
    }

    public ResultSet addUser(String shopName, String username, String password, String role) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?);");
        prep.setString(2, username);
        prep.setString(3, password);
        prep.setString(4, role);
        prep.execute();

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT * FROM user WHERE username='" + username + "'");
        return res;
    }

    public ResultSet addStaff(String shopName, String staffName, float salaryPercentage, Boolean till, Boolean floor, Boolean cashCarry, Boolean management) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        PreparedStatement prep = con.prepareStatement("INSERT INTO Staff VALUES(?,?,?,?,?,?,?);");
        prep.setString(2, staffName);
        prep.setFloat(3, salaryPercentage);
        prep.setBoolean(4, till);
        prep.setBoolean(5, floor);
        prep.setBoolean(6, cashCarry);
        prep.setBoolean(7, management);
        prep.execute();

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT * FROM Staff WHERE staffName='" + staffName + "'");
        return res;
    }

    public Boolean login(String shopName, String username, String password) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM user WHERE username='" + username + "'");
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
        PreparedStatement prep = con.prepareStatement("INSERT INTO Staff VALUES(?,?,?,?,?,?,?);");
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
                    + "Hours FLOAT,"
                    + "primary key (id));");
        }
    }

    public void insertStaffTime(String shopName, String date, String staffName, String staffType, Float start, Float end, Float hours) throws ClassNotFoundException, SQLException {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        PreparedStatement prep = con.prepareStatement("INSERT INTO StaffTime (Date, StaffName, Type, StartTime, EndTime, Hours) VALUES ("
                + "'" + date + "', '" + staffName + "', '" + staffType + "', " + start + ", " + end + ", " + hours + ");");

        prep.execute();
    }

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

    public void dropTabColumnTable(String shopName, String tabName, String item) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        try {
            Statement state = con.createStatement();
            state.executeUpdate("ALTER TABLE " + tabName + " DROP " + item + ";");
            System.out.println("Alter the " + tabName + " table to remove" + item);

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void createDetailTable(String shopName, String name) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }

        ResultSet res;
        try {
            Statement state = con.createStatement();
            res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='" + name + "'");
            if (!res.next()) {
                System.out.println("Building the " + name + " table...");

                Statement state2 = con.createStatement();
                if(name.equalsIgnoreCase("ExpenditureDetail") || name.equalsIgnoreCase("PurchaseDetail"))
                    state2.executeUpdate("CREATE TABLE " + name + "(id integer,"
                        + "Item VARCHAR(255),"
                        + "Name VARCHAR(255),"
                        + "primary key (id));");
                else
                    state2.executeUpdate("CREATE TABLE " + name + "(id integer,"
                        + "Item VARCHAR(255),"
                        + "Name VARCHAR(255),"
                        + "Type VARCHAR(255),"
                        + "primary key (id));");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertDetailTable(String shopName, String item, String name, String type, String table){
        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            
            PreparedStatement prep = con.prepareStatement("INSERT INTO " + table + " (Item, Name, Type) VALUES ("
                    + "'" + item + "', '" + name + "', '" + type + "');");
            
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertEPDetailTable(String shopName, String item, String name, String table){
        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            
            PreparedStatement prep = con.prepareStatement("INSERT INTO " + table + " (Item, Name) VALUES ("
                    + "'" + item + "', '" + name + "');");
            
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getDeatilTableValue(String shopName, String tableName) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT * FROM " + tableName);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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

        String fun = "INSERT INTO " + tabName + "( Date, ";
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
            ResultSet res = state.executeQuery("SELECT * FROM " + tabName + 
                    " WHERE Date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'" +
                    " ORDER BY Date ASC");
            
            return res;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getOneColValueTabTable(String shopName, String tableName, String colName, String dateFrom, String dateTo) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT " + colName + ", Date FROM " + tableName + 
                    " WHERE Date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'" +
                    " ORDER BY Date ASC");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet getNColValueTabTable(String shopName, String tableName, List<String> colName, String dateFrom, String dateTo) {

        try {
            if (con == null || !connectedShop.equals(shopName)) {
                getConnection(shopName);
            }
            
            String queryString = "SELECT ";
            
            for (String col : colName)
                queryString = queryString + col + ", ";
            
            queryString = queryString + "Date FROM " + tableName + 
                    " WHERE Date BETWEEN '" + dateFrom + "' AND '" + dateTo + "'" +
                    " ORDER BY Date ASC";

            Statement state = con.createStatement();
            ResultSet res = state.executeQuery(queryString);
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
        alterTabTable(shopName, "Bank", "FB_NATWEST");
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
        alterTabTable(shopName, "Bank", "SubPurchase");
        alterTabTable(shopName, "Bank", "SubExpenditure");
        alterTabTable(shopName, "Bank", "Balance");
    }

    public void createDefaultPetty(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Petty", "CC_BE_IOU_Paid");
        alterTabTable(shopName, "Petty", "CC_BE_IOU");
        alterTabTable(shopName, "Petty", "CC_Ambiant");
        alterTabTable(shopName, "Petty", "CC_Chilled");
        alterTabTable(shopName, "Petty", "CC_Frozen");
        alterTabTable(shopName, "Petty", "BO_Cash");
        alterTabTable(shopName, "Petty", "PB_Cash");
        alterTabTable(shopName, "Petty", "BO_CCard");
        alterTabTable(shopName, "Petty", "PB_CCard");
        alterTabTable(shopName, "Petty", "BO_IOU");
        alterTabTable(shopName, "Petty", "PB_IOU");
        alterTabTable(shopName, "Petty", "P_CostCutter");
        alterTabTable(shopName, "Petty", "P_Dhamecha");
        alterTabTable(shopName, "Petty", "P_BeerShop");
        alterTabTable(shopName, "Petty", "P_Vegetable");
        alterTabTable(shopName, "Petty", "P_Wannis");
        alterTabTable(shopName, "Petty", "P_Bookers");
        alterTabTable(shopName, "Petty", "P_BestWay");
        alterTabTable(shopName, "Petty", "P_Beer");
        alterTabTable(shopName, "Petty", "P_DPR");
        alterTabTable(shopName, "Petty", "E_CapitalGains");
        alterTabTable(shopName, "Petty", "E_Diesel");
        alterTabTable(shopName, "Petty", "E_Shelf");
        alterTabTable(shopName, "Petty", "B_NATWEST");
        alterTabTable(shopName, "Petty", "B_CashPlus");
        alterTabTable(shopName, "Petty", "SubPurchase");
        alterTabTable(shopName, "Petty", "SubExpenditure");
        alterTabTable(shopName, "Petty", "PettyBalance");
        
    }
    
    public void createDefaultTill(String shopName, String tableType) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, tableType, "R_YesterdayTillCount1");
        alterTabTable(shopName, tableType, "R_TodayTillCount1");
        alterTabTable(shopName, tableType, "R_YesterdayTillCount2");
        alterTabTable(shopName, tableType, "R_TodayTillCount2");
        alterTabTable(shopName, tableType, "R_Cash");
        alterTabTable(shopName, tableType, "R_Coin");
        alterTabTable(shopName, tableType, "R_Card");
        alterTabTable(shopName, tableType, "R_VoucherMilk");
        alterTabTable(shopName, tableType, "R_VoucherPayPoint");
        alterTabTable(shopName, tableType, "R_RefundGoods");
        alterTabTable(shopName, tableType, "R_RefundServices");
        alterTabTable(shopName, tableType, "R_AccountCredit");
        alterTabTable(shopName, tableType, "R_Purchase");
        alterTabTable(shopName, tableType, "R_Expenditure");
        alterTabTable(shopName, tableType, "R_AccPay");
        alterTabTable(shopName, tableType, "R_CashBack");
        alterTabTable(shopName, tableType, "R_InstantPayOut");
        alterTabTable(shopName, tableType, "R_LottaryPayOut");
        alterTabTable(shopName, tableType, "R_InsLottary");
        alterTabTable(shopName, tableType, "R_Lottary");
        alterTabTable(shopName, tableType, "R_Oyster");
        alterTabTable(shopName, tableType, "R_PayPoint");
        alterTabTable(shopName, tableType, "R_PayZone");

        alterTabTable(shopName, tableType, "Alcohol");
        alterTabTable(shopName, tableType, "Groceries");
        alterTabTable(shopName, tableType, "Tobacco");
        alterTabTable(shopName, tableType, "CallingCard");

        alterTabTable(shopName, tableType, "BO_InsLottary");
        alterTabTable(shopName, tableType, "BO_Lottary");
        alterTabTable(shopName, tableType, "BO_Oyster");
        alterTabTable(shopName, tableType, "BO_PayPoint");
        alterTabTable(shopName, tableType, "BO_PayZone");
        alterTabTable(shopName, tableType, "BO_AccPay");
        alterTabTable(shopName, tableType, "BO_InstantPayOut");
        alterTabTable(shopName, tableType, "BO_LottaryPayOut");
        alterTabTable(shopName, tableType, "BO_Cash");
        alterTabTable(shopName, tableType, "BO_Card");
        alterTabTable(shopName, tableType, "BO_AccountCredit");
        alterTabTable(shopName, tableType, "BO_CashBack");
        alterTabTable(shopName, tableType, "BO_VoucherMilk");
        alterTabTable(shopName, tableType, "BO_VoucherPayPoint");
        
        alterTabTable(shopName, tableType, "SO_Lottary");
        alterTabTable(shopName, tableType, "SO_Oyster");
        alterTabTable(shopName, tableType, "SO_PayPoint");
        alterTabTable(shopName, tableType, "SO_PayZone");
        alterTabTable(shopName, tableType, "SO_AccPay");
        alterTabTable(shopName, tableType, "SO_InstantPayOut");
        alterTabTable(shopName, tableType, "SO_LottaryPayOut");
        alterTabTable(shopName, tableType, "SO_Cash");
        alterTabTable(shopName, tableType, "SO_Card");
        alterTabTable(shopName, tableType, "SO_CashBack");
        alterTabTable(shopName, tableType, "SO_VoucherMilk");
        alterTabTable(shopName, tableType, "SO_VoucherPayPoint");
        alterTabTable(shopName, tableType, "SO_AccountCredit");
        alterTabTable(shopName, tableType, "SO_Till");
        alterTabTable(shopName, tableType, "SO_Pay");

    }

    public void createDefaultExpenditure(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Expenditure", "Staff1");
        alterTabTable(shopName, "Expenditure", "Staff2");
        alterTabTable(shopName, "Expenditure", "Staff3");
        alterTabTable(shopName, "Expenditure", "Staff4");
        alterTabTable(shopName, "Expenditure", "Staff5");
        alterTabTable(shopName, "Expenditure", "Staff6");
        alterTabTable(shopName, "Expenditure", "Staff7");
        alterTabTable(shopName, "Expenditure", "Staff8");
        alterTabTable(shopName, "Expenditure", "CapitalGains");
        alterTabTable(shopName, "Expenditure", "Van");
        alterTabTable(shopName, "Expenditure", "Diesel");
        alterTabTable(shopName, "Expenditure", "VanRepair");
        alterTabTable(shopName, "Expenditure", "FridgeRepair");
        alterTabTable(shopName, "Expenditure", "ShudderRepair");
        alterTabTable(shopName, "Expenditure", "ElectricRepair");
        alterTabTable(shopName, "Expenditure", "Total");
    }

    public void createDefaultPurchase(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Purchase", "Sanwich");
        alterTabTable(shopName, "Purchase", "Milk");
        alterTabTable(shopName, "Purchase", "TeastyBread");
        alterTabTable(shopName, "Purchase", "Camlot");
        alterTabTable(shopName, "Purchase", "Cake");
        alterTabTable(shopName, "Purchase", "Damecha");
        alterTabTable(shopName, "Purchase", "Vegetable");
        alterTabTable(shopName, "Purchase", "Eggs");
        alterTabTable(shopName, "Purchase", "Beer");
        alterTabTable(shopName, "Purchase", "Rizzla");
        alterTabTable(shopName, "Purchase", "Tesco");
        alterTabTable(shopName, "Purchase", "CallingCard");
        alterTabTable(shopName, "Purchase", "BasicNeeds");
        alterTabTable(shopName, "Purchase", "Phonixx");
        alterTabTable(shopName, "Purchase", "NBC");
        alterTabTable(shopName, "Purchase", "Thief");
        alterTabTable(shopName, "Purchase", "AmericanFanyta");
        alterTabTable(shopName, "Purchase", "VnSales");
        alterTabTable(shopName, "Purchase", "Ice");
        alterTabTable(shopName, "Purchase", "Buzz");
        alterTabTable(shopName, "Purchase", "CardConnection");
        alterTabTable(shopName, "Purchase", "AmericanSweets");
        alterTabTable(shopName, "Purchase", "MilkVouture");
        alterTabTable(shopName, "Purchase", "PhoneCharger");
        alterTabTable(shopName, "Purchase", "Total");
    }
    
        public void createDefaultSales(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        alterTabTable(shopName, "Sales", "Damaged");
        alterTabTable(shopName, "Sales", "OutOfDate");
        alterTabTable(shopName, "Sales", "ShopUse");
        alterTabTable(shopName, "Sales", "Total");
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
        alterTabTable(shopName, "Sheet2", "ComTotal");
        alterTabTable(shopName, "Sheet2", "ServiceTotal");
//        alterTabTable(shopName, "Sheet2", "OysterDD");
//        alterTabTable(shopName, "Sheet2", "PaypointDD");
//        alterTabTable(shopName, "Sheet2", "LotteryDD");
       
    }
    
    public void insertDefaultBankDetail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        
        insertDetailTable(shopName, "NATWEST", "FB_NETWEST", "From Bank", "BankDetail");
        insertDetailTable(shopName, "Cash Plus", "FB_CashPlus", "From Bank", "BankDetail");
        insertDetailTable(shopName, "Eleven Card", "FB_ElevenCard", "From Bank", "BankDetail");
        insertDetailTable(shopName, "Milk Vouture", "FB_MilkVouture", "From Bank", "BankDetail");
        insertDetailTable(shopName, "Pay Zone", "MI_PayZone", "Money In (Commission)", "BankDetail");
        insertDetailTable(shopName, "Note Machine", "MI_NoteMachine", "Money In (Commission)", "BankDetail");
        insertDetailTable(shopName, "Pay Point", "SMO_PayPoint", "Service Money Out", "BankDetail");
        insertDetailTable(shopName, "Pay Zone", "SMO_PayZone", "Service Money Out", "BankDetail");
        insertDetailTable(shopName, "Oyster", "SMO_Oyster", "Service Money Out", "BankDetail");
        insertDetailTable(shopName, "Camlot", "SMO_Camlot", "Service Money Out", "BankDetail");
        insertDetailTable(shopName, "Salary Mike", "EM_SalarayMike", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Salary Sathees", "EM_SalarySathees", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Capital Gains", "EM_CapitalGains", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "BT", "EM_BT", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Nest", "EM_Nest", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Rent", "EM_Rent", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Water", "EM_Water", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Alarm", "EM_Alarm", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Electric", "EM_Electric", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Toilet Block", "EM_ToiletBlock", "Expenditure Money Out (Monthly)", "BankDetail");
        insertDetailTable(shopName, "Shop Insurance", "EY_ShopInsurance", "Expenditure Money Out (Yearly)", "BankDetail");
        insertDetailTable(shopName, "BIFFA", "EY_BIFFA", "Expenditure Money Out (Yearly)", "BankDetail");
        insertDetailTable(shopName, "BUIL/Insu", "EY_Buil", "Expenditure Money Out (Yearly)", "BankDetail");
        insertDetailTable(shopName, "Off/Fee", "EY_OffFee", "Expenditure Money Out (Yearly)", "BankDetail");
        insertDetailTable(shopName, "Eleven Charge", "EB_ElevenCharge", "Expenditure/ Bank Charge", "BankDetail");
        insertDetailTable(shopName, "Card Mechain", "EB_CardMachine", "Expenditure/ Bank Charge", "BankDetail");
        insertDetailTable(shopName, "Bank Charge", "EB_BankCharge", "Expenditure/ Bank Charge", "BankDetail");
        insertDetailTable(shopName, "PayZone Rental", "EB_PayZoneRental", "Expenditure/ Bank Charge", "BankDetail");
        insertDetailTable(shopName, "Costcutter", "P_CostCutter", "Purchase", "BankDetail");
        insertDetailTable(shopName, "NI", "P_NI", "Purchase", "BankDetail");
        insertDetailTable(shopName, "BestWay", "P_BestWay", "Purchase", "BankDetail");
        insertDetailTable(shopName, "Borrow Money", "PB_BorrowMoney", "Pay Back", "BankDetail");
        insertDetailTable(shopName, "SubTotal Purchase", "SubPurchase", "Summary", "BankDetail");
        insertDetailTable(shopName, "SubTotal Expenditure", "SubExpenditure", "Summary", "BankDetail");
        insertDetailTable(shopName, "Balance", "Balance", "Summary", "BankDetail");
    }
     
    public void insertDefaultPettyDetail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        
        insertDetailTable(shopName, "BE IOU Paid", "CC_BE_IOU_Paid", "BE IOU", "PettyDetail");
        insertDetailTable(shopName, "BE IOU", "CC_BE_IOU", "Summary", "PettyDetail");
        insertDetailTable(shopName, "Ambiant", "CC_Ambiant", "Cost Cutter", "PettyDetail");
        insertDetailTable(shopName, "Chilled", "CC_Chilled", "Cost Cutter", "PettyDetail");
        insertDetailTable(shopName, "Frozen", "CC_Frozen", "Cost Cutter", "PettyDetail");
        insertDetailTable(shopName, "Cash", "BO_Cash", "Borrow", "PettyDetail");
        insertDetailTable(shopName, "Cash", "PB_Cash", "Pay Back", "PettyDetail");
        insertDetailTable(shopName, "C/Card", "BO_CCard", "Borrow", "PettyDetail");
        insertDetailTable(shopName, "C/Card", "PB_CCard", "Pay Back", "PettyDetail");
        insertDetailTable(shopName, "IOU", "BO_IOU", "Borrow", "PettyDetail");
        insertDetailTable(shopName, "IOU", "PB_IOU", "Pay Back", "PettyDetail");
        insertDetailTable(shopName, "Cost Cutter", "P_CostCutter", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Dhamecha", "P_Dhamecha", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Beer Shop", "P_BeerShop", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Vegetable", "P_Vegetable", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Wannis", "P_Wannis", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Bookers", "P_Bookers", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "BestWay", "P_BestWay", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Beer", "P_Beer", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "DPR", "P_DPR", "Purchase", "PettyDetail");
        insertDetailTable(shopName, "Capital Gains", "E_CapitalGains", "Expenditure", "PettyDetail");
        insertDetailTable(shopName, "Diesel", "E_Diesel", "Expenditure", "PettyDetail");
        insertDetailTable(shopName, "Shelf", "E_Shelf", "Expenditure", "PettyDetail");
        insertDetailTable(shopName, "NATWEST", "B_NATWEST", "Banking", "PettyDetail");
        insertDetailTable(shopName, "Cash Plus", "B_CashPlus", "Banking", "PettyDetail");
        insertDetailTable(shopName, "SubTotal Purchase", "SubPurchase", "Summary", "PettyDetail");
        insertDetailTable(shopName, "SubTotal Expenditure", "SubExpenditure", "Summary", "PettyDetail");
        insertDetailTable(shopName, "Petty Balance", "PettyBalance", "Summary", "PettyDetail");
    }
    
    public void insertDefaultSheet2Detail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        insertDetailTable(shopName, "Pay Point", "CommisionPayPoint", "Commision", "Sheet2Detail");
        insertDetailTable(shopName, "Lottary", "CommisionLottary", "Commision", "Sheet2Detail");
        insertDetailTable(shopName, "Oyster", "CommisionOyster", "Commision", "Sheet2Detail");
        insertDetailTable(shopName, "Pay Point", "SC_PayPoint", "Service Charge", "Sheet2Detail");
        insertDetailTable(shopName, "Lottary", "SC_Lottary", "Service Charge", "Sheet2Detail");
        insertDetailTable(shopName, "Commission Total", "ComTotal", "Summary", "Sheet2Detail");
        insertDetailTable(shopName, "Service Charge Total", "ServiceTotal", "Summary", "Sheet2Detail");
//        insertDetailTable(shopName, "Oyster DD", "OysterDD", "Summary", "Sheet2Detail");
//        insertDetailTable(shopName, "Paypoint DD", "PaypointDD", "Summary", "Sheet2Detail");
//        insertDetailTable(shopName, "Lottery DD", "LotteryDD", "Summary", "Sheet2Detail");
    }

    public void insertDefaultExpenditureDetail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        insertEPDetailTable(shopName, "Mike", "Staff1", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Sathees", "Staff2", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Tharsan", "Staff3", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Karan", "Staff4", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Suri", "Staff5", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Basker", "Staff6", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Viji", "Staff7", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Sutha", "Staff8", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Capital Gains", "CapitalGains", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Van", "Van", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Diesel", "Diesel", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Van Repair", "VanRepair", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Fridge Repair", "FridgeRepair", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Shudder Repair", "ShudderRepair", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Electric Repair", "ElectricRepair", "ExpenditureDetail");
        insertEPDetailTable(shopName, "Total", "Total", "ExpenditureDetail");
    }

    public void insertDefaultPurchaseDetail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        insertEPDetailTable(shopName, "Sanwich", "Sanwich", "PurchaseDetail");
        insertEPDetailTable(shopName, "Milk", "Milk", "PurchaseDetail");
        insertEPDetailTable(shopName, "Teasty Bread", "TeastyBread", "PurchaseDetail");
        insertEPDetailTable(shopName, "Camlot", "Camlot", "PurchaseDetail");
        insertEPDetailTable(shopName, "Cake", "Cake", "PurchaseDetail");
        insertEPDetailTable(shopName, "Damecha", "Damecha", "PurchaseDetail");
        insertEPDetailTable(shopName, "Vegetable", "Vegetable", "PurchaseDetail");
        insertEPDetailTable(shopName, "Eggs", "Eggs", "PurchaseDetail");
        insertEPDetailTable(shopName, "Beer", "Beer", "PurchaseDetail");
        insertEPDetailTable(shopName, "Rizzla", "Rizzla", "PurchaseDetail");
        insertEPDetailTable(shopName, "Tesco", "Tesco", "PurchaseDetail");
        insertEPDetailTable(shopName, "Calling Card", "CallingCard", "PurchaseDetail");
        insertEPDetailTable(shopName, "Basic Needs", "BasicNeeds", "PurchaseDetail");
        insertEPDetailTable(shopName, "Phonixx", "Phonixx", "PurchaseDetail");
        insertEPDetailTable(shopName, "NBC", "NBC", "PurchaseDetail");
        insertEPDetailTable(shopName, "Thief", "Thief", "PurchaseDetail");
        insertEPDetailTable(shopName, "American Fanyta", "AmericanFanyta", "PurchaseDetail");
        insertEPDetailTable(shopName, "Vn Sales", "VnSales", "PurchaseDetail");
        insertEPDetailTable(shopName, "Ice", "Ice", "PurchaseDetail");
        insertEPDetailTable(shopName, "Buzz", "Buzz", "PurchaseDetail");
        insertEPDetailTable(shopName, "Card Connection", "CardConnection", "PurchaseDetail");
        insertEPDetailTable(shopName, "American Sweets", "AmericanSweets", "PurchaseDetail");
        insertEPDetailTable(shopName, "Milk Vouture", "MilkVouture", "PurchaseDetail");
        insertEPDetailTable(shopName, "Phone Charger", "PhoneCharger", "PurchaseDetail");
        insertEPDetailTable(shopName, "Total", "Total", "PurchaseDetail");
    }
    
    public void insertDefaultSalesDetail(String shopName) {
        if (con == null || !connectedShop.equals(shopName)) {
            getConnection(shopName);
        }
        insertEPDetailTable(shopName, "Damaged", "Damaged", "SalesDetail");
        insertEPDetailTable(shopName, "Out of Date", "OutOfDate", "SalesDetail");
        insertEPDetailTable(shopName, "Shop Use", "ShopUse", "SalesDetail");
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
        createDefaultExpenditure(shopName);
        createTabTable(shopName, "Purchase");
        createDefaultPurchase(shopName);
        createTabTable(shopName, "Till");
        createDefaultTill(shopName, "Till");
        createTabTable(shopName, "Bank");
        createDefaultBank(shopName);
        createTabTable(shopName, "Sheet2");
        createDefaultSheet2(shopName);
        createTabTable(shopName, "Petty");
        createDefaultPetty(shopName);
        createTabTable(shopName, "Sales");
        createDefaultSales(shopName);
        createDetailTable(shopName, "BankDetail");
        insertDefaultBankDetail(shopName);
        createDetailTable(shopName, "PettyDetail");
        insertDefaultPettyDetail(shopName);
        createDetailTable(shopName, "Sheet2Detail");
        insertDefaultSheet2Detail(shopName);
        createDetailTable(shopName, "ExpenditureDetail");
        insertDefaultExpenditureDetail(shopName);
        createDetailTable(shopName, "PurchaseDetail");
        insertDefaultPurchaseDetail(shopName);
        createDetailTable(shopName, "SalesDetail");
        insertDefaultSalesDetail(shopName);
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
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
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

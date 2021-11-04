/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement;

import accountmanagement.database.DataBaseConnection;
import accountmanagement.jframe.Dashboard;
import accountmanagement.jframe.LoginPage;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class AccountManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataBaseConnection db = new DataBaseConnection();
        ResultSet rs;

        try {
            
//        db.alterTabTable("Shop1", "Sales", "CustomerCount");
//        db.dropTable("Shop1", "Staff");
//        db.createStaff("Shop1");
        db.dropTable("Shop1", "StaffTime");
        db.createStaffTime("Shop1");
//        db.createDetailTable("Shop1", "PettyDetail");
//        db.insertDefaultPettyDetail("Shop1");

//            db.createStaffTime("Shop1");
//            db.createTabTable("Shop1", "Sheet2");
//            db.createDefaultSheet2("Shop1");
//            db.createShop("Shop1");
//            rs = db.addUser("Shop1", "a", "a", "admin");
//            db.addUser("Shop1", "u", "u", "user");
//
//            while (rs.next()) {
//                System.out.println(rs.getString("username") + " " + rs.getString("role"));
//            }

//            db.createTabDetailTable("Shop1");
//            db.createStaffSummary("Shop1");
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.run();
            new Dashboard("Shop1", "admin","a").setVisible(true);
//            new Till("Shop1").setVisible(true);
//            System.out.print(db.getUserType("Shop1", "a", "a"));
    }
    
}

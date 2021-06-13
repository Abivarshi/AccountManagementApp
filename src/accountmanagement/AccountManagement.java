/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement;

import accountmanagement.database.DataBaseConnection;
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
//        DataBaseConnection db = new DataBaseConnection();
//        ResultSet rs;
//
//        try {
//            db.createUserTable("shop2");
//            rs = db.addUser("shop1", "admin", "admin", "admin");
//
//            while (rs.next()) {
//                System.out.println(rs.getString("username") + " " + rs.getString("role"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        LoginPage loginPage = new LoginPage();
        loginPage.run();
    }
    
}

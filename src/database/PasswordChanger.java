/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class PasswordChanger {
    public static boolean changePassword(String email,String password)
    {
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
          String query = "update userdatatest set password=?"+","+"repassword=?"+"where email=?"; 
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1,password);
          ps.setString(2,password);
          ps.setString(3,email);
          ps.executeUpdate();
          return true;
        }
        catch(SQLException sq)
        {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PasswordChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  /*  public static void main(String[] args) {
        changePassword("hritik08@gmail.com","hritik123");
    }*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class EmailCheckerDB {
    public static boolean emailDB(String email)
    {
        try 
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
          String query = "select email from userdatatest where email=?";
          String em = "";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1,email);
          ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                em = rs.getString(1);
            }
           
          if(em.equals(email)) return true;
        }
        catch(SQLException sq)
        {
            System.out.println(sq);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PasswordChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 /*   public static void main(String[] args) {
        if(emailDB("af")) System.out.println("Exist");
        else System.out.println("DONT");
    }*/
}
